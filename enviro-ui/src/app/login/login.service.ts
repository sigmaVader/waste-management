import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  login(user: any): Observable<string> {

    return this.http.post(
      `${this.loginUrl}/login`,
      user,
      { responseType: 'text' ,  withCredentials: true}
    );

  }
}