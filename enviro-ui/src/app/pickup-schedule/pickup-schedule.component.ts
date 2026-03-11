import { Component, OnInit } from '@angular/core';
import { PickupServiceService } from './pickup-service.service';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-pick-up-schedule',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './pickup-schedule.component.html',
  styleUrls: ['./pickup-schedule.component.css']
})
export class PickUpScheduleComponent implements OnInit {

  scheduledPickup: string = '';
  pickupAddress: string = '';
  scheduleStatus: string = '';
  message: string = '';
  pickupSchedules: any[] = [];

  constructor(
    private pickupScheduleService: PickupServiceService
  ) {}

  ngOnInit(): void {
    this.loadSchedules();
  }

  saveSchedule() {
    const pickupSchedule = {
      scheduledPickup: this.scheduledPickup,
      pickupAddress: this.pickupAddress,
      scheduleStatus: this.scheduleStatus
    };

    this.pickupScheduleService.savePickSchedule(pickupSchedule).subscribe({
      next: (response) => {
        this.message = response;
        this.loadSchedules();
      },
      error: (error) => {
        console.log(error);
        this.message = 'failed to save schedule';
      }
    });
  }

  loadSchedules() {
    this.pickupScheduleService.getUserSchedules().subscribe({
      next: (data) => {
        this.pickupSchedules = data;
      },
      error: (error) => {
        console.log(error);
        this.message = 'failed to load pick up schedules';
      }
    });
  }
}