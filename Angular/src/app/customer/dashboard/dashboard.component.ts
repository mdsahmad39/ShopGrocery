import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SellerService } from 'src/app/seller/seller.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  storesList: any;
  imagePath: any;
  constructor(public customerService: CustomerService, public storeService: SellerService, public router: Router) { }

  ngOnInit(): void {
    this.storesList = this.customerService.getAllStores().subscribe((data: any) => { this.storesList = data });
    this.imagePath = '../../assets/images/store_image.png';
  }

  goToStore(store: any): void {
    this.customerService.setSellerProfile(store);
    this.router.navigate(['storeDisplay']);
  }

}
