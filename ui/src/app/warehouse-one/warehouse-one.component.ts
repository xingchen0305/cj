import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {observableToBeFn} from "rxjs/testing/TestScheduler";
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";

@Component({
  selector: 'app-warehouse-one',
  templateUrl: './warehouse-one.component.html',
  styleUrls: ['./warehouse-one.component.scss']
})
export class WarehouseOneComponent implements OnInit {
  warehouse_id:string;

  constructor(private activatedRoute:ActivatedRoute,private demoService: DemoService,private http: HttpInterceptor) { }

  ngOnInit() {
    this.warehouse_id=this.activatedRoute.snapshot.params['id'];
    this.getDemos(this.warehouse_id);
  }
  data:any;
 getDemos(index){
   this.demoService.getDemo().subscribe(
     (response)=>{
       this.data=response.json();
     }
   );

 }

}
