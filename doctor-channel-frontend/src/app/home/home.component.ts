import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {Doctor} from '../dto/doctor';
import {Observable} from 'rxjs';
import {SearchDoctor} from '../dto/search-doctor';
import {DoctorCategory} from '../dto/doctor-category';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  doctorList: Doctor[] = [];
  doctorCategoryList: DoctorCategory [] = [];
  searchDoctor: SearchDoctor;
  public lording: boolean;

  constructor(private router: Router,
              private doctorChannelingService: DoctorChannelingService) {
    this.searchDoctor = new SearchDoctor();
  }

  ngOnInit() {
    this.formLoadFillData();
  }

  formLoadFillData() {
    this.lording = true;
    this.doctorList = [];
    this.doctorChannelingService.findAllDoctors()
      .subscribe((data: Doctor[]) => {
        this.doctorList = data;
      }, (e) => {
        console.log(e);
        this.doctorList = [];
      });

    this.doctorCategoryList = [];
    this.doctorChannelingService.findAllDoctorCategorys()
      .subscribe((data: DoctorCategory[]) => {
          this.doctorCategoryList = data;
          this.lording = false;
        }, (e) => {
          this.doctorCategoryList = [];
        }
      );
  }

  changeDoctor(e) {
    this.searchDoctor.doctorCategory = e.target.value;
  }

  changeDoctorCategory(e) {
    console.log(e.target.value);
  }


  search() {
    if (this.searchDoctor.doctor) {
      this.router.navigate(['create-booking', this.searchDoctor.doctor.id]);
    }

    this.router.navigate(['create-booking', this.searchDoctor.doctor.id, this.searchDoctor.date]);
  }
}
