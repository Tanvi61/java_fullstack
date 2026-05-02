import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoodComponent } from './mood';

describe('MoodComponent', () => {
  let component: MoodComponent;
  let fixture: ComponentFixture<MoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoodComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(MoodComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
