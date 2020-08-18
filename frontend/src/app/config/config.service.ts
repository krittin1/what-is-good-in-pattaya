import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Form } from '../models/form';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  url = 'http://localhost:8080/api/v1/user'

  constructor(private http: HttpClient) { }

  addForm(employee: any): Observable<HttpResponse<Form>> {
    return this.http.post<Form>(this.url, employee, { observe: 'response' });
  }

  deleteUser(userId: String): Observable<string> {
    return this.http.delete<string>(this.url + '/' + userId);
  }

  getUserById(userId: String): Observable<Form> {
    return this.http.get<Form>(this.url + '/' + userId);
  }
  updateUser(employee: any,userId: String): Observable<HttpResponse<Form>> {
    return this.http.put<Form>(this.url + '/' + userId, employee, { observe: 'response' });
  }

}
