import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import { Http, Request,URLSearchParams, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
import {WarehouseService} from "../common/service/warehouse.service";
import {AssetService} from "../common/service/asset.service";
import {warehouse} from "../create-warehouse/warehouse";

@Component({
  selector: 'app-warehouse-one',
  templateUrl: './warehouse-one.component.html',
  styleUrls: ['./warehouse-one.component.scss']
})
export class WarehouseOneComponent implements OnInit {
  warehouse_id:string;

  constructor(private activatedRoute:ActivatedRoute,private assetService: AssetService,private http: HttpInterceptor) { }

  ngOnInit() {
    this.warehouse_id=this.activatedRoute.snapshot.params['id'];
    this.getWareHouse(this.warehouse_id);
  }
  data:any;

  getWareHouse(index){
    this.assetService.getAssetById(index).subscribe(
      (res) =>{
        this.data = res.json().data;
        console.log(res);
      }
    )
  }

  editInfo(index){
    /*    let body= JSON.stringify({id: index});
     console.log(body);
     var headers = new Headers();
     headers.append('Content-Type','application/json');

     return this.http.post('http://10.101.164.248:8755/baseWarehouse/findById',body, {
     headers: headers
     }).map(res =>this.data=res.json())
     .subscribe(
     );*/
    let params: URLSearchParams = new URLSearchParams();
    params.set('id',index);
    this.http.get("http://10.101.164.248:8755/baseWarehouse/findById",{search:params})
    /*  .map(rsp=>rsp.json())*/.subscribe(
      res=> {
        this.data =res.json().data;
        /* console.log(this.data);*/
      });
  }


}
