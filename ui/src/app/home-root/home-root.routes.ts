import { HomeRootComponent } from './home-root.component';
import { Routes } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { StationBrowsingComponent } from '../station/station-browsing/station-browsing.component';
import { MemberBrowsingComponent } from '../member/member-browsing/member-browsing.component';
import { AttendanceRecordComponent } from '../member/attendance-record/attendance-record.component';
import {WarehouseOneComponent } from '../warehouse-one/warehouse-one.component';
import {EditInfoComponent } from '../edit-info/edit-info.component';
import {EditAssetComponent } from '../edit-asset/edit-asset.component';
import { CreateWarehouseComponent } from '../create-warehouse/create-warehouse.component';
import { NewAssetsComponent } from '../new-assets/new-assets.component';
import { DetailAssetsComponent } from '../detail-assets/detail-assets.component';
import {HomeRootComponentGuard} from "./home-root.guard";
export const HomeRootRoutes: Routes = [
  {
    path: '',
    component: HomeRootComponent,
    canActivate: [HomeRootComponentGuard],
    children: [
      { path: '', component: DashboardComponent },
      { path: 'dashboard', component: DashboardComponent },
      {path:'stationBrowsing',component:StationBrowsingComponent,children:[
/*        {path:'warehouseOne',component:WarehouseOneComponent},
        {path:'warehouseTwo',component:WarehouseTwoComponent}*/
      ]},
      {path:'memberBrowsing',component:MemberBrowsingComponent},
      {path:'attendanceRecord',component:AttendanceRecordComponent},
      {path:'warehouseOne/:id',component:WarehouseOneComponent},
      {path:'editInfo/:id',component:EditInfoComponent},
      {path:'createWarehouse',component: CreateWarehouseComponent},
      {path:'editAsset/:id',component:EditAssetComponent},
      {path:'newAsset',component:NewAssetsComponent},
      {path:'detailAssets/:id',component:DetailAssetsComponent},


    ]
  }
];
