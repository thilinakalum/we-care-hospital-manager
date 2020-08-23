import { Injectable } from '@angular/core';

@Injectable()
export class Customer {
  id: number;
  title: string;
  fname: string;
  lname: string;
  age: number;
  mobile: string;
  nic: string;
  email: string;
}

