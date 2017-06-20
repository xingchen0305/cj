import { FactoryProvider } from '@angular/core';
import { XHRBackend, RequestOptions } from '@angular/http';
import { Router } from '@angular/router';
import { HttpInterceptor } from './HttpInterceptor';
import { LocalStorageService } from '../local-storage.service';
import {UserService} from "./auth.service";

/**
 * Created by John Zhang on 16/11/15.
 */
export function interceptorFactory(xhrBackend: XHRBackend, requestOptions: RequestOptions,
                                   _localStorageService: LocalStorageService,
                                   userService: UserService, router: Router){
  return new HttpInterceptor(xhrBackend, requestOptions, _localStorageService, userService, router);
}

export function provideHttpInterceptor(): FactoryProvider {

  return {
    provide: HttpInterceptor,
    useFactory: interceptorFactory,
    deps: [XHRBackend, RequestOptions, LocalStorageService, UserService, Router]
  };
}
