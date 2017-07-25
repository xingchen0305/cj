/**
 * Created by Administrator on 2017/7/24 0024.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import { BOOK_URI } from '../backen-const';

@Injectable()
export class PublishingService{
  publishingUrl:string= BOOK_URI + '/commodity';
  constructor(private http:HttpInterceptor){}

  /*获取所有发布信息*/
  getall(data): Observable<any>{
    return this.http.post(this.publishingUrl+'/page?page=1&size=5&owner=hexiuyu',data);
  }
    //根据id 获取发布的信息
   getPublishingById(index): Observable<any>{
    return this.http.get(this.publishingUrl+'/'+index)
   }
    //出租
   renting(assetData): Observable<any>{
    return this.http.post(this.publishingUrl,assetData);

   }
    //出售
   purchase(assetData):Observable<any>{
     return this.http.post(this.publishingUrl,assetData);
   }

}
