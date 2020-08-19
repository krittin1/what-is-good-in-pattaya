import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config/config.service';
import { config } from 'rxjs';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private configService: ConfigService) {}

  ngOnInit(): void {}

  deleteUser() {
    this.configService
      .deleteUser('251184', '251195', new Date().toUTCString())
      .subscribe((data) => {
        console.log(data);
      });
  }
}
