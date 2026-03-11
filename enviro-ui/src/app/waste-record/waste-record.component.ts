import { Component, OnInit } from '@angular/core';
import { WasteServiceService } from './waste-service.service';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';




@Component({
  selector: 'app-waste-record',
  imports: [FormsModule,
    RouterLink,CommonModule
  ],
  templateUrl: './waste-record.component.html',
  styleUrl: './waste-record.component.css'
})
export class WasteRecordComponent  implements OnInit{

  name:string='';

  wasteDescription: string='';

  disposedDate: string='';

  canBeRecycled: boolean = false;

  message: string ='';

  wasteRecords: any[] = [];

    ngOnInit(): void {
    this.loadWasteRecords();
  }



  

  constructor(

    private router:Router,
    private wasteService: WasteServiceService

  ){}

  saveRecord(){

    const record={
      name: this.name,
      disposedDate :this.disposedDate,
      wasteDescription : this.wasteDescription,
      canBeRecycled: this.canBeRecycled,
      message : this.message
    }

    this.wasteService.saveWasteRecord(record).subscribe({

      next:(response) =>{
        this.message = response;
      },
      error: (error) =>{
        console.log(error);
        this.message='failed to save waste record';
      }


    })





  }

   loadWasteRecords() {
    this.wasteService.getMyRecords().subscribe({
      next: (data) => {
        this.wasteRecords = data;
      },
      error: (error) => {
        console.error(error);
      }
    });
  }

  clearForm() {
    this.name = '';
    this.wasteDescription = '';
    this.canBeRecycled = false;
    this.disposedDate = '';
  }






}
