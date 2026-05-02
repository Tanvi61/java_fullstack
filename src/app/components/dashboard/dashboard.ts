import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import Chart from 'chart.js/auto';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api';

// ✅ Strong typing (recommended)
interface Health {
  heartRate?: number;
  sleepHours?: number;
  temperature?: number;
  timestamp?: string;
}

interface Mood {
  mood: string;
  note?: string;
  timestamp?: string;
}

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class DashboardComponent implements OnInit, AfterViewInit {

  @ViewChild('stressChart', { static: false }) stressChart?: ElementRef<HTMLCanvasElement>;
  private stressChartInstance?: Chart;

  mood: Mood | null = null;
  health: Health | null = null;
  username: string | null = '';
  stressLabels: string[] = [];
  stressData: number[] = [];

  constructor(private router: Router, private api: ApiService) {}

  ngOnInit() {
    const userIdStr = localStorage.getItem('userId');
    this.username = localStorage.getItem('username');

    // ❌ If not logged in → redirect
    if (!userIdStr || userIdStr === 'undefined' || userIdStr === 'null') {
      localStorage.clear();
      this.router.navigate(['/']);
      return;
    }

    const userId = Number(userIdStr);
    if (!Number.isFinite(userId) || userId <= 0) {
      localStorage.clear();
      this.router.navigate(['/']);
      return;
    }

    this.api.getMood(userId).subscribe((res: any) => {
      console.log('Mood', res);
      this.mood = this.normalizeResponse(res, item => this.mapMood(item));
    });

    this.api.getHealth(userId).subscribe((res: any) => {
      console.log('Health', res);

      const healthItems = this.normalizeArrayResponse(res);
      if (healthItems.length > 0) {
        this.health = this.mapHealth(healthItems[healthItems.length - 1]);
        this.buildStressChart(healthItems);
      } else {
        this.health = null;
      }
    });
  }

  private normalizeResponse<T>(res: any, mapper: (item: any) => T): T | null {
    const payload = res?.data ?? res?.result ?? res;

    if (Array.isArray(payload) && payload.length > 0) {
      return mapper(payload[payload.length - 1]);
    }

    if (payload && typeof payload === 'object') {
      return mapper(payload);
    }

    return null;
  }

  private normalizeArrayResponse(res: any): any[] {
    const payload = res?.data ?? res?.result ?? res;
    if (Array.isArray(payload)) {
      return payload;
    }
    if (payload && typeof payload === 'object') {
      return [payload];
    }
    return [];
  }

  private buildStressChart(items: any[]) {
    this.stressLabels = items.map((item, index) => {
      const date = item.timestamp ?? item.createdAt ?? item.date;
      return date ? new Date(date).toLocaleDateString('en-US', { month: 'short', day: 'numeric' }) : `Entry ${index + 1}`;
    });
    this.stressData = items.map(item => {
      const stress = item.stressRate ?? item.stress ?? item.stress_level ?? item.stressLevel;
      return Number(stress ?? item.heartRate ?? item.heart_rate ?? item.hr ?? 0);
    });
    this.updateStressChart();
  }

  private updateStressChart() {
    if (!this.stressChartInstance) {
      return;
    }
    this.stressChartInstance.data.labels = this.stressLabels;
    this.stressChartInstance.data.datasets[0].data = this.stressData;
    this.stressChartInstance.update();
  }

  private mapMood(item: any): Mood {
    return {
      mood: item.mood ?? item.emotion ?? item.status ?? 'N/A',
      note: item.note ?? item.notes ?? item.comment,
      timestamp: item.timestamp ?? item.createdAt ?? item.date
    };
  }

  private mapHealth(item: any): Health {
    return {
      heartRate: item.heartRate ?? item.heart_rate ?? item.heart ?? item.hr ?? null,
      sleepHours: item.sleepHours ?? item.sleep_hours ?? item.sleep ?? item.hours ?? null,
      temperature: item.temperature ?? item.temp ?? item.t ?? null,
      timestamp: item.timestamp ?? item.createdAt ?? item.date
    };
  }
  goToMood() {
    this.router.navigate(['/mood']);
  }

  goToHealth() {
    this.router.navigate(['/health']);
  }

  goToTrends() {
    this.router.navigate(['/trends']);
  }

  goToAI() {
    // Simple AI prediction based on recent health data
    const prediction = this.predictMood();
    alert(`AI Prediction: Your next mood might be "${prediction}". This is based on your recent health patterns.`);
  }

  private predictMood(): string {
    if (this.health && this.health.heartRate) {
      if (this.health.heartRate > 80) return 'Stressed';
      if (this.health.heartRate < 60) return 'Relaxed';
    }
    if (this.health && this.health.sleepHours) {
      if (this.health.sleepHours < 6) return 'Tired';
      if (this.health.sleepHours > 8) return 'Happy';
    }
    return 'Neutral';
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/']);
  }

  ngAfterViewInit() {
    const canvas = this.stressChart?.nativeElement;
    if (!canvas) {
      return;
    }

    this.stressChartInstance = new Chart(canvas, {
      type: 'line',
      data: {
        labels: this.stressLabels,
        datasets: [
          {
            label: 'Stress Level',
            data: this.stressData,
            borderWidth: 2,
            backgroundColor: 'rgba(66, 153, 225, 0.2)',
            borderColor: '#2b6cb0',
            tension: 0.35,
            fill: true
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            display: true
          }
        },
        scales: {
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: 'Stress / Heart Rate'
            }
          }
        }
      }
    });
  }
}