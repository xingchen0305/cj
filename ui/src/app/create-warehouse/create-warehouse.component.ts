import { Component, OnInit } from '@angular/core';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import {WarehouseService} from "../common/service/warehouse.service";
import { Router} from '@angular/router';

@Component({
  selector: 'app-create-warehouse',
  templateUrl: './create-warehouse.component.html',
  styleUrls: ['./create-warehouse.component.scss']
})
export class CreateWarehouseComponent implements OnInit {

  constructor(private router:Router,private warehouseService: WarehouseService,private http: HttpInterceptor) {
  }
  data :any={};
  ngOnInit() {
  }
  onSubmit(value){
    this.warehouseService.editWareHouse(value).subscribe(
      res=> {
        console.log(res);
        this.router.navigateByUrl("/stationBrowsing");
        /*alert(" edit success")*/}
    )
  }

}
