import { Injectable } from '@angular/core';
import { Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';

@Injectable({
  providedIn: 'root'
})
export class PatientGuardService {
  loggedIn!:boolean;
  roles: string[] = [];
  role!:string;
  constructor(private userService: UserService, private router: Router, private tokenService:TokenStorageService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    this.roles = this.tokenService.getUser().roles;
    if (this.tokenService.getToken()&& this.roles==["ROLE_PATIENT"]){
      
      this.loggedIn=true;
    }
    else{
      this.loggedIn=false;
      this.router.navigateByUrl('')
    }
    return this.loggedIn;
  }
}
