import { Component, OnInit } from '@angular/core';
import { Http, Request, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import {warehouse} from "./warehouse";
import {WarehouseService} from "../common/service/warehouse.service";

@Component({
  selector: 'app-create-warehouse',
  templateUrl: './create-warehouse.component.html',
  styleUrls: ['./create-warehouse.component.scss']
})
export class CreateWarehouseComponent implements OnInit {

  constructor(private warehouseService: WarehouseService,private http: HttpInterceptor) {
  }
  data :any={};
  ngOnInit() {
  }
  onSubmit(value){
    this.warehouseService.editWareHouse(value).subscribe(
      res=> {alert(" edit success")}
    )
  }

}
