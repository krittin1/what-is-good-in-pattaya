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
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  form: Form;
  object: Object;

  public updateForm = new FormGroup({
    userId: new FormControl(''),
    name: new FormControl(''),
    surname: new FormControl(''),
    idCard: new FormControl(''),
    postcode: new FormControl(''),
    dateOfBirth: new FormControl(''),
    position: new FormControl(''),
    startDate: new FormControl(''),
    phoneNumber: new FormControl(''),
    address: new FormControl(''),
  });
  constructor(private service: ConfigService, private router: Router) { }

  ngOnInit(): void {
    this.service.getUserById('JirapornKan').subscribe((res)=>{

    })
   }


  imports: [
    MatInputModule,
    MatIconModule,
    MatDatepickerModule,
    MatCardModule
  ];

  updateUser() {
    this.form = new Form(
      'New Employee added',
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
      "a few minute ago."
    );
    
    console.log(this.form);
    
    this.service.updateUser(this.form).subscribe((data) => {
      this.router.navigateByUrl('/history');
      console.log(data);
    });
  }

  deleteUser() {
    this.service.deleteUser('JirapornKan').subscribe((res) => {
      this.router.navigateByUrl('/history');
    })
  }
  // updateUser(){
    
  //   this.service.updateUser('JirapornKan').subscribe((res) => {

  //     this.router.navigateByUrl('/history');
  // })
  // }
}
