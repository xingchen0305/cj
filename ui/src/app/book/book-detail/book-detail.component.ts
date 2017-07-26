import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {PublishingService} from '../../common/service/publishing.service'

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.scss']
})
export class BookDetailComponent implements OnInit {
  asset_id:string;
  data:any;
  constructor(private activatedRoute:ActivatedRoute ,private publishingService: PublishingService) {
    this.asset_id=this.activatedRoute.snapshot.params['id'];
  }

  ngOnInit() {
    console.log(this.asset_id);
    this.getAssetDetailById();
  }
  //根据id查询资产详情
  getAssetDetailById(){
    this.publishingService.getPublishingById(this.asset_id).subscribe(
      (res)=>{
        this.data=res.json().data;
        console.log(this.data)

      }
    )

  }

}
