import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { map, take } from 'rxjs/operators';
import { SellerService } from './seller.service';

@Injectable({
  providedIn: 'root'
})
export class SellerAuthGuard implements CanActivate {
  constructor(public sellerService: SellerService, public router: Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.sellerService.isSellerLoggedIn.pipe(
      take(1),
      map((isSellerLoggedIn: boolean) => {
        if (!isSellerLoggedIn) {
          this.router.navigate(['/loginSeller']);
          return false;
        }
        return true;
      })
    );
  }

}
