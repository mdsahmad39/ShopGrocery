import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { CommonService } from '../common.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  storesCount: any;
  constructor(private toastr: ToastrService, public commonService: CommonService) { }

  ngOnInit(): void {
    this.commonService.getStoresCount().subscribe((data: any) => this.storesCount = data);
  }

  showToaster() {
    this.toastr.info("Hello, I'm the toastr message.")
  }

}
