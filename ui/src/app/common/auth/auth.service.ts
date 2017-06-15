import { Injectable, Inject } from '@angular/core';
import { Http, Response, Headers, RequestOptions, RequestOptionsArgs } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import { LocalStorageService } from '../local-storage.service';

/**
 * Import interfaces that service depends on
 */

@Injectable()
export class UserService {

  constructor (private http: Http,
               private _localStorageService: LocalStorageService,
               @Inject('appConfig') private _config: any) {

  }

  login(user) {
    return this.http.post(this._config.loginUrl, user)
              .map((res: Response) => res.json())
              .catch(this.handleError);
  }

  authenticated() {
    return false;
    // return true === this._localStorageService.getAuth('isAuthenticated');
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



  private handleError (error: Response) {
    return Observable.throw(error || 'Server Error');
  }
}
