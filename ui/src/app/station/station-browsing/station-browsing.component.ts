import {Component, OnInit, ViewChild} from '@angular/core';
import {DemoService} from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {URLSearchParams, RequestOptionsArgs} from '@angular/http';
import {EQUIPMENT_URI} from "../../common/backen-const";
import {WarehouseService} from "../../common/service/warehouse.service";


@Component({
  selector: 'app-station-browsing',
  templateUrl: './station-browsing.component.html',
  styleUrls: ['./station-browsing.component.scss']
})
export class StationBrowsingComponent implements OnInit {
  isAdd: boolean;
  contact: any = {};

  constructor(private warehouseService: WarehouseService, private http: HttpInterceptor, private _router: Router,) {
  }

  ngOnInit(): void {
    this.getWarehouses();
  }

  data: any;

  getWarehouses() {
    this.warehouseService.getWareHouses().subscribe(
      (response) => {
        this.data = response.json().data.results;
        console.log(this.data)
      }
    );
  }

  delete(id, index) {
    console.log(id);
    this.http.get(EQUIPMENT_URI + "/baseWarehouse/deleteById" + "?ids=" + id)
      .subscribe(
        res => {
          console.log(this.data);
          this.data.splice(index,1 );
          console.log(this.data);

        });
  }




}
