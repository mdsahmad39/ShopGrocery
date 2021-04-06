import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  notWorkingStoresList: any;
  workingStoresList: any;
  constructor(public adminService: AdminService) {

  }

  ngOnInit(): void {
    this.adminService.notWorkingStoresList().subscribe((data: any) => this.notWorkingStoresList = data);
    this.adminService.workingStoresList().subscribe((data: any) => this.workingStoresList = data);
  }

}
