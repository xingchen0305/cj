import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { HomeRootComponent } from './home-root/home-root.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { routes } from './app.routes';
import { RouterModule } from '@angular/router';
import { BsDropdownModule, AlertModule, ModalModule } from 'ngx-bootstrap';
import { StationBrowsingComponent } from './station/station-browsing/station-browsing.component';
import { MemberBrowsingComponent } from './member/member-browsing/member-browsing.component';
import { AttendanceRecordComponent } from './member/attendance-record/attendance-record.component';
import {UserService} from "./common/auth/auth.service";
import {LocalStorageService} from "./common/local-storage.service";
import {provideHttpInterceptor} from "./common/auth/http-interceptor-provider";
import {UnauthenticatedGuard} from "./login/unauthenticated.guard";
import {HomeRootComponentGuard} from "./home-root/home-root.guard";
import {TopnavComponent} from "./home-root/topnav/topnav.component";
import {SidebarComponent} from "./home-root/sidebar/sidebar.component";
import {DemoService} from "./common/service/demo.service";
import {OrganizationService} from "./common/service/organization.service";
import {provideAppConfig} from "./app.config";
import { WarehouseOneComponent } from './warehouse-one/warehouse-one.component';
import { EditInfoComponent } from './edit-info/edit-info.component';
import { CreateWarehouseComponent } from './create-warehouse/create-warehouse.component';
import {WarehouseService} from "./common/service/warehouse.service";
import {AssetService} from "./common/service/asset.service";
import {BookService} from "./common/service/book.service";
import {UploadService} from "./common/service/upload.service";
import { EditAssetComponent } from './edit-asset/edit-asset.component';
import {AuthWithTokenService} from "./common/auth/auth-with-token.service";
import { SignUpComponent } from './sign-up/sign-up.component';
import { NewAssetsComponent } from './new-assets/new-assets.component';
import { DetailAssetsComponent } from './detail-assets/detail-assets.component';
import {NgxPaginationModule} from "ngx-pagination";
import { BookDetailComponent } from './book/book-detail/book-detail.component';
import { BooksPublishingComponent } from './book/books-publishing/books-publishing.component';
import { PurchaseBookComponent } from './book/purchase-book/purchase-book.component';
import { RentingBookComponent } from './book/renting-book/renting-book.component';
import { OrganizationManagementComponent } from './organization/organization-management/organization-management.component';
import { AddingOrganizationManagementComponent } from './book/adding-organization-management/adding-organization-management.component';
import { AddingOrganizationComponent } from './organization/adding-organization/adding-organization.component';
import {ButtonModule, FileUploadModule} from "primeng/primeng";
@NgModule({
  declarations: [
    AppComponent,
    HomeRootComponent,
    DashboardComponent,
    LoginComponent,
    StationBrowsingComponent,
    MemberBrowsingComponent,
    AttendanceRecordComponent,
    TopnavComponent,
    SidebarComponent,
    WarehouseOneComponent,
    EditInfoComponent,
    CreateWarehouseComponent,
    EditAssetComponent,
    SignUpComponent,
    NewAssetsComponent,
    DetailAssetsComponent,
    BookDetailComponent,
    BooksPublishingComponent,
    PurchaseBookComponent,
    RentingBookComponent,
    OrganizationManagementComponent,
    AddingOrganizationManagementComponent,
    AddingOrganizationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    //bootstrap
    BsDropdownModule.forRoot(),
    AlertModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(routes),
    NgxPaginationModule,

    FileUploadModule,
    ButtonModule

    // app
    // RouterModule.forRoot([
    //   {
    //     path: 'login',
    //     component: LoginComponent,
    //     //canActivate:[UnauthenticatedGuard]
    //   }
    // ]),

  ],
  providers: [
    UserService,
    LocalStorageService,
    provideHttpInterceptor(),
    provideAppConfig(),
    UnauthenticatedGuard,
    HomeRootComponentGuard,
    DemoService,
    WarehouseService,
    AssetService,
    AuthWithTokenService,
    BookService,
    UploadService,
    OrganizationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
