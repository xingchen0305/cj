import {Component, OnInit, ViewChild} from "@angular/core";
import {DemoService} from "../common/service/demo.service";
import {UploadService} from "../common/service/upload.service";
import {Http} from "@angular/http";
import {LocalStorageService} from "../common/local-storage.service";
import {FileUpload} from "primeng/components/fileupload/fileupload";
import {HttpInterceptor} from "../common/auth/HttpInterceptor";

declare let $;
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  uploadedFiles: any[] = [];
  url:string = "http://10.101.166.144:8755/equipments/testImage";
  data: any;
  name: string;
  image:any;

  @ViewChild("myProfile") fileUploadModule:FileUpload;

  constructor(private _localStorageService: LocalStorageService,private http: HttpInterceptor,private demoService: DemoService,private uploadService:UploadService) { }
  ngOnInit(): void {
    this.fileUploadModule.showUploadButton = false;
  }

  onSubmit(){
    // let options = new RequestOptions();
    // options.method = RequestMethod.Post;
    // options.headers = new Headers();
    // options.headers.append('Authorization', 'Bearer ' + this._localStorageService.getAuth('access_token'));
    // options.headers.append("Content-Type", "")
    // let formParams = new FormData();
    // console.log(options)
    // formParams.append('file',this.fileUploadModule.files[0]);
    // options.body = formParams;
    // console.log(options);
    // this.http.request(this.url, options).subscribe(()=>{});
    //
    //
    // var xhr = new XMLHttpRequest();
    // xhr.setRequestHeader("")


    // let formParams = new FormData();
    // let data = "name=hexiuyu&age=10"
    // // formParams.append("data", JSON.stringify(data));
    // formParams.append("data", data);
    // formParams.append('file',this.fileUploadModule.files[0]);
    // $.ajax({
    //   url:this.url,
    //   type: 'POST',
    //   data: formParams,
    //   processData: false,
    //   contentType: false,
    //   headers:{
    //     "Authorization":'Bearer '+ this._localStorageService.getAuth('access_token')
    //   }
    // });



    var myReader:FileReader = new FileReader();
    myReader.onloadend = (e) => {
      this.image = myReader.result;
      console.log(this.image);
      this.http.post(this.url,this.image).subscribe(()=>{})
    };
    myReader.readAsDataURL(this.fileUploadModule.files[0]);

  }

}
