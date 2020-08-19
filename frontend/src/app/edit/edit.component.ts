import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { Form } from '../models/form';
import { Object } from '../models/object';
import { ConfigService } from '../config/config.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  form: Form;
  object: Object;

  public updateForm = new FormGroup({
    userId: new FormControl('251161'),
    name: new FormControl('Veeraphat'),
    surname: new FormControl('Amornsirikul'),
    idCard: new FormControl('1111111111111'),
    postcode: new FormControl('10200'),
    dateOfBirth: new FormControl('11/10/1997'),
    position: new FormControl('Junior Backend Develope'),
    startDate: new FormControl('MatNativeDateModule'),
    phoneNumber: new FormControl('0953569497'),
    address: new FormControl('Bangkok'),
  });
  constructor(private service: ConfigService, private router: Router) {}

  ngOnInit(): void {
    // this.service.getUserById('251170').subscribe((res)=>{
    // })
  }

  imports: [MatInputModule, MatIconModule, MatDatepickerModule, MatCardModule];

  selectFormControl = new FormControl('', Validators.required);

  updateUser() {
    const currentDate = new Date();
    this.form = new Form(
      'Edited Employee',
      '251195',
      'chatchanokwon',
      new Object(
        'Edit',
        this.updateForm.get('userId').value,
        this.updateForm.get('name').value,
        this.updateForm.get('surname').value,
        this.updateForm.get('idCard').value,
        this.updateForm.get('postcode').value,
        this.updateForm.get('dateOfBirth').value,
        this.updateForm.get('position').value,
        this.updateForm.get('startDate').value,
        this.updateForm.get('phoneNumber').value,
        this.updateForm.get('address').value
      ),
      currentDate.toUTCString()
    );

    console.log(this.form);

    this.service.updateUser(this.form).subscribe((data) => {
      this.router.navigateByUrl('/history');
      console.log(data);
    });
  }
}
