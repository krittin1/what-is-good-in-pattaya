import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Form } from '@angular/forms';
import { LogResponse } from '../../src/app/types/logResponse';
import { environment } from '../environments/environment';
@Injectable({
  providedIn: 'root',
})
export class FormService {
  constructor(private http: HttpClient) {}

  getAllForm(): Observable<LogResponse> {
    return this.http.get<LogResponse>(
      `${environment.apiUrl}/api/v1/logs?page=0&item_per_page=100`
    );
  }
}
