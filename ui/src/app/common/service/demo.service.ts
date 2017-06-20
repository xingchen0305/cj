import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";

@Injectable()
export class DemoService {
  constructor(private http: HttpInterceptor) { }

  demourl: string = EQUIPMENT_URI + '/siteInfo';
  getData(): Observable<any> {
      return this.http.get(this.demourl+'/page?start=0');
  }

  getToken(user): Observable<any>{
    let options = new RequestOptions();
    console.log("hehre");
    options.headers = new Headers();

    let searchParams = Object.keys(user).map((key) => {
      return key + '=' + user[key];
    }).join('&');
    console.log(searchParams);

    options.headers.append("Content-Type","application/x-www-form-urlencoded");
    options.headers.append("Authorization", "Basic " + btoa("bupt-client:bupt626"));
    return this.http.post("http://localhost:9999/uaa/oauth/token", searchParams, options);
  }

/*  getDemo(): Observable<any> {
    return this.http.get('http://localhost:3000/cangku');
  }*/
  getDemo(): Observable<any> {
    return this.http.get('http://10.105.242.74:8755/page?start=0');
  }

}
