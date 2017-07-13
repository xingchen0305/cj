import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import {AssetService} from "../common/service/asset.service";


@Component({
  selector: 'app-detail-assets',
  templateUrl: './detail-assets.component.html',
  styleUrls: ['./detail-assets.component.scss']
})
export class DetailAssetsComponent implements OnInit {
  asset_id:string;
  data:any ={};
  constructor(private assetService:AssetService,private http:HttpInterceptor,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.asset_id=this.activatedRoute.snapshot.params['id'];
    this.getaDetailById(this.asset_id);

  }
  getaDetailById(index){
    this.assetService.getAssetById(index).subscribe(
      (res)=>{
        console.log(res);
        this.data = res.json().data;
      }
    );

  }

}
