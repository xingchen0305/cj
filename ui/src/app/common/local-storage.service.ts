import { Injectable } from '@angular/core';


@Injectable()
export class LocalStorageService {

  private AUTH_KEY = 'sam_auth';
  private LAST_VISIT_URL_KEY = 'sam_lastVisitUrl';

  getAuth(key?) :any {
    let authJson = localStorage.getItem(this.AUTH_KEY) || '{}';
    let auth = JSON.parse(authJson);
    if (key) {
      return auth[key];
    }
    return auth;
  }

  setAuth(data: any) {
    let authJson = localStorage.getItem(this.AUTH_KEY) || '{}';
    let auth = JSON.parse(authJson);
    for(let key in data) {
      if (data.hasOwnProperty(key)) {
        auth[key] = data[key];
      }
    }
    localStorage.setItem(this.AUTH_KEY, JSON.stringify(auth));
  }

  clearAuth() {
    localStorage.setItem(this.AUTH_KEY, '{}');
  }

  getLastVisitUrl() {
    return localStorage.getItem(this.LAST_VISIT_URL_KEY);
  }

  setLastVisitUrl(value: string) {
    localStorage.setItem(this.LAST_VISIT_URL_KEY, value);
  }

  removeLastVisitUrl() {
    localStorage.removeItem(this.LAST_VISIT_URL_KEY);
  }
}
