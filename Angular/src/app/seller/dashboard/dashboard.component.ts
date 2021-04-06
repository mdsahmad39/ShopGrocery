import { Component, OnInit } from '@angular/core';
import { SellerService } from '../seller.service';
import { Subscription, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

declare var jQuery: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class SellerDashboardComponent implements OnInit {

  addProduct: any;
  editProduct: any;
  deleteProduct: any;
  productsList: any;
  imagePathList: any;
  store: any;
  productName: any;
  subscription: Subscription;
  imageToUpload:any;
  fileName:any;
  reader:any;
  imageurl:any;
  show:any;

  constructor(public sellerService: SellerService) {

    this.editProduct = { productId: '', productName: '', category: '', brand: '', description: '', availableQuantity: '', price: '',fileName:'', createdDate: '', expiryDate: '', store: '', orderDetails: '' };

    this.store = this.sellerService.getSellerProfile();

    this.addProduct = { productName: '', category: '', brand: '', description: '', availableQuantity: '', price: '',fileName:'', createdDate: '', expiryDate: '', store: this.store };

    this.deleteProduct = { productName: '', category: '', brand: '', description: '', availableQuantity: '', price: '',fileName:'', createdDate: '', expiryDate: '', store: this.store };

    this.subscription = timer(0, 1000).pipe(
      switchMap(() => this.sellerService.getAllproducts(this.sellerService.getSellerId()))
    ).subscribe(data => this.productsList = data);

    this.imagePathList = '../../assets/images/eggs.jpg';
    this.productName = '';
    this.imageurl='';
    this.show=false;
  }

  ngOnInit(): void {
  }

  addProductToDB(): void {
    jQuery('#addProductModel').modal('show');
  }

  sendAddProductQuery(): void {
    this.sellerService.addProduct(this.addProduct).subscribe();
  }

  showEditPopup(product: any): void {
    this.editProduct = product;
    jQuery('#productModel').modal('show');
  }

  updateProduct(): void {
    this.sellerService.updateProduct(this.editProduct).subscribe();
  }

  ngOnDestroy() {
   this.subscription.unsubscribe();
  }

  deleteProductConfirmation(product: any) {
    this.deleteProduct = product;
    jQuery('#deleteProductModel').modal('show');
  }

  delete(product: any) {
    this.sellerService.deleteProduct(product).subscribe((data: any) => {
      const i = this.productsList.findIndex((data: any) => { return data.productId === product.productId; })
      this.productsList.splice(i, 1);
    });
  }

  getProductByName(): any {

  }

  onSelectFile(event:any)
  {
    this.imageToUpload=event.target.files[0];
    this.fileName=this.imageToUpload.name;
    this.reader = new FileReader();
    this.reader.onload = (e:any)=>{this.imageurl=e.target.result,this.show=true;};
    this.reader.readAsDataURL(this.imageToUpload);
  }

  onUpload()
  {
    this.editProduct.fileName=this.fileName;
    //this.sellerService.postFile(imageForm,this.imageToUpload).subscribe();
    this.sellerService.updateProduct(this.editProduct).subscribe();
    //this.sellerService.postFile(imageForm,this.imageToUpload).subscribe();
    this.sellerService.postProductFile(this.imageToUpload).subscribe((data:any) => { console.log('done')});
  }

  onAddUpload()
  {
    this.addProduct.fileName=this.fileName;
    this.sellerService.postProductFile(this.imageToUpload).subscribe((data:any) => { console.log('done')});
  }

}
