import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common/common.service';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class SellerRegisterComponent implements OnInit {

  countriesList: any;
  store: any;

  constructor(public sellerService: SellerService, public commonService: CommonService, public router: Router) { }

  ngOnInit(): void {
    this.commonService.getAllCountries().subscribe((data: any) => this.countriesList = data);
  }

  submitRegisterForm(registerForm: any): void {
    console.log(registerForm);
    this.store = {
      storeId: '',
      storeName: registerForm.storeName,
      sellerName: registerForm.sellerName,
      phoneNumber: registerForm.phoneNumber,
      emailId: registerForm.emailId,
      fileName: '',
      loginId: registerForm.loginId,
      password: registerForm.password,
      address: { addressId: '', houseNo: registerForm.houseNo, street: registerForm.street, city: registerForm.city, pincode: registerForm.pincode, state: registerForm.state, country: registerForm.country }
    };
    this.sellerService.register(this.store).subscribe((result: any) => console.log(result));
    this.router.navigate(['loginSeller']);
  }


}
