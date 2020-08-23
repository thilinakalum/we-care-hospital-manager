import {BrowserModule} from '@angular/platform-browser';
import {NgModule, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';

import {AppComponent} from './app.component';
import {ContainerComponent} from './view/common/container/container.component';
import {FooterComponent} from './view/common/footer/footer.component';
import {HeaderComponent} from './view/common/header/header.component';
import {NavigationComponent} from './view/common/navigation/navigation.component';
import {SnotifyModule, SnotifyService, ToastDefaults} from 'ng-snotify';
import {NgxPaginationModule} from 'ngx-pagination';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgxSmartModalModule} from 'ngx-smart-modal';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {SafePipe} from './pipe/safe.pipe';
import {LoginComponent} from './view/security/login/login.component';
import {UrlPermission} from './view/security/urlPermission/url.permission';
import {AccountService} from './view/security/services/account.service';
import {AuthService} from './view/security/services/auth.service';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';
import {FilterPipe} from './pipe/filter-pipe';
import {MDoctorComponent} from './view/master/m-doctor/m-doctor.component';
import {NgxSpinnerModule} from 'ngx-spinner';
import {CommonService} from './view/master/m-doctor/service/common.service';
import {AppointmentComponent} from './view/master/appointment/appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    ContainerComponent,
    FooterComponent,
    HeaderComponent,
    NavigationComponent,
    SafePipe,
    FilterPipe,
    LoginComponent,
    MDoctorComponent,
    AppointmentComponent,
  ],
  imports: [
    BrowserModule,
    SnotifyModule,
    NgxPaginationModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule.forRoot(),
    NgxSmartModalModule.forRoot(),
    NgxSpinnerModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    {
      provide: 'SnotifyToastConfig',
      useValue: ToastDefaults
    },
    SnotifyService,
    AuthService,
    AccountService,
    CommonService,
    UrlPermission],
  bootstrap: [AppComponent]
})
export class AppModule {
}

platformBrowserDynamic().bootstrapModule(AppModule).then(ref => {
  // Ensure Angular destroys itself on hot reloads.
  if (window['ngRef']) {
    window['ngRef'].destroy();
  }
  window['ngRef'] = ref;

  // Otherise, log the boot error
}).catch(err => console.error(err));
