/**
 * Created by Administrator on 2017/7/5 0005.
 */
/**
 * Created by Administrator on 2017/6/23 0023.
 */
import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { EQUIPMENT_URI } from '../backen-const';
import { Observable } from 'rxjs';
import {HttpInterceptor} from "../auth/HttpInterceptor";

@Injectable()
export class OrganizationService{
  organizationUrl: string = EQUIPMENT_URI + '/organization';
  constructor(private http: HttpInterceptor) { }
  /*
   * 获取组织类表
   * */
  /*  getAsset(): Observable<any> {
   return this.http.get(this.assetUrl+'/page?start=0');
   }*/

  getOrg(index): Observable<any> {
    return this.http.get(this.organizationUrl+'/level/'+ index);
  }

  postSuperior(index):Observable<any>{
    return this.http.get(this.organizationUrl+'/superior/'+index);
  }

  /*
   * 新增组织
   * */
 addAsset(orgData){
   return this.http.post(this.organizationUrl+'/saveOrUpdate/',orgData);
   }

  /*getAssetById(index): Observable<any> {
    return this.http.get(this.organizationUrl+'/Asset/'+index);
  }
  editById(index):Observable<any>{
    return this.http.get(this.organizationUrl+'/Asset/'+index);
  }*/
  /*
   * 编辑更新
   * */
  /*updateAsset(assetData){
    return this.http.put(this.assetUrl+'/Asset/',assetData);
  }*/
  /*
   * 新增
   * */
 /* addAsset(assetData){
    return this.http.post(this.assetUrl+'/save/',assetData);
  }
  deleteById(index){
    return this.http.delete(this.assetUrl+'/Asset/'+index);
  }*/
  /*
   * 根据资产唯一id查询详情
   * */
  /*getDetailById(index):Observable<any>{
    return this.http.get(this.assetUrl+'/Asset/'+index);
  }*/
}
