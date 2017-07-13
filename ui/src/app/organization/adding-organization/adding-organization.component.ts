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
  level: any= {
    country: 1,
    city: 2,
    qu: 3,
    school: 4,
    building: 5
  };

  contryName="";
  cityName="";
  quName="";
  schoolName="";
  buildingName="";

  currentSelect:any = {
    1:"",
    2:"",
    3:"",
    4:"",
    5:""
  }



  selectMap = new Map();



  constructor( private organizationService: OrganizationService, private http: HttpInterceptor) { }

  ngOnInit() {
    this.getOrgBySuperior(-1,1);
  }


  onSubmit(value){
    this.organizationService.addAsset(value).subscribe(
      (response)=>{
        console.log(response);
        alert("新增组织成功");
      }
    );
  }

  getOrgBySuperior(superiorId, currentLevel){
    this.organizationService.postSuperior(superiorId).subscribe(
      (res) => {
        this.selectMap.set(currentLevel,res.json().data);
        // 拿到本级菜单，下面的菜单清空
        for(let key of Array.from(this.selectMap.keys())){
          if(key > currentLevel)
            this.selectMap.delete(key);
        }

        console.log("selectMap", this.selectMap)
      }
    )
  }

  createOrg(name:string, level: number, superior: number){
    let postData = {
      name: name,
      level: level,
      superior: superior
    };
    this.organizationService.addAsset(postData).subscribe(
      () =>  this.getOrgBySuperior(superior, level)
    );
    this.contryName="";
    this.cityName="";
    this.quName="";
    this.schoolName="";
    this.buildingName="";
  }

  onChange(currentId, currentLevel, targetLevel){
    this.currentSelect[currentLevel] = currentId;
    this.getOrgBySuperior(currentId, targetLevel)
  }

}
