import {Component, OnInit, ViewChild} from '@angular/core';
import {DemoService} from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {URLSearchParams, RequestOptionsArgs} from '@angular/http';
import {EQUIPMENT_URI} from "../../common/backen-const";
import {WarehouseService} from "../../common/service/warehouse.service";
import {isNumber} from "util";


@Component({
  selector: 'app-station-browsing',
  templateUrl: './station-browsing.component.html',
  styleUrls: ['./station-browsing.component.scss']
})
export class StationBrowsingComponent implements OnInit {

  constructor(private warehouseService: WarehouseService, private http: HttpInterceptor, private _router: Router,) {
  }

  ngOnInit(): void {
    this.pageChanged(1);
  }
  data: any;
  totalResults:number;
  start:number;
  pageSize:number = 5;
  currentPage:number;
  p: number = 3;
  searchArgs: Object = {
    size: this.pageSize,
    page: 1
  };

  delete(id, index) {
    console.log(id);
    this.http.get(EQUIPMENT_URI + "/baseWarehouse/deleteById" + "?id=" + id)
      .subscribe(
        res => {
          console.log(this.data);
          this.data.splice(index,1 );
          console.log(this.data);

        });
  }

  pageChanged(event){
    console.log(event);
    this.searchArgs['page'] = event;
    //console.log(this.searchArgs['page']);
    this.warehouseService.getWareHouses(this.searchArgs).subscribe(
      (response) => {
        let body = response.json().data;
        this.data = body.results;
        this.totalResults = body.totalResults;
        this.currentPage=body.currentPage;
      }
    );
  }


}
