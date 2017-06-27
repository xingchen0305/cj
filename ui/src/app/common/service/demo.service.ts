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

  getDemoL(): Observable<any> {
    return this.http.get('http://localhost:3000/allasset');
  }
  getDemo(): Observable<any> {
    return this.http.get('http://10.101.164.248:8755/baseWarehouse/page?start=0');
  }
  checkDemo(): Observable<any> {
    return this.http.get('http://10.101.164.248:8755/baseWarehouse/findById?id=1');
  }
  editDemo(): Observable<any> {
    return this.http.get('http://10.101.164.248:8755/baseWarehouse/findById?id=1');
  }
 deleteDemo(): Observable<any> {
    return this.http.get('http://10.101.164.248:8755/baseWarehouse/deleteById?id=1');
  }

}
