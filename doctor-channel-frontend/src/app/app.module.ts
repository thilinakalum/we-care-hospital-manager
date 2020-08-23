import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { HomeComponent } from './home/home.component';
import { FilterPipe } from './pipe/filter-pipe';
import { DoctorChannelingService } from './service/doctor-channeling.service';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { ConfirmBookingComponent } from './confirm-booking/confirm-booking.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { LoginComponent } from './login/login.component';
import { NgxSpinnerModule } from "ngx-spinner";
import { SnotifyModule, SnotifyService, ToastDefaults } from 'ng-snotify';
@NgModule({
  declarations: [
    AppComponent,
    CreateBookingComponent,
    HomeComponent,
    FilterPipe,
    ConfirmBookingComponent,
    ContactFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    NgbTypeaheadModule,
    HttpClientModule,
    NgxSpinnerModule,
    SnotifyModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    DoctorChannelingService, {
    provide: 'SnotifyToastConfig',
    useValue: ToastDefaults
  },
    SnotifyService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
platformBrowserDynamic().bootstrapModule(AppModule).then(ref => {
  // Ensure Angular destroys itself on hot reloads.
  if (window['ngRef']) {
    window['ngRef'].destroy();
  }
  window['ngRef'] = ref;

  // Otherise, log the boot error
}).catch(err => console.error(err));
