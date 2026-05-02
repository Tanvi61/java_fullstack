import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login';
import { DashboardComponent } from './components/dashboard/dashboard';
import { RegisterComponent } from './components/register/register';

import { MoodComponent } from './components/mood/mood';
import { HealthComponent } from './components/health/health';
import { TrendsComponent } from './components/trends/trends';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'mood', component: MoodComponent },
  { path: 'health', component: HealthComponent },
  { path: 'trends', component: TrendsComponent }
];