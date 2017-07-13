import { Component, OnInit } from '@angular/core';
import {AssetService} from "../common/service/asset.service";
import {HttpInterceptor} from "../common/auth/HttpInterceptor";

@Component({
  selector: 'app-new-assets',
  templateUrl: './new-assets.component.html',
  styleUrls: ['./new-assets.component.scss']
})
export class NewAssetsComponent implements OnInit {
  data: any={};
  constructor(private assetService:AssetService,private http:HttpInterceptor ) { }

  ngOnInit() {
  }

  onSubmit(value){
    this.assetService.addAsset(value).subscribe(
      res=>{
        alert(" add success")
      }
    );
  }
}
