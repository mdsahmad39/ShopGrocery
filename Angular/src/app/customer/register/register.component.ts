import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from 'src/app/common/common.service';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  countriesList: any;
  customer: any;

  constructor(public customerService: CustomerService, public commonService: CommonService, public router: Router) { }

  ngOnInit(): void {
    this.commonService.getAllCountries().subscribe((data: any) => this.countriesList = data);
  }

  submitRegisterForm(registerForm: any): void {
    console.log(registerForm);
    this.customer = {
      userId: '',
      firstName: registerForm.firstName,
      lastName: registerForm.lastName,
      gender: registerForm.gender,
      emailId: registerForm.emailId,
      phoneNumber: registerForm.phoneNumber,
      loginId: registerForm.loginId,
      password: registerForm.password,
      address: { addressId: '', houseNo: registerForm.houseNo, street: registerForm.street, city: registerForm.city, pincode: registerForm.pincode, state: registerForm.state, country: registerForm.country }
    };
    this.customerService.register(this.customer).subscribe((result: any) => console.log(result));
    this.router.navigate(['']);
  }

}
