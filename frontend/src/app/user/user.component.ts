import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ConfigService } from '../config/config.service';
import { UserResponse } from '../models/userResponse';

export interface UserData {
  adminId: string;
  action: string;
  userId: string;
  name: string;
  timestamp: string;
  message: string;
}
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  filterData = '';
  dataResponse: UserResponse[];

  dataSource: MatTableDataSource<UserResponse>;
  displayedColumns: string[] = [
    'userId',
    'status',
    'firstName',
    'lastName',
    'action',
  ];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(public service: ConfigService, public router: Router) {}

  ngOnInit(): void {
    this.getAllUsers();
  }

  confirmDelete(row: any) {
    this.service
      .deleteUser(row.userId, '251195', new Date().toUTCString())
      .subscribe(() => {
        this.router.navigateByUrl('/history');
      });
  }

  getAllUsers(): void {
    this.service.getAllUsers().subscribe((res) => {
      this.dataResponse = res;
      this.dataSource = new MatTableDataSource(this.dataResponse);
      this.dataSource.filterPredicate = (
        data: UserResponse,
        filter: string
      ) => {
        return JSON.stringify({
          firstName: data.information.firstName.toLowerCase(),
          lastName: data.information.lastName.toLowerCase(),
          userId: data.userId,
          status: data.status.toLowerCase(),
        }).includes(filter);
      };

      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
