import { Component, OnInit } from '@angular/core';
import { DemoService } from '../common/service/demo.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
  providers: [DemoService]
})
export class DashboardComponent implements OnInit {

  constructor(private demoService: DemoService) { }

  ngOnInit() {
  }

  data: any;
  getDemos() {
    this.demoService.getData().subscribe(
      (response) => {
        this.data = JSON.stringify(response.json());
      }
    );
  }

  user:any ={
    grant_type: "password",
    scope:"read",
    username: "hexiuyu",
    password: "123456"
  }
  getToken(){
    this.demoService.getToken(this.user).subscribe(
      (response:any) => {
        console.log(response.json());
      }
    )
  }
}
