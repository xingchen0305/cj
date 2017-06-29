/**
 * Created by Administrator on 2017/6/23 0023.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";

@Injectable()
export class AssetService{
  assetUrl: string = EQUIPMENT_URI + '/asset';
  constructor(private http: HttpInterceptor) { }
  /*
  * 获取资产类表
  * */
  getAsset(): Observable<any> {
    return this.http.get(this.assetUrl+'/page?start=0');
  }

  editById(index):Observable<any>{
    return this.http.get(this.assetUrl+'/testAsset/'+index);
  }
  /*
  * 更新
  * */
  updateAsset(assetData){
    return this.http.post(this.assetUrl+'/testAsset/',assetData);
  }
  deleteById(index){
    return this.http.delete(this.assetUrl+'/testAsset/'+index);
  }
}
