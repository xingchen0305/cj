import {Injectable, Inject} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/throw";
import {LocalStorageService} from "../local-storage.service";
import {OAUTH_TOKEN_URI, OAUTH_SIGN_UP_URI} from "../backen-const";
import {AuthWithTokenService} from "./auth-with-token.service";
import {Router} from "@angular/router";


/**
 * Import interfaces that service depends on
 */

@Injectable()
export class UserService {

  constructor (private http: Http,
               private _localStorageService: LocalStorageService,
               private router: Router,
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



  register(user) {
    return this.http.post(OAUTH_SIGN_UP_URI, user);
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
