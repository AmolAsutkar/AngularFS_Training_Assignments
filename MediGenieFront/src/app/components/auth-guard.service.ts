import { state } from '@angular/animations';
import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';
import { TokenStorageService } from '../services/token-storage.service';
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  loggedIn!: boolean;
  roles: string[] = [];
  role!:string;
  constructor(private userService: UserService, private router: Router, private tokenService:TokenStorageService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (this.tokenService.getToken()){
      
      this.loggedIn=true;
    }
    else{
      this.loggedIn=false;
      this.router.navigateByUrl('')
    }
    return this.loggedIn;
  }
}
