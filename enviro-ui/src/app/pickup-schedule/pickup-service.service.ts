import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PickupServiceService {

  private scheduleUrl ='http://localhost:8080/api/schedule';

  constructor(private httpClient: HttpClient) { }


  savePickSchedule(pickupSchedule:any):Observable<string>{

    return this.httpClient.post(`${this.scheduleUrl}/create`,
      pickupSchedule,{responseType:'text',withCredentials: true})

  }
getUserSchedules(): Observable<any[]> {
  return this.httpClient.get<any[]>(`${this.scheduleUrl}/schedule`, {
    withCredentials: true
  });
}





}
