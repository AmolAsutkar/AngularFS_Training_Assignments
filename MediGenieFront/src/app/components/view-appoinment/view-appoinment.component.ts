//import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Viewappoinment } from 'src/app/models/Viewappoinment';
import { AppoinmentBookingService } from 'src/app/services/appoinment-booking.service';
//import { AppoinmentBookingService } from '../appoinment-booking.service';
import { MatSidenav } from '@angular/material/sidenav';
import { Component, OnInit, ViewChild } from '@angular/core';
import { BreakpointObserver } from '@angular/cdk/layout';
import { TokenStorageService } from 'src/app/services/token-storage.service';


@Component({
  selector: 'app-view-appoinment',
  templateUrl: './view-appoinment.component.html',
  styleUrls: ['./view-appoinment.component.scss']
})
export class ViewAppoinmentComponent implements OnInit {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  todayDate:Date = new Date();
  currentuserrole : any;

  Viewappoinment: Viewappoinment[] = [];

  //displayedColumns = ["id","firstName", "lastName", "meetingtitle","description","physican", "appoinmentdate","time"];
  displayedColumns = ["id","firstName", "lastName", "meetingtitle","description","physican", "appoinmentdate","time","actions"];
  //displayedColumns = ["id","firstName", "lastName", "meetingtitle","description", "appoinmentdate","time"];

  
  constructor(public service : AppoinmentBookingService,private observer: BreakpointObserver,
    private tokenService : TokenStorageService,
    private router:Router) { }
  ngOnInit() {
    console.log(this.todayDate+"todays date is")
      this.service.getappoinments().subscribe((data: Viewappoinment[])=>{
  console.log(data);
  this.Viewappoinment=data;
       })

       this.currentuserrole=this.tokenService.getUser().roles[0].role
       console.log(this.currentuserrole +" current user currentuserrole in view component")

      /* post(url, data) {
        let headers = new Headers();
        this.createAuthorizationHeader(headers);
        return this.http.post(url, data, {
          headers: headers
        });
      }
    */
    }

    DeleteAppoinment(){
      alert("deleted")
    }
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
