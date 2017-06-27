import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {UserService} from "../common/auth/auth.service";

@Injectable()
export class UnauthenticatedGuard implements CanActivate {

  constructor(private _router: Router, private _userService: UserService) {}

  canActivate(): Observable<boolean> | boolean {
    if (!this._userService.authenticated()) {
      return true;
    } else {
      this._router.navigateByUrl('/');
      return false;
    }
  }
}
