import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrendsComponent } from './trends';

describe('TrendsComponent', () => {
  let component: TrendsComponent;
  let fixture: ComponentFixture<TrendsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Trends],
    }).compileComponents();

    fixture = TestBed.createComponent(Trends);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
