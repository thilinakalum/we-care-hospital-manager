import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router, RoutesRecognized} from '@angular/router';
import { MDoctorComponent } from '../../master/m-doctor/m-doctor.component';
import {AppointmentComponent} from '../../master/appointment/appointment.component';

export enum NavigationMenuTypes {
  MASTER,
  OVERVIEW
}

export const NavigationMenus = [
  {
    title: 'MASTER',
    description: ''
  },
  {
    title: 'OVERVIEW',
    description: ''
  }
];

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html'
})
export class NavigationComponent implements OnInit {

  NavigationMenuTypes: typeof NavigationMenuTypes = NavigationMenuTypes;
  public activeMenu: NavigationMenuTypes;
  @Output() public changeMenu = new EventEmitter<NavigationMenuTypes>();

  constructor(private router: Router) {
  }

  ngOnInit() {
    // a little hack
    this.router.events.subscribe((event) => {
      if (event instanceof RoutesRecognized) {
        switch (event.state.root.firstChild.component) {
          case MDoctorComponent:
            this.setActiveMenu(NavigationMenuTypes.MASTER);
            break;
          case AppointmentComponent:
            this.setActiveMenu(NavigationMenuTypes.MASTER);
            break;
          default:
            this.setActiveMenu(NavigationMenuTypes.OVERVIEW);
            break;
        }
      }
    });

  }

  setActiveMenu(activeMenu: NavigationMenuTypes): void {
    this.activeMenu = activeMenu;
    this.changeMenu.emit(this.activeMenu);
  }

  isMainFunctionsActive(): boolean {
    return this.activeMenu !== NavigationMenuTypes.OVERVIEW;
  }


}
