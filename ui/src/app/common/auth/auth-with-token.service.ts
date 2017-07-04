/**
 * Created by hexiuyu on 2017/6/25.
 */
import {Injectable} from "@angular/core";
import {OAUTH_TOKEN_REMOVE_URI} from "../backen-const";
import {HttpInterceptor} from "./HttpInterceptor";
import {LocalStorageService} from "../local-storage.service";


@Injectable()
export class AuthWithTokenService {

  constructor (private http: HttpInterceptor,private _localStorageService: LocalStorageService) {}

  logout() {
    this.http.get(OAUTH_TOKEN_REMOVE_URI).subscribe(()=>{})
    this._localStorageService.clearAuth();
    return true;
  }
}
