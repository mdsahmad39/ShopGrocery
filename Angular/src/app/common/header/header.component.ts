import { Component, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CustomerService } from 'src/app/customer/customer.service';
import { SellerService } from 'src/app/seller/seller.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isSellerLoggedIn$: Observable<boolean>;
  isCustomerLoggedIn$: Observable<boolean>;

  constructor(public sellerService: SellerService, public customerService: CustomerService) {
    this.isSellerLoggedIn$ = this.sellerService.isSellerLoggedIn;
    this.isCustomerLoggedIn$ = this.customerService.isCustomerLoggedIn;
  }

  ngOnInit(): void {
  }

  onCustomerLogout(): any {
    this.customerService.logoutCustomer();
  }

  onSellerLogout(): any {
    this.sellerService.logoutSeller();
  }

}
