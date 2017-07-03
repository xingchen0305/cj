import { Component, OnInit } from '@angular/core';
import { DemoService } from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {AssetService} from "../../common/service/asset.service";

@Component({
  selector: 'app-member-browsing',
  templateUrl: './member-browsing.component.html',
  styleUrls: ['./member-browsing.component.scss']
})
export class MemberBrowsingComponent implements OnInit {

  constructor(private assetService: AssetService, private http: HttpInterceptor, private _router: Router,) {
  }

  ngOnInit() {
    this.getAssets();
  }
  data:any;
  totalResults:number;
  totalPages:number;
  start:number;
  pageSize:number = 5;
  currentPageLength:number;
  currentPage:number;
  searchArgs: Object = {
    size: this.pageSize,
    page: 1
  };
  getAssets(){
    this.assetService.getAsset(this.searchArgs).subscribe(
      (response)=>{
        this.data = response.json().data.results;
        console.log(this.data)
      }
    );
  }
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
        this.totalResults = body.totalResults;
        this.currentPage=body.currentPage;
      }
    );
  }
}
