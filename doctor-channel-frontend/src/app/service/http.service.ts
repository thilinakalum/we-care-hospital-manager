import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  baseURL = 'http://localhost:9999/';
  masterPATH = 'api/master/';

  constructor(private http: HttpClient) { }

  findAllDoctors() {
    const url = this.baseURL + this.masterPATH + 'doctor/findAll';
    return this.http.get(url);
  }
  saveDoctors(doctor: any) {
    const url = this.baseURL + this.masterPATH + 'doctor/save';
    return this.http.post(url, doctor);
  }
  deleteDoctor(id: any) {
      const url = this.baseURL + this.masterPATH + 'doctor/delete/id';
      return this.http.get(url);
  }
  findAllCustomers() {
    const url = this.baseURL + this.masterPATH + 'customer/findAll';
    return this.http.get(url);
  }
  saveCustomers(doctor: any) {
    const url = this.baseURL + this.masterPATH + 'customer/save';
    return this.http.post(url, doctor);
  }
  deleteCustomers(id: any) {
    const url = this.baseURL + this.masterPATH + 'customer/delete/id';
    return this.http.get(url);
  }

}
