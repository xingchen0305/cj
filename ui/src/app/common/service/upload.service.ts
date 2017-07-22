/**
 * Created by Administrator on 2017/7/21 0021.
 */
/**
 * Created by Administrator on 2017/6/23 0023.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { BOOK_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";

@Injectable()
export class UploadService{
  imgUrl: string ='10.101.166.144:8755/equipments/upload';
  bookUrl:string=BOOK_URI+'/book';
  constructor(private http: HttpInterceptor) { }
  /*
   * 获取书籍表
   * */
  /*  getAsset(): Observable<any> {
   return this.http.get(this.assetUrl+'/page?start=0');
   }*/

  uploadImgs(searchObj:Object): Observable<any> {
    return this.http.post(this.imgUrl,searchObj);
  }




}

