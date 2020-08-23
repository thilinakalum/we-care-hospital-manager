import {DoctorCategory} from './doctor-category';
import { Injectable } from '@angular/core';
@Injectable()
export class Doctor extends DoctorCategory {
  id: number;
  name: string;
  description: string;
  qualification: string;
  fkDoctorCategory: DoctorCategory;
}
