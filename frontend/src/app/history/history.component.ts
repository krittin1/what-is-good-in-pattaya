import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

export interface UserData {
  formId: string;
  adminId: string;
  adminName: string;
  action: string;
  userId: string;
  name: string;
  timeStamp: string;
  message: string;
}

/** Constants used to fill up our data base. */
const COLORS: string[] = [
  'maroon',
  'red',
  'orange',
  'yellow',
  'olive',
  'green',
  'purple',
  'fuchsia',
  'lime',
  'teal',
  'aqua',
  'blue',
  'navy',
  'black',
  'gray',
];
const ADMIN_NAMES: string[] = [
  'Maia',
  'Asher',
  'Olivia',
  'Atticus',
  'Amelia',
  'Phison',
  'Chatchanok',
  'Nattawit',
  'Isla',
  'Oliver',
  'Isabella',
  'Jasper',
  'Cora',
  'Levi',
  'Violet',
  'Arthur',
  'Mia',
  'Thomas',
  'Elizabeth',
];

const NAMES: string[] = [
  'Jiraporn',
  'Veeraphat',
  'Ekkarat',
  'Krittin',
  'Kanun',
  'Phison',
  'Chatchanok',
];

const ACTION: string[] = ['Added', 'Edited', 'Deleted'];

const MESSAGE: string[] = [
  'I add new employee',
  'edit employee Marital status',
  'remove retiree employee',
];
/**
 * @title Data table with sorting, pagination, and filtering.
 */
@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent implements OnInit {
  displayedColumns: string[] = [
    'formId',
    'adminId',
    'adminName',
    'action',
    'userId',
    'name',
    'timeStamp',
    'message',
  ];
  dataSource: MatTableDataSource<UserData>;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor() {
    // Create 100 users
    const users = Array.from({ length: 100 }, (_, k) => createNewUser(k + 1));

    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(users);
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}

/** Builds and returns a new User. */
function createNewUser(id: number): UserData {
  const adminName =
    ADMIN_NAMES[Math.round(Math.random() * (ADMIN_NAMES.length - 1))] +
    ' ' +
    ADMIN_NAMES[Math.round(Math.random() * (ADMIN_NAMES.length - 1))].charAt(
      0
    ) +
    '.';
  const day = new Date('August 15, 2020 23:15:00');
  const date1 = day.getDay() + '/' + day.getMonth() + '/' + day.getFullYear();
  return {
    formId: id.toString(),
    adminId: Math.round(Math.random() * 100).toString(),
    adminName: adminName,
    action: ACTION[Math.round(Math.random() * (ACTION.length - 1))],
    userId: Math.round(Math.random() * 100).toString(),
    name: NAMES[Math.round(Math.random() * (NAMES.length - 1))],
    timeStamp: date1,
    message: MESSAGE[Math.round(Math.random() * (MESSAGE.length - 1))],
  };
}
