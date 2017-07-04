import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {UserService} from "../common/auth/auth.service";

@Injectable()
export class HomeRootComponentGuard implements CanActivate {

  constructor(private _router: Router,
              private _userService: UserService) {}

  canActivate(route: ActivatedRouteSnapshot, routeState: RouterStateSnapshot): Observable<boolean> | boolean {
      if(!this._userService.authenticated()){
        this._router.navigate(['/login']);
        return false;
      } else
        return true;
  }
}
