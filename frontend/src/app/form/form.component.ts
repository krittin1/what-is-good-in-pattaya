import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ConfigService } from '../config/config.service';
import { Form } from '../models/form';
import { Object } from '../models/object';
import { MatSelectModule } from '@angular/material/select';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  form: Form;
  object: Object;

  selectFormControl = new FormControl('', Validators.required);

  public addForm = new FormGroup({
    userId: new FormControl('251195'),
    name: new FormControl('Veeraphat'),
    surname: new FormControl('Amornsirikul'),
    idCard: new FormControl('1111111111111'),
    postcode: new FormControl('10200'),
    dateOfBirth: new FormControl('11/10/1997'),
    position: new FormControl('Junior Backend Develope'),
    startDate: new FormControl('01/07/2020'),
    phoneNumber: new FormControl('0953569497'),
    address: new FormControl('Bangkok'),
  });

  constructor(private service: ConfigService) {}

  debug() {
    const currentDate = new Date();
    this.form = new Form(
      'New Employee added',
      '251195',
      'chatchanokwon',
      new Object(
        'Add',
        this.addForm.get('userId').value,
        this.addForm.get('name').value,
        this.addForm.get('surname').value,
        this.addForm.get('idCard').value,
        this.addForm.get('postcode').value,
        this.addForm.get('dateOfBirth').value,
        this.addForm.get('position').value,
        this.addForm.get('startDate').value,
        this.addForm.get('phoneNumber').value,
        this.addForm.get('address').value
      ),
      currentDate.toUTCString()
    );
    console.log(this.form);
    this.service.addForm(this.form).subscribe((data) => {
      console.log(data);
    });
  }

  ngOnInit(): void {}
  imports: [
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,
    MatCardModule,
    MatSelectModule,
    FormControl
  ];
}
