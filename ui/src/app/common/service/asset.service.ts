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
/*  getAsset(): Observable<any> {
    return this.http.get(this.assetUrl+'/page?start=0');
  }*/

  getAsset( searchObj:Object): Observable<any> {

    return this.http.get(this.assetUrl+'/page?'+ this.http.generateUrlArgsByObj(searchObj));
  }
  getAssetById(index): Observable<any> {
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }
  editById(index):Observable<any>{
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }
  /*
  * 编辑更新
  * */
  updateAsset(assetData){
    return this.http.put(this.assetUrl+'/Asset/',assetData);
  }
  /*
  * 新增
  * */
  addAsset(assetData){
    return this.http.post(this.assetUrl+'/save/',assetData);
  }
  deleteById(index){
    return this.http.delete(this.assetUrl+'/Asset/'+index);
  }
  /*
  * 根据资产唯一id查询详情
  * */
  getDetailById(index):Observable<any>{
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }
}
