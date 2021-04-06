import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerService {
 
  private sellerLoggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  sellerId: any;
  seller: any;
  newFileName:any;
  message:any

  constructor(public httpClient: HttpClient, public router: Router) {
    this.sellerId = 0;
  }

  get isSellerLoggedIn() {
    return this.sellerLoggedIn.asObservable();
  }

  async loginSeller(loginForm: any) {
    await this.httpClient.get('/loginSeller/' + loginForm.loginId + '/' + loginForm.password).toPromise().then((data: any) => { this.seller = data; });
    if (this.seller) {
      this.sellerLoggedIn.next(true);
      this.router.navigate(['dashboardSeller']);
    }
  }

  logoutSeller(): any {
    this.sellerLoggedIn.next(false);
    this.router.navigate(['']);
  }


  getSellerId(): any {
    return this.seller.storeId;
  }

  getSellerProfile(): any {
    return this.seller;
  }

  register(registerForm: any) {
    return this.httpClient.post('registerStore', registerForm);
  }

  getAllproducts(storeId: any) {
    return this.httpClient.get('getProductByStore/' + storeId);
  }

  updateProduct(product: any): any {
    return this.httpClient.post('updateProduct/', product);
  }

  addProduct(product: any): any {
    return this.httpClient.post('/addProduct', product);
  }

  deleteProduct(product: any): any {
    return this.httpClient.post('deleteProduct/', product);
  }

  updateSellerProfile(seller: any) {
    return this.httpClient.post('/updateSeller',seller);
  }

  postFile(fileToUpload: File): any{
    // goes to rest api employee controller
    const endpoint = '/uploadStoreImage';
    const formData: FormData = new FormData();
    formData.append('Image', fileToUpload, fileToUpload.name);
    return this.httpClient.post(endpoint,formData,{ observe: 'response' }).subscribe((response:any) => {
    if (response.status === 200) 
    {
      this.message = 'Image uploaded successfully';
    } 
    else 
    {
      this.message = 'Image not uploaded successfully';
    }
    });
  }

  postProductFile(fileToUpload: File): any {
    // goes to rest api employee controller
    const endpoint = '/uploadProductImage';
    const formData: FormData = new FormData();
    formData.append('Image', fileToUpload, fileToUpload.name);
    return this.httpClient.post(endpoint, formData,{ observe: 'response' }).subscribe((response:any) => {
      if (response.status === 200) 
      {
        this.message = 'Image uploaded successfully';
      } 
      else 
      {
        this.message = 'Image not uploaded successfully';
      }
      });
  }

}
