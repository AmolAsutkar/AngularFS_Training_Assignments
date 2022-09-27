import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nurse-appointments',
  templateUrl: './nurse-appointments.component.html',
  styleUrls: ['./nurse-appointments.component.scss']
})
export class NurseAppointmentsComponent {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  displayedColumns = ["id", "patientName","meetingTitle","Date","Time","physicianName" ,"actions"];
  
  constructor(private observer: BreakpointObserver,private router:Router) {}
  
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

    add(){

    }
}
