import { Component, OnInit ,ViewChild} from '@angular/core';
import { DemoService } from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import { URLSearchParams, RequestOptionsArgs } from '@angular/http';


@Component({
  selector: 'app-station-browsing',
  templateUrl: './station-browsing.component.html',
  styleUrls: ['./station-browsing.component.scss']
})
export class StationBrowsingComponent implements OnInit {
  isAdd: boolean;
  contact:any = {};
  constructor(private demoService: DemoService,private http: HttpInterceptor,private _router: Router,) { }

  ngOnInit(): void {
    this.getDemos();
  }
  data :any;
  getDemos() {
    this.demoService.getDemo().subscribe(
      (response) => {
        this.data =response.json().data.results;
        // this.data = response
      }
    );
  }

  delete(index){
    let params: URLSearchParams = new URLSearchParams();
    params.set('id',index);
    this.http.get("http://10.101.164.248:8755/baseWarehouse/deleteById",{search:params})
    /*  .map(rsp=>rsp.json())*/.subscribe(
      res=> {
    this.data =res.json().data;
    console.log(this.data);
      });
  }


}
