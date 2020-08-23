import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateBookingComponent} from './create-booking/create-booking.component';
import {HomeComponent} from './home/home.component';
import {ConfirmBookingComponent} from './confirm-booking/confirm-booking.component';
import {ContactFormComponent} from './contact-form/contact-form.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'create-booking', component: CreateBookingComponent},
  {path: 'create-booking/:doctor', component: CreateBookingComponent},
  {path: 'create-booking/:doctor/:date', component: CreateBookingComponent},
  {path: 'confirm-booking/:id', component: ConfirmBookingComponent},
  {path: 'about-us', component: ContactFormComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
