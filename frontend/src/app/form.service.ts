import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Form } from '@angular/forms';
import { LogResponse } from '../../src/app/types/logResponse';
@Injectable({
  providedIn: 'root',
})
export class FormService {
  constructor(private http: HttpClient) {}

  getAllForm(): Observable<LogResponse> {
    return this.http.get<LogResponse>(
      'http://localhost:8080/api/v1/logs?page=0'
    );
  }
}
