import { Component, OnInit } from '@angular/core';
import { DemoService } from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";

@Component({
  selector: 'app-member-browsing',
  templateUrl: './member-browsing.component.html',
  styleUrls: ['./member-browsing.component.scss']
})
export class MemberBrowsingComponent implements OnInit {

  constructor(private demoService: DemoService,private http: HttpInterceptor) { }

  ngOnInit() {
    this.getDemos();
  }
  data:any;
  getDemos(){
    this.demoService.getDemoL().subscribe(
      (response)=>{
        this.data=response.json();
      }
    );
}
}
