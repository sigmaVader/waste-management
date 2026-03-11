import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DashbordServiceService {

  private apiUrl='http://localhost:8080/api/dashboard';

  constructor(private httpClient:HttpClient) { }

   getStats(){
    return this.httpClient.get<any>(`${this.apiUrl}/stats`,{
      withCredentials: true
    });
  }

  
}
