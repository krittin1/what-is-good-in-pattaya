import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ConfigService } from '../config/config.service';
import { Form } from '../models/form';
import { Object } from '../models/object';
import { Router } from '@angular/router';

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
    userId: new FormControl(),
    name: new FormControl(),
    surname: new FormControl(),
    idCard: new FormControl(),
    postcode: new FormControl(),
    dateOfBirth: new FormControl(),
    position: new FormControl(),
    startDate: new FormControl(),
    phoneNumber: new FormControl(),
    address: new FormControl(),
  });

  constructor(private service: ConfigService, private router: Router) {}

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
    this.service.addForm(this.form).subscribe(() => {
      this.router.navigateByUrl('/history');
    });
  }

  ngOnInit(): void {}
}
