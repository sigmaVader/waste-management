import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class WasteServiceService {

  private wasteApiUrl ='http://localhost:8080/api/waste';

  constructor(private httpClient:HttpClient) { }

  saveWasteRecord(waste:any):Observable<string>{

    return this.httpClient.post(`${this.wasteApiUrl}/create`,waste,
      {responseType: 'text',  withCredentials: true},  
    )
    

    

  }

  getMyRecords(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.wasteApiUrl}/records`, {
      withCredentials: true
    });
  }
}
