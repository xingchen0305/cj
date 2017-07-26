import {Http, Request, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers} from "@angular/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {LocalStorageService} from "../local-storage.service";
import {AuthWithTokenService} from "./auth-with-token.service";

/**
 * <a href="https://angular.cn/docs/ts/latest/api/http/index/Http-class.html">How to use Http</a>
 * Example:
 * <pre>
 *   export class YourComponent implements OnInit {
 *
 *      constructor(private http: HttpInterceptor) {
 *
 *      }
 *
 *      ngOnInit() {
 *        this.http.get('http://localhost:8080/uaa/user').subscribe(
 *          (res) => console.log(res),
 *          (err) => console.error(err),
 *          () => console.log('Yay'));
 *      }
 *   }
 * </pre>
 */
export class HttpInterceptor extends Http {

  constructor(backend: ConnectionBackend, defaultOptions: RequestOptions,
              private _localStorageService: LocalStorageService,
              private _router: Router) {
    super(backend, defaultOptions);
  }

  request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.request(url, this.getRequestOptionArgs(options)));
  }

  get(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.get(url, this.getRequestOptionArgs(options)));
  }

  post(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.post(url, body, this.getRequestOptionArgs(options)));
  }

  put(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.put(url, body, this.getRequestOptionArgs(options)));
  }

  delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.delete(url, this.getRequestOptionArgs(options)));
  }

  patch(url: string, body: any, options?: RequestOptionsArgs): Observable<Response> {
    return this.intercept(super.patch(url, body, this.getRequestOptionArgs(options)));
  }

  getRequestOptionArgs(options?: RequestOptionsArgs): RequestOptionsArgs {
    if (options == null) {
      options = new RequestOptions();
    }
    if (options.headers == null) {
      options.headers = new Headers();
    }
    if (options.headers.get('Content-Type') == null) {
      options.headers.append('Content-Type', 'application/json');
    }
    let token = this._localStorageService.getAuth('access_token');

    options.headers.append('Accept', 'application/json');
    options.headers.append('Authorization', 'Bearer ' + token);
    options.withCredentials = false;
    return options;
  }

  generateUrlArgsByObj(obj: Object): String {
    let searchParams = Object.keys(obj).map((key) => {
      return key + '=' + obj[key];
    }).join('&');
    return searchParams;
  }

  intercept(observable: Observable<Response>): Observable<Response> {
    return observable.catch((err, source) => {
      console.log('Http error: ', err, source);
      if (err.status === 401) {
        this._localStorageService.clearAuth();
        this._router.navigate(['/login']);
        return Observable.empty();
      } else {
        return Observable.throw(err);
      }
    });



  }
}
