import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}
login(data: any) {
  return this.http.post('http://localhost:8080/api/user/login', data);
}

  register(data: any) {
  return this.http.post('http://localhost:8080/api/user/register', data);
}

saveMood(data: any) {
  return this.http.post('http://localhost:8080/api/mood', data);
}

getMood(userId: number) {
  return this.http.get(`http://localhost:8080/api/mood/${userId}`);
}


getHealth(userId: number) {
  return this.http.get(`http://localhost:8080/api/health/${userId}`);
}

saveHealth(data: any) {
  return this.http.post(`http://localhost:8080/api/health`, data);
}
}