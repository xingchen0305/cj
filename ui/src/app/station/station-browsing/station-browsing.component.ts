import { Component, OnInit ,ViewChild} from '@angular/core';
import { DemoService } from '../../common/service/demo.service';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {parseHttpResponse} from "selenium-webdriver/http";
import {ActivatedRoute} from '@angular/router';
import {Router} from '@angular/router';
import {Routes} from '@angular/router';


@Component({
  selector: 'app-station-browsing',
  templateUrl: './station-browsing.component.html',
  styleUrls: ['./station-browsing.component.scss']
})
export class StationBrowsingComponent implements OnInit {
  isAdd: boolean;
  contact:any = {};
  constructor(private demoService: DemoService,private http: HttpInterceptor,private _router: Router,) { }

  ngOnInit(): void {
    this.getDemos();
  }
  data :any;
  getDemos() {
    this.demoService.getDemo().subscribe(
      (response) => {
        this.data =response.json();
        // this.data = response
        console.log(this.data);
        console.log(this.data.name);
        console.log(this.data.location);
      }
    );
  }
/*  param:any;
  check(id:string){
    console.log(id);
    return this.http.get('http://localhost:3000/cangku'+"/"+id).map((responce) => {
      this.param=responce.json();
    });
  }
  delete(id:string){
    console.log(id);
    return this.http.get('http://localhost:3000/cangku'+"/"+id).map((responce) => {
      this.param=responce.json();
    });
  }*/

/*  addWaehouse(){
    this._router.navigate(['/editInfo',1]);
  }*/

  addWaehouse() {
    this._router.navigate(['/editInfo',1]);
    let contacts_length = this.data.length;
    let new_id = this.data[contacts_length-1].id + 1;
    let new_contact = {
      "id": this.contact.id,
      "name": this.contact.name,
      "number": this.contact.number,
      "type": this.contact.type,
      "location": this.contact.location,
      "status": this.contact.status
    };
    this.data.push(new_contact);
    console.log(this.data);
    console.log(111);
/*    sessionStorage.setItem('contacts',JSON.stringify(this.data));
    this._router.navigate(['']);*/
  }

}
