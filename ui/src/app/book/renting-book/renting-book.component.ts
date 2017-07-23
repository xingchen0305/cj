import { Component, OnInit,ViewChild} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookService} from '../../common/service/book.service';
import { Router} from '@angular/router';
import {DemoService} from "../../common/service/demo.service";
import {UploadService} from "../../common/service/upload.service";
import {Http} from "@angular/http";
import {LocalStorageService} from "../../common/local-storage.service";
import {FileUpload} from "primeng/components/fileupload/fileupload";
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {AssetService} from "../../common/service/asset.service";


@Component({
  selector: 'app-renting-book',
  templateUrl: './renting-book.component.html',
  styleUrls: ['./renting-book.component.scss']
})
export class RentingBookComponent implements OnInit {
  data:any ={};
  obj:any ={};
  book_id:string;
  purchase_type: number= 1;
  rent_type: number= 2;
  uploadedFiles: any[] = [];
/*  url:string = "http://10.101.166.144:8755/equipments/testFile";*/
  url:string = "http://10.101.164.137:8756/commodity";
  name: string;
  image:any;
  images:any[] = new Array<any>();

  @ViewChild("myProfile") fileUploadModule:FileUpload;
  constructor(private assetService:AssetService,private _localStorageService: LocalStorageService,private http: HttpInterceptor,private demoService: DemoService,private uploadService:UploadService,private router:Router,private bookService: BookService,private activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.book_id=this.activatedRoute.snapshot.params['id'];
    this.fileUploadModule.showUploadButton = false;
    this.getaDetailById(this.book_id);
  }
  //根据id拿资产
  getaDetailById(index){
    this.assetService.getAssetById(index).subscribe(
      (res)=>{
        this.name= res.json().data.name;
        console.log(this.name);
      }
    );

  }

  onSubmit(value){
    let files:File[] = this.fileUploadModule.files;
    this.obj['book']=value;
    this.obj['businessType'] = this.rent_type;
    this.readfiles(files, 0, this.obj);

  }

  readfiles(files:File[], index, other:any ){
      let reader = new FileReader();
      if(index >= files.length){
        return
      }
      reader.onloadend =(e) => {
          let  image = reader.result;
          this.images.push(image);
          if(index === files.length-1){
            let data = other;
            data["imageList"] = this.images;
            data["name"] = this.name;
            console.log("hxy", data);
            this.http.post(this.url, data).subscribe((res)=>{
              this.router.navigateByUrl("/attendanceRecord");
            });
          }
        };
      reader.readAsDataURL(this.fileUploadModule.files[index]);
      this.readfiles(files,index+1,other);
  }







}
