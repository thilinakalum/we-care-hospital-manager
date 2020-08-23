import {Customer} from './customer';
import {DoctorSession} from './doctor-session';
import {Doctor} from './doctor';
import { Injectable } from '@angular/core';

@Injectable()
export class Booking {
  id: number;
  fkDoctor: Doctor  = new Doctor();
  fkSession: DoctorSession  = new DoctorSession();
  fkCustomer: Customer = new Customer();
  bookingNo: number;
}
