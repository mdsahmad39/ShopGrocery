import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { CustomerService } from './customer.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerAuthGuard implements CanActivate {
  constructor(public customerService: CustomerService, public router: Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.customerService.isCustomerLoggedIn.pipe(
      take(1),
      map((isCustomerLoggedIn: boolean) => {
        if (!isCustomerLoggedIn) {
          this.router.navigate(['/loginCustomer']);
          return false;
        }
        return true;
      })
    );
  }

}
