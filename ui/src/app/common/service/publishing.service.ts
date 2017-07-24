/**
 * Created by Administrator on 2017/7/24 0024.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";
import {observableToBeFn} from "rxjs/testing/TestScheduler";

@Injectable()
export class PublishingService{
  publishingUrl:string= EQUIPMENT_URI + '';
  url:string = "http://10.101.164.137:8756/commodity";
  constructor(private http:HttpInterceptor){}
    //根据id 获取发布的信息
   getPublishingById(index): Observable<any>{
    return this.http.get(this.publishingUrl+'/'+index)
   }
    //出租
   renting(assetData): Observable<any>{
    return this.http.post(this.url,assetData);

   }
    //出售
   purchase(assetData):Observable<any>{
     return this.http.post(this.url,assetData);
   }

}
