import { Component, OnInit } from '@angular/core';
import { SellerService } from '../seller.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class SellerProfileComponent implements OnInit {

  seller: any;
  imageurl:any;
  show:any;
  reader:any
  imageToUpload:any;
  fileName:any;

  constructor(public sellerService: SellerService) { 
    this.show=false;
    this.imageurl='';
  }

  ngOnInit(): void {
    this.seller = this.sellerService.getSellerProfile();
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
    this.seller.fileName=this.fileName;
    this.sellerService.updateSellerProfile(this.seller).subscribe((data:any)=>console.log(data));
    //this.sellerService.postFile(imageForm,this.imageToUpload).subscribe();
    this.sellerService.postFile(this.imageToUpload).subscribe((data:any)=>console.log(data));
  }
}
