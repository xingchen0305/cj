import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import { Http, Request,URLSearchParams, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
@Component({
  selector: 'app-edit-info',
  templateUrl: './edit-info.component.html',
  styleUrls: ['./edit-info.component.scss']
})
export class EditInfoComponent implements OnInit {

  warehouse_id:string;

  constructor(private activatedRoute:ActivatedRoute,private demoService: DemoService,private http: HttpInterceptor) { }
  ngOnInit() {
    this.warehouse_id=this.activatedRoute.snapshot.params['id'];
    this.editInfo(this.warehouse_id);
  }
  data:any;
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

/*  编辑的提交方法
  submit(obj:any):void{
    alert(obj + '已经被提交!');
    console.log(obj)
    this.http.post("http://10.101.164.248:8755/baseWarehouse/saveOrUpdate", this.data).subscribe(res=> {
      console.log(res);
    });
  }*/

}
