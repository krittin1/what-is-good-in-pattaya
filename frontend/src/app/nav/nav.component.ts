import { Component, OnInit } from '@angular/core';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';

import { FlexLayoutModule } from '@angular/flex-layout';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css'],
})
export class NavComponent implements OnInit {
  title = 'app';
  displayNavbar: string;

  constructor() {}
  ngOnInit(): void {
    this.displayNavbar = '1';
  }

  toggleNavbar() {
    if (this.displayNavbar == '0') {
      this.displayNavbar = '1';
      //  alert(this.displayNavbar);
    }
    if (this.displayNavbar == '1') {
      //    alert("1 - Changing to 0");
      this.displayNavbar = '0';
    } else {
      this.displayNavbar = '1';
    }
  }
  imports: [
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    FlexLayoutModule
  ];
}
