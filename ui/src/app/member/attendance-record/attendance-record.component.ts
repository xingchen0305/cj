import { Component, OnInit } from '@angular/core';
import { BookService} from '../../common/service/book.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {Router} from '@angular/router';

@Component({
  selector: 'app-attendance-record',
  templateUrl: './attendance-record.component.html',
  styleUrls: ['./attendance-record.component.scss']
})
export class AttendanceRecordComponent implements OnInit {

  constructor(private bookService: BookService, private http: HttpInterceptor, private _router: Router,) { }

  ngOnInit() {
    this.getBooks();
  }
  data:any;
  totalResults:number;
  totalPages:number;
  start:number;
  pageSize:number = 5;
  currentPageLength:number;
  currentPage:number;
  searchArgs: Object = {
    size: this.pageSize,
    page: 1,
    type:'book'
  };
  getBooks(){
    this.bookService.getBooks(this.searchArgs).subscribe(
      (response)=>{
        this.data=response.json().data.results;
        console.log(this.data)

      }
    )

  }
  pageChanged(event){
    console.log(event);
    this.searchArgs['page'] = event;
    //console.log(this.searchArgs['page']);
    this.bookService.getBooks(this.searchArgs).subscribe(
      (response) => {
        let body = response.json().data;
        this.data = body.results;
        this.totalResults = body.totalResults;
        this.currentPage=body.currentPage;
      }
    );
  }

}
