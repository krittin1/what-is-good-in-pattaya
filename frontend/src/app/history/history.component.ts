import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Form } from '@angular/forms';
import { FormService } from '../form.service';
import { LogResponse, Log, Object } from '../types/logResponse';

export interface UserData {
  adminId: string;
  action: string;
  userId: string;
  name: string;
  timestamp: string;
  message: string;
}
@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent implements OnInit {
  forms: Form[] = [];
  filterData = '';
  dataResponse: LogResponse;
  logs: Log[];
  results: UserData[] = [];
  dataSource: MatTableDataSource<UserData>;
  displayedColumns: string[] = [
    'adminId',
    'action',
    'name',
    'timestamp',
    'message',
  ];
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(public service: FormService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.service.getAllForm().subscribe((res) => {
      this.dataResponse = res;
      this.logs = res.logs;
      this.logs.forEach((log) => {
        const userData: UserData = {
          adminId: log.adminId,
          action: log.object.action,
          userId: log.object.userId,
          name: `${log.object.name} ${log.object.surname}`,
          timestamp: log.timestamp,
          message: log.message,
        };
        this.results.push(userData);
      });
      this.dataSource = new MatTableDataSource(this.results);
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

  /** Builds and returns a new User. */
  createNewUser(id: number): UserData {
    return {
      adminId: '',
      action: '',
      userId: '',
      name: '',
      timestamp: '',
      message: '',
    };
  }
}
