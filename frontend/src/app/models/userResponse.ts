type Role = 'employee' | 'admin';
type Status = 'ACTIVE' | 'DELETED';
export interface UserResponse {
  userId: string;
  role: Role;
  status: Status;
  information: {
    firstName: string;
    lastName: string;
    address: {
      currentAddress: string;
      postcode: string;
    };
    dateOfBirth: string;
    phoneNumber: string;
    position: string;
    startDate: string;
    identityCardNo: string;
  };
}
