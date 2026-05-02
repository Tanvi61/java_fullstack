import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // ✅ FIX
import { Router } from '@angular/router';
import { ApiService } from '../../services/api';

@Component({
  selector: 'app-health',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule  // ✅ REQUIRED for *ngIf and date pipe
  ],
  templateUrl: './health.html',
  styleUrl: './health.css'
})
export class HealthComponent implements OnInit {

  heartRate: number | null = null;
  sleep: number | null = null;
  message = '';
  lastHealth: any = null;

  constructor(private api: ApiService, private router: Router) {}

  ngOnInit() {
    const userId = Number(localStorage.getItem('userId'));
    if (!Number.isFinite(userId) || userId <= 0) {
      return;
    }

    this.api.getHealth(userId).subscribe((res: any) => {
      const payload = res?.data ?? res?.result ?? res;

      if (Array.isArray(payload) && payload.length > 0) {
        this.lastHealth = this.mapHealth(payload[payload.length - 1]);
      } else if (payload && typeof payload === 'object') {
        this.lastHealth = this.mapHealth(payload);
      } else {
        this.lastHealth = null;
      }
    });
  }

  private mapHealth(item: any) {
    return {
      heartRate: item.heartRate ?? item.heart_rate ?? item.heart ?? item.hr ?? null,
      sleepHours: item.sleepHours ?? item.sleep_hours ?? item.sleep ?? item.hours ?? null,
      timestamp: item.timestamp ?? item.createdAt ?? item.date
    };
  }

  submit() {
    if (this.heartRate == null || this.sleep == null) {
      this.message = 'Please fill all fields ❌';
      return;
    }

    const userId = Number(localStorage.getItem('userId'));

    const data = {
      heartRate: this.heartRate,
      sleepHours: this.sleep, // ✅ IMPORTANT FIX
      user: { id: userId }
    };

    this.api.saveHealth(data).subscribe({
      next: () => {
        this.message = 'Saved successfully ✅';
        this.heartRate = null;
        this.sleep = null;
        this.ngOnInit();
      },
      error: () => {
        this.message = 'Error saving data ❌';
      }
    });
  }

  goBack() {
    this.router.navigate(['/dashboard']);
  }
}