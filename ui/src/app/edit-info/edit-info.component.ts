import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
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
    this.demoService.getDemo().subscribe(
      (response)=>{
        this.data=response.json();
        console.log(this.data);
      }
    );
  };
/*  编辑的提交方法
  submit():void{
    this.http.post(url, this.data).subscribe(res=> {
      console.log(res);
    });
  }*/

}
