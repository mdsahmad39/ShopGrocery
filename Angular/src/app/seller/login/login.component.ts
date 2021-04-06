import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class SellerLoginComponent implements OnInit {

  seller: any;
  constructor(public sellerService: SellerService, public router: Router) {
  }

  ngOnInit() {
  }

  submitLoginForm(loginForm: any) {
    console.log(loginForm);
    if (loginForm.loginId === 'admin' && loginForm.password === 'admin') {
      this.router.navigate(['adminDashboard']);
    } else {
      this.sellerService.loginSeller(loginForm);
    }
  }

}
