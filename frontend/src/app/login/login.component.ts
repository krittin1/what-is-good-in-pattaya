import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { MatButtonModule } from '@angular/material/button';
=======
import { MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';

>>>>>>> c7f3ccfe96f2f21e7681c2b0fda9a51e4b16f2cc
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

<<<<<<< HEAD
  imports: [MatButtonModule];
=======

  imports: [
    MatButtonModule,
    MatCardModule,
    MatGridListModule,

  ]
>>>>>>> c7f3ccfe96f2f21e7681c2b0fda9a51e4b16f2cc
}
