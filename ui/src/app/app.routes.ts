import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeRootRoutes } from './home-root/home-root.routes';
import {UnauthenticatedGuard} from "./login/unauthenticated.guard";
export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [UnauthenticatedGuard]
  },
  ...HomeRootRoutes
];
