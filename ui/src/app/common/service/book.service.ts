/**
 * Created by Administrator on 2017/6/23 0023.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";

@Injectable()
export class BookService{
  assetUrl: string = EQUIPMENT_URI + '/asset';
  constructor(private http: HttpInterceptor) { }
  /*
   * 获取书籍表
   * */
  /*  getAsset(): Observable<any> {
   return this.http.get(this.assetUrl+'/page?start=0');
   }*/

  getBooks( searchObj:Object): Observable<any> {

    return this.http.get(this.assetUrl+'/page?'+ this.http.generateUrlArgsByObj(searchObj));
  }
  getBookById(index): Observable<any> {
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }
  editById(index):Observable<any>{
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }
  /*
   * 编辑更新
   * */
  updateBook(assetData){
    return this.http.put(this.assetUrl+'/Asset/',assetData);
  }

  /*
   * 根据书籍唯一id发布书籍
   * */
  rentBookById(assetData,index):Observable<any>{
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }

}

