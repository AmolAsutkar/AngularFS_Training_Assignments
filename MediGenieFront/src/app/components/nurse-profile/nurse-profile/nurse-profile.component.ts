import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

export interface Role{
  roleId:number;
  role:string;
}

@Component({
  selector: 'app-nurse-profile',
  templateUrl: './nurse-profile.component.html',
  styleUrls: ['./nurse-profile.component.scss']
})
export class NurseProfileComponent implements OnInit {

  currentUser: any;
  roles: Role[] = [];
  role!: string;


  constructor(private tokenStorageService: TokenStorageService, private router:Router,private observer: BreakpointObserver) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
    this.roles = this.tokenStorageService.getUser().roles;
    this.role = this.roles[0].role;
    }

    @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  
  
  ngAfterViewInit() {
    this.observer
      .observe(['(max-width: 800px)'])
      .subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });
    }

}
