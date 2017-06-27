import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import { Http, Request,URLSearchParams, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
import {WarehouseService} from "../common/service/warehouse.service";
@Component({
  selector: 'app-edit-info',
  templateUrl: './edit-info.component.html',
  styleUrls: ['./edit-info.component.scss']
})
export class EditInfoComponent implements OnInit {

  warehouse_id:string;
  data:any ={};

  constructor(private activatedRoute:ActivatedRoute,private warehouseService: WarehouseService,private http: HttpInterceptor) { }
  ngOnInit() {
    this.warehouse_id=this.activatedRoute.snapshot.params['id'];
    this.getWareHouse(this.warehouse_id);
  }

  getWareHouse(index){
    this.warehouseService.getWareHouseById(index).subscribe(
      (res) =>{
        this.data = res.json().data;
      }
    )
  }

  onSubmit(value){
    this.warehouseService.editWareHouse(value).subscribe(
      res=> {
        alert(" edit success");
      }
      )
  }


}
