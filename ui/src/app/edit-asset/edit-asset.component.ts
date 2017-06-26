import {Component, Inject, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import { Http, Request,URLSearchParams, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers } from '@angular/http';
import {AssetService} from "../common/service/asset.service";

@Component({
  selector: 'app-edit-asset',
  templateUrl: './edit-asset.component.html',
  styleUrls: ['./edit-asset.component.scss']
})

export class EditAssetComponent implements OnInit {
  asset_id:string;
  data:any ={};
  constructor(private activatedRoute:ActivatedRoute,private assetService:AssetService,private http: HttpInterceptor) { }

  ngOnInit() {
    this.asset_id=this.activatedRoute.snapshot.params['id'];
    this.getAsset(this.asset_id);
  }
  getAsset(index){
    this.assetService.editById(index).subscribe(
      (res)=>{
        console.log(res);
        this.data=res.json().data;
        console.log(this.data.count);
      }
    );
  }
  onSubmit(value){
    this.assetService.updateAsset(value).subscribe(
      res=>{
        console.log(res);
       /* alert(" edit success")*/
      }
    );
  }

  delete(id, index) {
     this.assetService.deleteById(id).subscribe(
      res => {
        console.log(this.data);
        this.data.splice(index,1 );
        console.log(this.data);
      }
    );


  }
}
