import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(public httpClient: HttpClient) { }

  notWorkingStoresList(): any {
    return this.httpClient.get('getNotWorkingStores');
  }

  workingStoresList(): any {
    return this.httpClient.get('getWorkingStores');
  }
}
