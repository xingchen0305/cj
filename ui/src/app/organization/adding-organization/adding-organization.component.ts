import { Component, OnInit } from '@angular/core';
import {HttpInterceptor} from "../../common/auth/HttpInterceptor";
import {OrganizationService} from "../../common/service/organization.service";

@Component({
  selector: 'app-adding-organization',
  templateUrl: './adding-organization.component.html',
  styleUrls: ['./adding-organization.component.scss']
})
export class AddingOrganizationComponent implements OnInit {
  data :any={};
  constructor( private organizationService: OrganizationService, private http: HttpInterceptor) { }

  ngOnInit() {
  }
  onSubmit(value){
    this.organizationService.addAsset(value).subscribe(
      (response)=>{
        console.log(response);
        alert("新增组织成功");
      }
    );
  }

}
