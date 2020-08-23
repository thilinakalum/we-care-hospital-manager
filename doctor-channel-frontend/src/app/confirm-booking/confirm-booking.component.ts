import { Component, OnInit, ViewChild } from '@angular/core';
import { DoctorChannelingService } from '../service/doctor-channeling.service';
import { ActivatedRoute } from '@angular/router';
import { Booking } from '../dto/booking';
import { DoctorSession } from '../dto/doctor-session';
import { SnotifyService } from 'ng-snotify';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-confirm-booking',
  templateUrl: './confirm-booking.component.html',
  styleUrls: ['./confirm-booking.component.css']
})
export class ConfirmBookingComponent implements OnInit {

  public booking: Booking = new Booking();
  public doctorSession: DoctorSession = new DoctorSession();
  @ViewChild('inputForm', { static: true }) inputForm;

  constructor(
    private doctorChannelingService: DoctorChannelingService,
    private snotifyService: SnotifyService,
    private ngxSpinnerService: NgxSpinnerService,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.ngxSpinnerService.show();
    this.doctorChannelingService.findSessionDetails(this.route.snapshot.params.id)
      .subscribe((res: DoctorSession) => {
        this.doctorSession = res;
        this.booking.fkSession = res;
        this.booking.fkDoctor = res.fkDoctor;
        this.ngxSpinnerService.hide();
      }, (e) => {
        this.ngxSpinnerService.hide();
      });
  }

  createBooking() {
    if (this.inputForm.invalid) {
      this.snotifyService.error('Please fill all required', 'WARNING', {
        timeout: 2000,
        showProgressBar: false,
        closeOnClick: false,
        pauseOnHover: true
      });
    } else {
      this.snotifyService.confirm('Confirm ?..', 'INFO', {
        timeout: 5000,
        showProgressBar: false,
        closeOnClick: false,
        pauseOnHover: false,
        buttons: [
          {
            text: 'Yes, Create It..', action: (toast) => {
              this.ngxSpinnerService.show();
              this.snotifyService.remove(toast.id);
              this.booking.bookingNo = 1;
              this.doctorChannelingService.saveBooking(this.booking).subscribe((data) => {
                this.snotifyService.success('Create Booking Success', 'SUCCESS', {
                  timeout: 2000,
                  showProgressBar: false,
                  closeOnClick: false,
                  pauseOnHover: true
                });
                this.ngxSpinnerService.hide();
              }, (e) => {
                this.snotifyService.error('Create Booking Error', 'ERROR', {
                  timeout: 2000,
                  showProgressBar: false,
                  closeOnClick: false,
                  pauseOnHover: true
                });
                this.ngxSpinnerService.hide();
              });
            }
          },
          {
            text: 'No', action: (toast) => {
              this.snotifyService.remove(toast.id);
            }, bold: true
          },
        ]
      });
    }
  }

}
