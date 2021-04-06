import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-product-by-name',
  templateUrl: './product-by-name.component.html',
  styleUrls: ['./product-by-name.component.css']
})
export class ProductByNameComponent implements OnInit {

  product: any;
  store: any;

  constructor(public customerService: CustomerService) { }

  ngOnInit(): void {
    this.product = this.customerService.gettingProductByName();
    this.store = this.customerService.getSellerProfile();
  }

}
