import {Doctor} from './doctor';
import { Injectable } from '@angular/core';
@Injectable()
export class DoctorSession {
  id: number;
  date: Date;
  startTime: string;
  endTime: string;
  maxEpointments: number;
  availaility: number;
  fkDoctor: Doctor = new Doctor();;
}
