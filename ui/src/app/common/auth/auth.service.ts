import { Injectable, Inject } from '@angular/core';
import { Http, Response, Headers, RequestOptions, RequestOptionsArgs } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import { LocalStorageService } from '../local-storage.service';
import {OAUTH_TOKEN_URI} from "../backen-const";

/**
 * Import interfaces that service depends on
 */

@Injectable()
export class UserService {

  constructor (private http: Http,
               private _localStorageService: LocalStorageService,
               @Inject('appConfig') private _config: any) {

  }

  user:AuthUser = new AuthUser();


  login(user): Observable<any> {
    return this.getToken(user)
      .map((res: Response) => res.json())
      .catch(this.handleError);
  }

  authenticated() {
    console.log(this._localStorageService.getAuth('isAuthenticated'))
    return true === this._localStorageService.getAuth('isAuthenticated');
  }

  logout() {
    // localStorage.removeItem('access_token');
    // localStorage.removeItem('refresh_token');
    // localStorage.removeItem('username');
    // localStorage.removeItem('isAuthenticated');
    this._localStorageService.clearAuth();
    return true;
  }

  register(user) {
    return this.http.post(this._config.registerUrl, user)
                    .map((res: Response) => res.json())
                    .catch(this.handleError);
  }

  getToken(user): Observable<Response>{
    this.user.username = user.username;
    this.user.password = user.password;
    let options = new RequestOptions();
    options.headers = new Headers();

    let searchParams = Object.keys(this.user).map((key) => {
      return key + '=' + this.user[key];
    }).join('&');
    options.headers.append("Content-Type","application/x-www-form-urlencoded");
    options.headers.append("Authorization", "Basic " + btoa("bupt-client:bupt626"));
    return this.http.post(OAUTH_TOKEN_URI, searchParams, options);
  }



  private handleError (error: Response) {
    return Observable.throw(error || 'Server Error');
  }

}
class AuthUser{
  grant_type = "password";
  scope = "read";
  username = "";
  password ="";
}
