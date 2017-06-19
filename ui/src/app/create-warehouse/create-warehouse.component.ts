import { Component, OnInit } from '@angular/core';
import { Http, Request, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import {warehouse} from "./warehouse";

@Component({
  selector: 'app-create-warehouse',
  templateUrl: './create-warehouse.component.html',
  styleUrls: ['./create-warehouse.component.scss']
})
export class CreateWarehouseComponent implements OnInit {

  constructor(private http: HttpInterceptor) {
  }
  data :any=warehouse;
  ngOnInit() {


  }

  submit(data) {
    let body = JSON.stringify(data);
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post('http://10.101.164.248:8755/baseWarehouse/findById', body, options).map(res => res.json());
  };


}
