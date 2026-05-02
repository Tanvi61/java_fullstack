import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import Chart from 'chart.js/auto';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api';

@Component({
  selector: 'app-trends',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './trends.html',
  styleUrl: './trends.css'
})
export class TrendsComponent implements OnInit, AfterViewInit {

  @ViewChild('moodChart', { static: false }) moodChart?: ElementRef<HTMLCanvasElement>;
  @ViewChild('healthChart', { static: false }) healthChart?: ElementRef<HTMLCanvasElement>;
  private moodChartInstance?: Chart;
  private healthChartInstance?: Chart;

  moodData: any[] = [];
  healthData: any[] = [];
  moodLabels: string[] = [];
  healthLabels: string[] = [];
  moodValues: number[] = [];
  heartRateValues: number[] = [];
  sleepValues: number[] = [];

  constructor(private api: ApiService, private router: Router) {}

  ngOnInit() {
    const userIdStr = localStorage.getItem('userId');
    if (!userIdStr) {
      this.router.navigate(['/']);
      return;
    }
    const userId = Number(userIdStr);

    this.api.getMood(userId).subscribe((res: any) => {
      const payload = res?.data ?? res?.result ?? res;
      this.moodData = Array.isArray(payload) ? payload : [payload].filter(Boolean);
      this.processMoodData();
    });

    this.api.getHealth(userId).subscribe((res: any) => {
      const payload = res?.data ?? res?.result ?? res;
      this.healthData = Array.isArray(payload) ? payload : [payload].filter(Boolean);
      this.processHealthData();
    });
  }

  ngAfterViewInit() {
    this.initMoodChart();
    this.initHealthChart();
  }

  private processMoodData() {
    this.moodLabels = this.moodData.map((item, index) => {
      const date = item.timestamp ?? item.createdAt ?? item.date;
      return date ? new Date(date).toLocaleDateString() : `Entry ${index + 1}`;
    });
    this.moodValues = this.moodData.map(item => {
      const mood = item.mood ?? item.emotion ?? item.status;
      return this.moodToNumber(mood);
    });
    this.updateMoodChart();
  }

  private processHealthData() {
    this.healthLabels = this.healthData.map((item, index) => {
      const date = item.timestamp ?? item.createdAt ?? item.date;
      return date ? new Date(date).toLocaleDateString() : `Entry ${index + 1}`;
    });
    this.heartRateValues = this.healthData.map(item => Number(item.heartRate ?? item.heart_rate ?? item.hr ?? 0));
    this.sleepValues = this.healthData.map(item => Number(item.sleepHours ?? item.sleep_hours ?? item.sleep ?? 0));
    this.updateHealthChart();
  }

  private moodToNumber(mood: string): number {
    const moodMap: { [key: string]: number } = {
      'Happy': 5, 'Relaxed': 4, 'Sad': 2, 'Stressed': 1, 'Angry': 1
    };
    return moodMap[mood] ?? 3;
  }

  private initMoodChart() {
    const canvas = this.moodChart?.nativeElement;
    if (!canvas) return;

    this.moodChartInstance = new Chart(canvas, {
      type: 'line',
      data: {
        labels: this.moodLabels,
        datasets: [{
          label: 'Mood Trend',
          data: this.moodValues,
          borderColor: '#4caf50',
          backgroundColor: 'rgba(76, 175, 80, 0.2)',
          tension: 0.4
        }]
      },
      options: {
        responsive: true,
        scales: {
          y: { beginAtZero: true, max: 5, title: { display: true, text: 'Mood Level' } }
        }
      }
    });
  }

  private initHealthChart() {
    const canvas = this.healthChart?.nativeElement;
    if (!canvas) return;

    this.healthChartInstance = new Chart(canvas, {
      type: 'bar',
      data: {
        labels: this.healthLabels,
        datasets: [
          {
            label: 'Heart Rate',
            data: this.heartRateValues,
            backgroundColor: 'rgba(255, 99, 132, 0.5)',
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 1
          },
          {
            label: 'Sleep Hours',
            data: this.sleepValues,
            backgroundColor: 'rgba(54, 162, 235, 0.5)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 1
          }
        ]
      },
      options: {
        responsive: true,
        scales: {
          y: { beginAtZero: true, title: { display: true, text: 'Values' } }
        }
      }
    });
  }

  private updateMoodChart() {
    if (this.moodChartInstance) {
      this.moodChartInstance.data.labels = this.moodLabels;
      this.moodChartInstance.data.datasets[0].data = this.moodValues;
      this.moodChartInstance.update();
    }
  }

  private updateHealthChart() {
    if (this.healthChartInstance) {
      this.healthChartInstance.data.labels = this.healthLabels;
      this.healthChartInstance.data.datasets[0].data = this.heartRateValues;
      this.healthChartInstance.data.datasets[1].data = this.sleepValues;
      this.healthChartInstance.update();
    }
  }

  calculateAverageMood(): number {
    if (this.moodValues.length === 0) return 0;
    return this.moodValues.reduce((a, b) => a + b, 0) / this.moodValues.length;
  }

  calculateAverageHeartRate(): number {
    if (this.heartRateValues.length === 0) return 0;
    return this.heartRateValues.reduce((a, b) => a + b, 0) / this.heartRateValues.length;
  }

  calculateAverageSleep(): number {
    if (this.sleepValues.length === 0) return 0;
    return this.sleepValues.reduce((a, b) => a + b, 0) / this.sleepValues.length;
  }

  goBack() {
    this.router.navigate(['/dashboard']);
  }
}
