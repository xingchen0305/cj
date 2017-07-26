import { Component, OnInit } from '@angular/core';
import { BookService} from '../../common/service/book.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {Router} from '@angular/router';
import {PublishingService} from '../../common/service/publishing.service';
import {LocalStorageService} from "../../common/local-storage.service";


@Component({
  selector: 'app-attendance-record',
  templateUrl: './attendance-record.component.html',
  styleUrls: ['./attendance-record.component.scss']
})
export class AttendanceRecordComponent implements OnInit {
  user: any = {
    username: ''
  };
  data:any;
  totalResults:number;
  start:number;
  pageSize:number = 10;
  currentPage:number;
  state:number=1;
  searchArgs: Object = {
    size: this.pageSize,
    page: 1,
  };
  constructor(private _localStorageService: LocalStorageService, private publishingService:PublishingService,private bookService: BookService, private http: HttpInterceptor, private _router: Router,) { }

  ngOnInit() {
      this.user.username = this._localStorageService.getAuth('username');
      console.log(this.user.username);
    this.pageChanged(1);

  }

  pageChanged(event){
    console.log(event);
    this.searchArgs['page'] = event;
    this.searchArgs['owner']=this.user.username;
    this.publishingService.getall("").subscribe(
      (response) => {
        let body = response.json().data;
        /*console.log(body);*/
        this.data = body.results;
        console.log(this.data);
        this.totalResults = body.totalResults;
        this.currentPage=body.currentPage;
      }
    );
  }


}
