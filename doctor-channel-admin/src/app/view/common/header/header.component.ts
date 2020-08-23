import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AuthService} from '../../security/services/auth.service';
import {Router} from '@angular/router';
import {User} from '../../security/model/model.user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  encapsulation: ViewEncapsulation.None
})
export class HeaderComponent implements OnInit {
  currentUser: User;

  constructor(private authService: AuthService, private router: Router) {
     // this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
  }

  // login out from the app
  logOut() {
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
    // this.authService.logOut()
    //   .subscribe(
    //     data => {
    //       localStorage.removeItem('currentUser');
    //       this.router.navigate(['/login']);
    //     },
    //     error => {
    //
    //     });
  }
}
