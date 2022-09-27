import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSidenav } from '@angular/material/sidenav';
import { Router, RouterEvent } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { LoginComponent } from '../login/login.component';
import { PatientUserComponent } from '../patient-user/patient-user.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isHomePage!: boolean;

  constructor(private dialog: MatDialog,private router:Router,private observer: BreakpointObserver, private tokenService:TokenStorageService) { }

  ngOnInit(): void {
    this.router.events.subscribe(e => {
      if (e instanceof RouterEvent) {
        this.isHomePage = e.url.split('/').includes('admin');
       }
     });
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
  
  openLoginDialog(): void {
    const dialogRef = this.dialog.open(LoginComponent, {
      // width: '400px',
      // height: '350px'
    });
  }

  openRegisterDialog() {
    const dialogRef = this.dialog.open(PatientUserComponent);
  }
  
  logout(){
    this.tokenService.signOut();
    this.router.navigateByUrl('');
  }

  loggedIn!:boolean;
  islogged():boolean{
    if (this.tokenService.getToken()){
      this.loggedIn=true;
    }
    else{
      this.loggedIn=false;
    }
    return this.loggedIn;
  }
}
