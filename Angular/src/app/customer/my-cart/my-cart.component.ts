import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SellerService } from 'src/app/seller/seller.service';
import { CartService } from '../cart.service';
import { CustomerService } from '../customer.service';
import { ProductByNameComponent } from '../product-by-name/product-by-name.component';

const orderDetList: any = [];

@Component({
  selector: 'app-my-cart',
  templateUrl: './my-cart.component.html',
  styleUrls: ['./my-cart.component.css']
})
export class MyCartComponent implements OnInit {

  cartProductsList: any[] = [];
  totalPrice: number = 0;
  countEdit: number = 0;
  myOrder: any;

  constructor(public customerService: CustomerService, public router: Router, public sellerService: SellerService, public cartService: CartService) {

  }

  refresh(prod: any) {
    if (this.cartProductsList.includes(prod)) {
      this.cartProductsList[this.cartProductsList.indexOf(prod)].listPrice = prod.count * prod.price;
      this.totalPriceFinal();
    }
  }

  totalPriceFinal() {
    this.totalPrice = 0;
    for (var prod of this.cartProductsList) {
      this.totalPrice += prod.count * prod.price;
    }
  }

  ngOnInit(): void {
    this.cartService.getProductsInCart().subscribe((result: any) => { for (var res of result) { this.cartProductsList.push(res) }; });
    console.log(this.cartProductsList);
    for (var prod of this.cartProductsList) {
      this.totalPrice += prod.count * prod.price;
    }
  }

  placeOrder(): any {

    let todayDate = new Date();

    for (var prod of this.cartProductsList) {
      const Quantity = prod.count;
      const orderDetails = { orderDetailsId: '', purchasedQunatity: Quantity, totalPrice: prod.listPrice, orders: '', productId: prod.productId };
      console.log(orderDetails);
      orderDetList.push(JSON.stringify(orderDetails));
      console.log('placeOrder');
      console.log(orderDetList);
    }
    this.myOrder = { ordersId: '', ordersStatus: "Booked", ordersDate: "", storeId: this.customerService.getSellerProfile().storeId, userId: this.customerService.getCustomerProfile().userId, orderDetailsList: orderDetList };

    this.customerService.placeOrder(this.myOrder).subscribe();
    this.router.navigate(['orderPlaced']);
  }
}
