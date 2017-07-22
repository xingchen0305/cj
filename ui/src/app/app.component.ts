import { Component } from '@angular/core';
import {NavigationStart, Router} from "@angular/router";
import {LocalStorageService} from "./common/local-storage.service";
import {UserService} from "./common/auth/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app works!';

  constructor (private _userService: UserService,
               private _localStorageService: LocalStorageService,
               private router: Router) {

    // router.events
    //   .filter(event => event instanceof NavigationStart)
    //   .subscribe(event => {
    //     if (!/\/login|\/reg/.test(event.url)) {
    //       this._localStorageService.setLastVisitUrl(event.url);
    //     }
    //   });


  }
  isAuthenticated() {
    return this._userService.authenticated();
  }
}
