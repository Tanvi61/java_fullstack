import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; // ✅ REQUIRED
import { ApiService } from '../../services/api';

@Component({
  selector: 'app-mood',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule  // ✅ FIX for *ngIf and pipes
  ],
  templateUrl: './mood.html',
  styleUrl: './mood.css'
})
export class MoodComponent implements OnInit {

  mood: string = '';
  note: string = '';
  message: string = '';
  lastMood: any = null;

  constructor(private api: ApiService, private router: Router) {}

  ngOnInit() {
    const userId = Number(localStorage.getItem('userId'));

    if (!Number.isFinite(userId) || userId <= 0) {
      return;
    }

    this.api.getMood(userId).subscribe((res: any) => {
      const payload = res?.data ?? res?.result ?? res;

      if (Array.isArray(payload) && payload.length > 0) {
        this.lastMood = this.mapMood(payload[payload.length - 1]);
      } else if (payload && typeof payload === 'object') {
        this.lastMood = this.mapMood(payload);
      } else {
        this.lastMood = null;
      }
    });
  }

  private mapMood(item: any) {
    return {
      mood: item.mood ?? item.emotion ?? item.status ?? 'N/A',
      note: item.note ?? item.notes ?? item.comment,
      timestamp: item.timestamp ?? item.createdAt ?? item.date
    };
  }

  goBack() {
    this.router.navigate(['/dashboard']);
  }

  submit() {
    if (!this.mood) {
      this.message = 'Please select a mood ❌';
      return;
    }

    const userId = Number(localStorage.getItem('userId'));

    const data = {
      mood: this.mood,
      note: this.note,
      user: { id: userId }
    };

    this.api.saveMood(data).subscribe({
      next: () => {
        this.message = 'Mood saved successfully ✅';
        this.note = '';
        this.mood = '';

        // ✅ refresh latest mood
        this.ngOnInit();
      },
      error: () => {
        this.message = 'Failed to save mood ❌';
      }
    });
  }
}