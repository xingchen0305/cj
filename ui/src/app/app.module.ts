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
import {provideAppConfig} from "./app.config";
import { WarehouseOneComponent } from './warehouse-one/warehouse-one.component';
import { WarehouseTwoComponent } from './warehouse-two/warehouse-two.component';
import { EditInfoComponent } from './edit-info/edit-info.component';
import { CreateWarehouseComponent } from './create-warehouse/create-warehouse.component';

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
    WarehouseTwoComponent,
    EditInfoComponent,
    CreateWarehouseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    //bootstrap
    BsDropdownModule.forRoot(),
    AlertModule.forRoot(),
    ModalModule.forRoot(),

    // app
    // RouterModule.forRoot([
    //   {
    //     path: 'login',
    //     component: LoginComponent,
    //     //canActivate:[UnauthenticatedGuard]
    //   }
    // ]),
    RouterModule.forRoot(routes),
  ],
  providers: [
    UserService,
    LocalStorageService,
    provideHttpInterceptor(),
    provideAppConfig(),
    UnauthenticatedGuard,
    HomeRootComponentGuard,
    DemoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
