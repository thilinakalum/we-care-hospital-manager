import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DoctorChannelingService} from '../service/doctor-channeling.service';
import {DoctorSession} from '../dto/doctor-session';
import {Doctor} from '../dto/doctor';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.css']
})
export class CreateBookingComponent implements OnInit {

  private doctorSessionList: DoctorSession [] = [];
  private doctor: Doctor;
  public lording: boolean;

  constructor(private route: ActivatedRoute,
              private doctorChannelingService: DoctorChannelingService,
              private router: Router) {
    this.doctor = new Doctor();
    this.doctorSessionList = [];
  }

  ngOnInit(): void {
    this.lording = true;
    this.doctorChannelingService.findDoctorSessionByDoctorAnd(this.route.snapshot.params.doctor, this.route.snapshot.params.date)
      .subscribe((data: DoctorSession[]) => {
        this.lording = false;
        this.doctorSessionList = data;
        this.doctor = this.doctorSessionList[0].fkDoctor;
        }, (e) => {
          this.doctorSessionList = [];
        }
      );
  }

  confirmbooking(sessionDetails) {
    this.router.navigate(['confirm-booking', sessionDetails.id]);
  }
}
