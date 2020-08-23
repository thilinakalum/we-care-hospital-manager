import {Doctor} from './doctor';
import {DoctorCategory} from './doctor-category';
import {Injectable} from '@angular/core';

@Injectable()
export class SearchDoctor {
  doctor: Doctor;
  doctorCategory: DoctorCategory;
  date: Date;
}
