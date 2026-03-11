import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { DashbordServiceService } from './dashbord-service.service';

@Component({
  selector: 'app-dashbord',
  imports: [RouterLink],
  templateUrl: './dashbord.component.html',
  styleUrl: './dashbord.component.css'
})
export class DashbordComponent implements OnInit{

totalWaste = 0;
recyclableWaste = 0;
scheduledPickups = 0;

constructor( private dashboardService: DashbordServiceService){}


ngOnInit(){

  this.dashboardService.getStats().subscribe({

    next: (data)=>{

      this.totalWaste = data.totalWasteRecords;
      this.recyclableWaste = data.recyclableWaste;
      this.scheduledPickups = data.scheduledPickups;

    }

  });
}

}
