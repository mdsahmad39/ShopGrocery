import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(public httpClient: HttpClient) { }

  getAllCountries(): any {
    return this.httpClient.get('https://restcountries.eu/rest/v2/all');
  }

  getStoresCount(): any {
    return this.httpClient.get('getStoresCount');
  }
}
