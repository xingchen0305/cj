import { Component, OnInit } from '@angular/core';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {OrganizationService} from "../../common/service/organization.service";

@Component({
  selector: 'app-organization-management',
  templateUrl: './organization-management.component.html',
  styleUrls: ['./organization-management.component.scss']
})
export class OrganizationManagementComponent implements OnInit {
 /* index:number=1;*/
  index:String='1';
  id:String;
  data:any;
  city:any;
  school:any;
  room:any;
  distract:any;
  constructor( private organizationService: OrganizationService, private http: HttpInterceptor) { }

  ngOnInit() {
    this.getOrgs();

  }
  getOrgs(){
    this.organizationService.getOrg(this.index).subscribe(
      (response)=>{
        this.data = response.json().data;
        console.log(response.json().data);
      }
    );
  }

  postSuperior(id){
    this.organizationService.postSuperior(id).subscribe(
      (response)=>{
        console.log(id);
          this.city = response.json().data;
        /*  this.school = response.json().data;
          this.school = response.json().data;*/
      }
    )
  }
  postSuperior1(id){
    this.organizationService.postSuperior(id).subscribe(
      (response)=>{
        console.log(id);
        this.distract = response.json().data;
        console.log(this.distract);
        /*  this.school = response.json().data;
         this.school = response.json().data;*/
      }
    )
  }
  postSuperior2(id){
    this.organizationService.postSuperior(id).subscribe(
      (response)=>{
        console.log(id);
        this.school = response.json().data;
        console.log(this.school);

      }
    )
  }
  postSuperior3(id){
    this.organizationService.postSuperior(id).subscribe(
      (response)=>{
        console.log(id);
        this.room = response.json().data;
        console.log(this.room);
        /*  this.school = response.json().data;
         this.school = response.json().data;*/
      }
    )
  }


}
