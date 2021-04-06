import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { SellerService } from '../seller/seller.service';
import { CartService } from './cart.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private customerLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  customer: any;
  seller: any;
  productsList: any;
  productByName: any;

  constructor(public httpClient: HttpClient, public router: Router, public sellerService: SellerService,public cartService:CartService) {
  }

  get isCustomerLoggedIn() {
    return this.customerLoggedIn.asObservable();
  }

  async loginCustomer(loginForm: any) {
    await this.httpClient.get('loginCustomer/' + loginForm.loginId + '/' + loginForm.password).toPromise().then((data: any) => { this.customer = data; });
    if (this.customer) {
      this.customerLoggedIn.next(true);
      this.router.navigate(['dashboardCustomer']);
    }
  }

  logoutCustomer() {
    this.customerLoggedIn.next(false);
    this.router.navigate(['']);
  }

  getCustomerId(): any {
    return this.customer.userId;
  }

  getCustomerProfile(): any {
    return this.customer;
  }

  setSellerProfile(seller: any) {
    this.seller = seller;
  }

  getSellerProfile() {
    return this.seller;
  }

  getSellerId() {
    return this.seller.storeId;
  }

  setProductByName(product: any) {
    this.productByName = product;
  }

  gettingProductByName(): any {
    return this.productByName;
  }

  register(registerForm: any) {
    return this.httpClient.post('registerCustomer', registerForm);
  }

  getAllStores(): any {
    return this.httpClient.get('getAllStores');
  }

  updateCustomer(customer: any): any {
    return this.httpClient.post('updateCustomer', customer);
  }

  getAllProducts(): any {
    this.sellerService.getAllproducts(this.seller.storeId).subscribe((data: any) => { this.productsList = data; });
    console.log(this.productsList);
  }

  getProductByName(productName: any): any {
    return this.httpClient.get('getProductByName/' + productName);
  }

  placeOrder(myOrder: any): any {
    return this.httpClient.post('/registerOrder',myOrder);
  }
}
