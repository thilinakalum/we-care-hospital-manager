import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {UrlPermission} from './view/security/urlPermission/url.permission';
import {LoginComponent} from './view/security/login/login.component';
import { MDoctorComponent } from './view/master/m-doctor/m-doctor.component';
import {AppointmentComponent} from './view/master/appointment/appointment.component';

const routes: Routes = [
  {
    path: 'm-doctor',
    component: MDoctorComponent,
    canActivate: [UrlPermission]
  },
  {
    path: 'appointments',
    component: AppointmentComponent,
    canActivate: [UrlPermission]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  // otherwise redirect to profile
  {path: '**', redirectTo: '/login'}
];

@NgModule({
  exports: [RouterModule],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: []
})
export class AppRoutingModule {
}
