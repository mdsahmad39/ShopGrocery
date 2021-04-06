import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';

declare var jQuery: any;

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  customer: any;
  editCustomer: any;
  constructor(public customerService: CustomerService) {
    this.editCustomer = { userId: '', firstName: '', lastName: '', gender: '', emailId: '', phoneNumber: '', loginId: '', password: '', address: { addressId: '', houseNo: '', street: '', city: '', pincode: '', state: '', country: '' }, orders: '' }
  }

  ngOnInit(): void {
    this.customer = this.customerService.getCustomerProfile();
  }

  showEditPopUp(customer: any) {
    this.editCustomer = customer;
    jQuery('#editCustomer').modal('show');
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.editCustomer).subscribe();
  }

}
