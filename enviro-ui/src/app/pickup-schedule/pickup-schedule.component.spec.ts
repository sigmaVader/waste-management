import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PickUpScheduleComponent } from './pickup-schedule.component';

describe('PickUpScheduleComponent', () => {
  let component: PickUpScheduleComponent;
  let fixture: ComponentFixture<PickUpScheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PickUpScheduleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PickUpScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
