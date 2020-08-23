import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Doctor} from '../model/doctor';
import {AppSettings} from 'src/app/settings/app-settings';
import {Observable} from 'rxjs';
import {DoctorCategory} from '../model/doctor-category';
import {AppointmentDetails} from '../../appointment/model/appointment-details';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) {
  }

  public findAllDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>(AppSettings.API_ENDPOINT + '/api/doctor-channeling/find-all-doctors');
  }

  public findAllCategories(): Observable<DoctorCategory[]> {
    return this.http.get<DoctorCategory[]>(AppSettings.API_ENDPOINT + '/api/doctor-channeling/find-all-doctor-categorys');
  }

  public save(doctor: Doctor): Observable<Doctor> {
    return this.http.post<Doctor>(AppSettings.API_ENDPOINT + '/api/doctor/save', doctor);
  }

  public delete(id: number): Observable<Doctor> {
    return this.http.delete<Doctor>(AppSettings.API_ENDPOINT + '/api/doctor/delete/' + id);
  }

  public findAllAppointments(): Observable<AppointmentDetails[]> {
    return this.http.get<AppointmentDetails[]>(AppSettings.API_ENDPOINT + '/api/doctor-channeling/getAllAppointments');
  }

}
