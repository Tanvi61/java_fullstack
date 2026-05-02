import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class RegisterComponent {

  username = '';
  password = '';
  confirmPassword = '';
  message = '';

  constructor(private api: ApiService, private router: Router) {}

  register() {

    if (!this.username || !this.password || !this.confirmPassword) {
      this.message = 'All fields are required ❌';
      return;
    }

    if (this.password !== this.confirmPassword) {
      this.message = 'Passwords do not match ❌';
      return;
    }

    const data = {
      username: this.username,
      password: this.password
    };

    this.api.register(data).subscribe({
      next: () => {
        this.message = 'Registered Successfully ✅';
        setTimeout(() => this.router.navigate(['/']), 1500);
      },
      error: () => {
        this.message = 'Registration failed ❌';
      }
    });
  }

  goToLogin() {
    this.router.navigate(['/']);
  }
}