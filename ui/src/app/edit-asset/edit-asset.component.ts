import {Component, Inject, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";

import {AssetService} from "../common/service/asset.service";
import { Router} from '@angular/router';

@Component({
  selector: 'app-edit-asset',
  templateUrl: './edit-asset.component.html',
  styleUrls: ['./edit-asset.component.scss']
})

export class EditAssetComponent implements OnInit {
  asset_id:string;
  data:any ={};
  constructor(private router:Router,private activatedRoute:ActivatedRoute,private assetService:AssetService,private http: HttpInterceptor) { }

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
         alert(" edit success")
        this.router.navigateByUrl("/memberBrowsing");

      }
    );
  }

  delete(id, index) {
     this.assetService.deleteById(id).subscribe(
      res => {
        console.log(this.data);
        this.data.splice(index,1 );
        console.log(this.data);
        this.router.navigateByUrl("/stationBrowsing");
      }
    );


  }
}
