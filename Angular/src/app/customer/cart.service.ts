import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CartService {

  private productsInCart = new BehaviorSubject<Array<any>>([]);
  productsCart: any[] = [];

  constructor(public httpClient: HttpClient) { }

  addProductToCart(product: any) {
    //this.productsCart[this.productsCart.indexOf(product)].count += 1;
    //} else {
    //product['count'] = 1;
    const exists = this.productsCart.some((i) => {
      if (i.productId === product.productId) {
        return true;
      }
      else {
        return false;
      }
    });
    console.log(exists);
    if (!exists) {
      product['count'] = 1;
      product['listPrice'] = 1;
      const currentValue = this.productsInCart.value;
      const updatedValue = [...currentValue, product];
      this.productsInCart.next(updatedValue);
      this.productsCart.push(product);
    } else {
      for (let i = 0; i < this.productsCart.length; i++)
        if (this.productsInCart.value[i]["productId"] == product["productId"]) {
          this.productsInCart.value[i]["count"] += 1;
          this.productsInCart.value[i]['listPrice'] += 1;
        }
    }
  }

  setProductInCart() {
    //this.productsInCart.next(this.productsCart);
  }

  getProductsInCart(): any {
    return this.productsInCart.asObservable();
  }

  placeOrder(orders: any): any {
    return this.httpClient.post('registerOrder', orders);
  }
}
