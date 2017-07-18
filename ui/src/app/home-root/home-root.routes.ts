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
import { BookDetailComponent } from '../book/book-detail/book-detail.component';
import { BooksPublishingComponent } from '../book/books-publishing/books-publishing.component';
import {HomeRootComponentGuard} from "./home-root.guard";
import { PurchaseBookComponent } from '../book/purchase-book/purchase-book.component';
import { RentingBookComponent } from '../book/renting-book/renting-book.component';
import { OrganizationManagementComponent } from '../organization/organization-management/organization-management.component';
import { AddingOrganizationComponent } from '../organization/adding-organization/adding-organization.component';
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
      {path:'attendanceRecord',
        children:[
          { path: '', component: AttendanceRecordComponent },
          { path: 'bookDetail', component: BookDetailComponent }]
     /*      { path: 'booksPublishing', component: BooksPublishingComponent }
        ]*/
      },
      {path:'stationBrowsing/warehouseOne/:id',component:WarehouseOneComponent},
      {path:'stationBrowsing/editInfo/:id',component:EditInfoComponent},
      {path:'stationBrowsing/createWarehouse',component: CreateWarehouseComponent},
      {path:'editAsset/:id',component:EditAssetComponent},
      {path:'newAsset',component:NewAssetsComponent},
      {path:'organizationManagementComponent',component:OrganizationManagementComponent},
      {path:'detailAssets/:id',component:DetailAssetsComponent},
      // { path: 'attendanceRecord/bookDetail', component: BookDetailComponent },
      { path: 'attendanceRecord/booksPublishing/:id', component: BooksPublishingComponent},
      { path: 'attendanceRecord/booksPublishing/purchase/:id', component: PurchaseBookComponent},
      { path: 'attendanceRecord/booksPublishing/renting/:id', component: RentingBookComponent },
      { path: 'addingOrganization', component: AddingOrganizationComponent }
    ]
  }
];
