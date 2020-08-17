export type Object = {
  action: string;
  userId: string;
  name: string;
  surname: string;
  idCard: string;
  postcode: string;
  dateOfBirth: string;
  position: string;
  stateDate: string;
  phoneNumber: string;
  address: string;
};

export type Log = {
  adminId: string;
  message: string;
  object: Object;
  timestamp: string;
};

export type LogResponse = {
  numberOfLogs: number;
  pageNumber: number;
  logsPerPage: number;
  logs: Log[];
};
