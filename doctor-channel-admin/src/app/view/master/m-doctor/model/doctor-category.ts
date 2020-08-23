import {Doctor} from './doctor';
import { Injectable } from '@angular/core';
@Injectable()
export class DoctorCategory {
  id: number;
  name: string;
  doctorList: Doctor [];
}
