import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller/seller.service';
import { CartService } from '../cart.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-store-display',
  templateUrl: './store-display.component.html',
  styleUrls: ['./store-display.component.css']
})
export class StoreDisplayComponent implements OnInit {

  store: any;
  productsList: any;
  imagePath: any;
  productName: any;
  productsCart: any[] = [];

  constructor(public customerService: CustomerService, public sellerService: SellerService, public router: Router, public cartService: CartService) {
    this.productName = "";
    this.cartService.getProductsInCart().subscribe((result: any) => { for (var res of result) { this.productsCart.push(res) }; });
  }

  ngOnInit(): void {
    this.store = this.customerService.getSellerProfile();
    this.sellerService.getAllproducts(this.store.storeId).subscribe((data: any) => {
      this.productsList = data;
    });
    //this.imagePath = '../../assets/images/eggs.jpg';
  }

  addToCart(product: any) {
    this.cartService.addProductToCart(product);
  }

  checkOut() {
    this.router.navigate(['myCart']);
  }

  searchByName(): any {
    this.customerService.getProductByName(this.productName).subscribe((data: any) => this.customerService.setProductByName(data));
    this.router.navigate(['productByName']);
  }

}
