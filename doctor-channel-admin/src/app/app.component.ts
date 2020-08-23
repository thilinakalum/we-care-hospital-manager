import { Component } from '@angular/core';
import {NavigationMenus, NavigationMenuTypes} from './view/common/navigation/navigation.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  activeMenu: NavigationMenuTypes = NavigationMenuTypes.OVERVIEW;

  constructor() {

  }

  getTitle(): String {
    return NavigationMenus[this.activeMenu].title;
  }

  getDescription(): String {
    return NavigationMenus[this.activeMenu].description;
  }
}
