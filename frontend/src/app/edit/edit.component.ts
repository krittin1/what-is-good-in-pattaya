import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { Form } from '../models/form';
import { Object } from '../models/object';
import { ConfigService } from '../config/config.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  form: Form;
  object: Object;

  public editForm = new FormGroup({
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
  constructor(private service: ConfigService, private router: Router) {}

  ngOnInit(): void {
    this.service.getUserById('JirapornKan').subscribe((res) => {});
  }

  imports: [MatInputModule, MatIconModule, MatDatepickerModule, MatCardModule];

  updateUser() {
    const currentDate = new Date();
    this.form = new Form(
      'New Employee added',
      '251195',
      'chatchanokwon',
      new Object(
        'Added',
        this.editForm.get('userId').value,
        this.editForm.get('name').value,
        this.editForm.get('surname').value,
        this.editForm.get('idCard').value,
        this.editForm.get('postcode').value,
        this.editForm.get('dateOfBirth').value,
        this.editForm.get('position').value,
        this.editForm.get('startDate').value,
        this.editForm.get('phoneNumber').value,
        this.editForm.get('address').value
      ),
      currentDate.toUTCString()
    );

    console.log(this.form);

    this.service.updateUser(this.form, 'JirapornKan').subscribe((data) => {
      this.router.navigateByUrl('/history');
      console.log(data);
    });
  }

  deleteUser() {
    this.service.deleteUser('JirapornKan').subscribe((res) => {
      this.router.navigateByUrl('/history');
    });
  }
  // updateUser(){

  //   this.service.updateUser('JirapornKan').subscribe((res) => {

  //     this.router.navigateByUrl('/history');
  // })
  // }
}
