import { Component, Injectable, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Http } from '@angular/http';

import 'rxjs/Rx';
import {UserService} from "../common/auth/auth.service";
import {UnauthenticatedGuard} from "./unauthenticated.guard";
import {LocalStorageService} from "../common/local-storage.service";
import {SignUpComponent} from "../sign-up/sign-up.component";
declare let backgroundShaking;

/**
*	This class represents the lazy loaded LoginComponent.
*/

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
@Injectable()
export class LoginComponent implements OnInit {

  private user: any;

  private isSubmitting: boolean = false;

  private showSignUp: boolean = false;

  constructor( private router: Router,
               private _userService: UserService,
               private _localStorageService: LocalStorageService){}

  ngOnInit(): void {
    document.getElementById('canvas_full').oncontextmenu = () => { return false; };
    backgroundShaking('canvas-container', 'canvas_full', '#006691', '#005173');

    this.user =  {username: '', password: ''};
  }

  loginUsr() {
    this.isSubmitting = true;
    this._userService.login(this.user)
      .subscribe(
        data => {
          this.loginSuccess(data);
        },
        error => {
          let res = error.json();
          alert(res.error? '用户名或密码错误': '连接认证服务器失败');
          this.isSubmitting = false;
        },
        () => {
          this.isSubmitting = false;
        }
      );
  }

  loginSuccess(data) {
    if (data.error) {
      alert(data.error);
      return false;
    }
    this._localStorageService.setAuth({
      'access_token': data.access_token,
      'refresh_token': data.refresh_token,
      'username': this.user.username,
      'isAuthenticated': true
    });
    let redirectUrl = this._localStorageService.getLastVisitUrl();
    if (!redirectUrl || '/login' === redirectUrl) {
      redirectUrl = '/';
    }
    this._localStorageService.removeLastVisitUrl();
    this.router.navigate([redirectUrl]);
  }

  cancelRegister() {
    this.showSignUp = false;
  }

  onRegisterDone() {
    this.showSignUp = false;
  }

}
