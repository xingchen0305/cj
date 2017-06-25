import { Component, OnInit } from '@angular/core';
import {LocalStorageService} from "../../common/local-storage.service";
import {UserService} from "../../common/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-topnav',
  templateUrl: './topnav.component.html',
  styleUrls: ['./topnav.component.scss']
})
export class TopnavComponent implements OnInit {

  constructor(private _localStorageService: LocalStorageService, private _userService: UserService, private _router: Router) { }

  user: any = {
    username: ''
  };
  ngOnInit() {
    this.user.username = this._localStorageService.getAuth('username');
  }

  logout(){
    this._userService.logout();
    this._router.navigate(['/login']);
  }
}
