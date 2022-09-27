import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';

@Component({
  selector: 'app-physician-pending',
  templateUrl: './physician-pending.component.html',
  styleUrls: ['./physician-pending.component.scss']
})
export class PhysicianPendingComponent {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  displayedColumns = ["id", "firstName","meetingTitle","Date","Time", "action"];
  
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


}
