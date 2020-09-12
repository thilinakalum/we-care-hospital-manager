import { DatePipe } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { NgxSmartModalService } from 'ngx-smart-modal';
import { SnotifyService } from 'ng-snotify';
import { AppSettings } from 'src/app/settings/app-settings';
import { NgxSpinnerService } from "ngx-spinner";
import { CommonService } from '../m-doctor/service/common.service';
import { Doctor } from '../m-doctor/model/doctor';
import { DoctorSession } from '../m-doctor/model/doctor-session';

@Component({
  selector: 'app-m-doctor-session',
  templateUrl: './m-doctor-session.component.html',
  styleUrls: ['./m-doctor-session.component.css']
})
export class MDoctorSessionComponent implements OnInit {

  @ViewChild('inputForm') inputForm;
  public doctorSessionList: DoctorSession[] = [];
  public doctorList: Doctor[] = [];
  public doctorSession = new DoctorSession();

  constructor(
    private ngxSmartModalService: NgxSmartModalService,
    private snotifyService: SnotifyService,
    private ngxSpinnerService: NgxSpinnerService,
    private commonService: CommonService) { }

  ngOnInit() {
    this.findAll();
  }

  openMasterForm() {
    this.doctorSession = new DoctorSession();
    this.ngxSmartModalService.open('masterForm');
  }

  findAll() {
    this.ngxSpinnerService.show();
    this.commonService.findAllDoctorSessions().subscribe((data) => {
      this.doctorSessionList = data;

      this.commonService.findAllDoctors().subscribe((data) => {
        this.doctorList = data;
        this.ngxSpinnerService.hide();
      }, (e) => {
        this.doctorList = [];
        this.ngxSpinnerService.hide();
      });

    }, (e) => {
      this.doctorSessionList = [];
      this.ngxSpinnerService.hide();
    });
  }

  edit(rowNo, data) {
    this.doctorSession = data;
    this.ngxSmartModalService.open('masterForm');
  }

  delete(rowNo,data) {
    this.snotifyService.confirm('Confirm ?..', AppSettings.MESSAGE_WARNING, {
      timeout: 5000,
      showProgressBar: false,
      closeOnClick: false,
      pauseOnHover: false,
      buttons: [
        {
          text: 'Yes, Delete It..', action: (toast) => {
            this.ngxSpinnerService.show();
            this.commonService.deleteDoctorSession(data.id).subscribe((data) => {
              this.snotifyService.success('Delete doctor session success', AppSettings.MESSAGE_SUCCESS, {
                timeout: 2000,
                showProgressBar: false,
                closeOnClick: false,
                pauseOnHover: false
              });
              this.doctorSessionList.splice(rowNo, 1);
              this.snotifyService.remove(toast.id);
              this.ngxSpinnerService.hide();
            }, (e) => {
              console.log(e)
              this.ngxSpinnerService.hide();
              this.snotifyService.error('Delete doctor session error', AppSettings.MESSAGE_ERROR, {
                timeout: 2000,
                showProgressBar: false,
                closeOnClick: false,
                pauseOnHover: false
              });
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

  save() {
    if (this.inputForm.invalid) {
      this.snotifyService.error('Please fill the all text', AppSettings.MESSAGE_WARNING, {
        timeout: 2000,
        showProgressBar: false,
        closeOnClick: false,
        pauseOnHover: true
      });
    } else {
      let that = this;
      this.snotifyService.confirm('Confirm ?..', AppSettings.MESSAGE_INFO, {
        timeout: 5000,
        showProgressBar: false,
        closeOnClick: false,
        pauseOnHover: false,
        buttons: [
          {
            text: 'Yes, Save It..', action: (toast) => {
              that.ngxSpinnerService.show();
              that.doctorSession.availaility = 1;
              that.commonService.saveDoctorSession(that.doctorSession).subscribe((data) => {
                that.findAll();
                that.snotifyService.remove(toast.id);
                that.ngxSmartModalService.close('masterForm');
                that.snotifyService.success('Add new doctor session success', AppSettings.MESSAGE_SUCCESS, {
                  timeout: 2000,
                  showProgressBar: false,
                  closeOnClick: false,
                  pauseOnHover: false
                });
              }, (e) => {
                that.ngxSpinnerService.hide();
                that.snotifyService.error('Add new doctor session error', AppSettings.MESSAGE_ERROR, {
                  timeout: 2000,
                  showProgressBar: false,
                  closeOnClick: false,
                  pauseOnHover: false
                });
              });
              that.snotifyService.remove(toast.id);
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

  clear() {
    this.doctorSession = new DoctorSession();
    this.ngxSmartModalService.close('masterForm');
  }

  new() {
    this.ngxSmartModalService.open('masterForm');
    this.doctorSession = new DoctorSession();
  }

}
