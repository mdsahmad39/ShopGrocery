import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer: any;
  constructor(public customerService: CustomerService, public router: Router) { }

  ngOnInit(): void {
  }

  async submitLoginForm(loginForm: any) {
    if (loginForm.loginId === 'admin' && loginForm.password === 'admin') {
      this.router.navigate(['adminDashboard']);
    } else {
      this.customerService.loginCustomer(loginForm);
    }
  }

}
