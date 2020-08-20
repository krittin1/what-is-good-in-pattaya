import { Object } from './object';
export class Form {
  constructor(
    public message: string,
    public adminId: string,
    public adminUser: string,

    public object: Object,

    public timestamp: string,
  ) { }
}
