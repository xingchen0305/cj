import { Component, OnInit } from '@angular/core';
import { DemoService } from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {AssetService} from "../../common/service/asset.service";
import {WarehouseService} from "../../common/service/warehouse.service";

@Component({
  selector: 'app-member-browsing',
  templateUrl: './member-browsing.component.html',
  styleUrls: ['./member-browsing.component.scss']
})
export class MemberBrowsingComponent implements OnInit {

  constructor(private warehouseService: WarehouseService,private assetService: AssetService, private http: HttpInterceptor, private _router: Router,) {
  }

  ngOnInit() {
    this.pageChanged(1);
    this.pageChanged2(1);
  }
  name:any;
  warehouse_id:any
  state:any;
  data:any;
  warsehouse:any;
  totalResults:number;
  start:number;
  pageSize:number = 5;
  currentPage:number;
  searchArgs: Object = {
    size: this.pageSize,
    page: 1
  };

  delete(id,index){
    this.assetService.deleteById(id).subscribe(
      (response)=>{
        this.data.splice(index,1 );
      }
    )
  }
  pageChanged(event){
    this.searchArgs['page'] = event;
    this.assetService.getAsset(this.searchArgs).subscribe(
      (response) => {
        let body = response.json().data;
        this.data = body.results;
        console.log(this.data);
        this.totalResults = body.totalResults;
        this.currentPage=body.currentPage;
      }
    );
  }

  pageChanged2(event){

    this.searchArgs['page'] = event;
    //console.log(this.searchArgs['page']);
    this.warehouseService.getWareHouses(this.searchArgs).subscribe(
      (response) => {
        this.warsehouse = response.json().data.results;
        console.log(this.warsehouse);
      }
    );
  }
  pageChanged3(event){
    console.log(event);
   /* this.searchArgs['page'] = event;*/
    this.searchArgs['state'] = this.state;
    this.searchArgs['name'] = this.name;
    this.searchArgs['warehouse_id'] = this.warehouse_id;
    //console.log(this.searchArgs['page']);
    this.assetService.getAsset(this.searchArgs).subscribe(
      (response) => {
        this.data = response.json().data.results;
        console.log(this.data);

      }
    );
  }
}
