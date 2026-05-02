import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { ApiService } from '../../services/api';
import { HealthComponent } from './health';

describe('HealthComponent', () => {
  let component: HealthComponent;
  let fixture: ComponentFixture<HealthComponent>;

  beforeEach(async () => {
    localStorage.setItem('userId', '1');

    const apiServiceStub = {
      getHealth: () => of([]),
      saveHealth: () => of({})
    };

    await TestBed.configureTestingModule({
      imports: [HealthComponent],
      providers: [{ provide: ApiService, useValue: apiServiceStub }]
    }).compileComponents();

    fixture = TestBed.createComponent(HealthComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
