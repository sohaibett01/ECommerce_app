import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/'; // Remplacez par votre URL d'API

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    })
  };

  constructor(private http: HttpClient) {}

  register(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}signup`, userData, this.httpOptions);
  }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}authenticate`, credentials, this.httpOptions);
  }
}

