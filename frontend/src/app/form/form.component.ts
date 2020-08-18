import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { FormGroup, FormControl } from '@angular/forms';
import { ConfigService } from '../config/config.service';
import { Form } from '../models/form';
import { Object } from '../models/object';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  form: Form;
  object: Object;

  public addForm = new FormGroup({
    userId: new FormControl('Nattawitjan'),
    name: new FormControl('Nattawit'),
    surname: new FormControl('Janjaroen'),
    idCard: new FormControl('1111111111111'),
    postcode: new FormControl('10200'),
    dateOfBirth: new FormControl('27/09/1995'),
    position: new FormControl('Junior Backend Developer'),
    startDate: new FormControl('01/07/2020'),
    phoneNumber: new FormControl('0824933423'),
    address: new FormControl('Bangkok'),
  });

  constructor(private service: ConfigService) {}

  debug() {
    this.form = new Form(
      'New Employee added',
      '251195',
      'chatchanokwon',
      new Object(
        'Added',
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
      '11/08/2020 11.20 A.M.'
    );
    // this.object = new Object("Active",
    //   this.addForm.get('userId').value,
    //   this.addForm.get('name').value,
    //   this.addForm.get('surname').value,
    //   this.addForm.get('idCard').value,
    //   this.addForm.get('postcode').value,
    //   this.addForm.get('dateOfBirth').value,
    //   this.addForm.get('position').value,
    //   this.addForm.get('startDate').value,
    //   this.addForm.get('phoneNumber').value,
    //   this.addForm.get('address').value
    //   );
    console.log(this.form);
    // console.log(this.addForm.get('userId').value)
    this.service.addForm(this.form).subscribe((data) => {
      console.log(data);
    });
  }

  ngOnInit(): void {}
  imports: [MatInputModule, MatIconModule, MatDatepickerModule, MatCardModule];
}
