import { Component, OnInit } from '@angular/core';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import {WarehouseService} from "../common/service/warehouse.service";
import { Router} from '@angular/router';
import {OrganizationService} from "../common/service/organization.service";

@Component({
  selector: 'app-create-warehouse',
  templateUrl: './create-warehouse.component.html',
  styleUrls: ['./create-warehouse.component.scss']
})
export class CreateWarehouseComponent implements OnInit {

  constructor(private organizationService: OrganizationService, private router:Router,private warehouseService: WarehouseService,private http: HttpInterceptor) {
  }
  data :any={};
  index:String='5';
  warehouse:any=[];
  location:String;
  orgId:String;
  warsehouseInfo:any=[];

  ngOnInit() {
    this.getOrgs();
  }
  getOrgs(){
    this.organizationService.getOrg(this.index).subscribe(
      (response)=>{
        this.warehouse = response.json().data;
        console.log(this.warehouse);
      }
    );
  }
  onSubmit(value){
    console.log(value);
    this.warehouseService.addWareHouse(value).subscribe(
      res=> {
        console.log(res);
        this.router.navigateByUrl("/stationBrowsing");
        /*alert(" edit success")*/}
    )
  }

}
