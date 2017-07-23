import { Component, OnInit } from '@angular/core';
import { DemoService } from '../common/service/demo.service';
import {HttpInterceptor} from "../common/auth/HttpInterceptor";
import { Observable } from 'rxjs';
import {UploadService} from "../common/service/upload.service";
import {Http, Request, RequestOptionsArgs, Response, RequestOptions, ConnectionBackend, Headers} from "@angular/http";
import {LocalStorageService} from "../common/local-storage.service";
import { BookService} from '../common/service/book.service';
import { Router} from '@angular/router';



@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  uploadedFiles: any[] = [];
  url:string = "http://10.101.166.144:8755/equipments/upload";
  constructor(private router:Router,private bookService: BookService,private _localStorageService: LocalStorageService,private http: HttpInterceptor,private demoService: DemoService,private uploadService:UploadService) { }

  ngOnInit(): void {
    this.getDemos();
  }

  data: any;
  getDemos() {
    this.demoService.getDemo().subscribe(
      (response) => {
        this.data=response.json();

       // this.data = JSON.stringify(response.json());
        //console.log(this.data);
       // console.log(this.data.id)
        // this.data = response
      }
    );
  }

  private onBeforeSend(event) {
    console.log("before")
    event.xhr.setRequestHeader("Authorization", "Bearer " + this._localStorageService.getAuth('access_token'));
  }

  private onBeforeUpload(event){
    console.log("add")
    event.formData.append("name","hxy");
  }

  onUpload(event) {
    console.log("onUpload")
  }

  onSubmit(value){
    console.log(value);
    this.bookService.rentBookById(value,1).subscribe(
      res=> {
        console.log(res);
        alert(" edit success")
 }
    )
  }
}


