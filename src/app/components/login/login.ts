import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class LoginComponent {

  username = '';
  password = '';
  message = '';

constructor(private api: ApiService, public router: Router) {}  

login() {
  const data = {
    username: this.username,
    password: this.password
  };

  this.api.login(data).subscribe({
  next: (res: any) => {
    console.log('Login Response:', res); // DEBUG

    const userId = res?.id ?? res?.userId ?? res?.user?.id;
    const username = res?.username ?? res?.user?.username ?? res?.name ?? res?.user?.name;

    if (!userId || !username) {
      this.message = 'Login failed: invalid server response';
      return;
    }

    localStorage.setItem('userId', String(userId));
    localStorage.setItem('username', String(username));

    this.router.navigate(['/dashboard']);
  },
  error: () => {
    alert('Login failed');
  }
});
}
}