import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { Form } from '../models/form';
import { Object } from '../models/object';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  // form: Form;
  // object: Object;
  constructor() { }

  ngOnInit(): void {}
  imports: [
    MatInputModule, 
    MatIconModule, 
    MatDatepickerModule, 
    MatCardModule
  ];
}
