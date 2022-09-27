import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatAccordion } from '@angular/material/expansion';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visit-details',
  templateUrl: './visit-details.component.html',
  styleUrls: ['./visit-details.component.scss']
})
export class VisitDetailsComponent  {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  displayedColumns = ["id", "firstName","createdAt","Date","Time", "status"];
  
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


  @ViewChild(MatAccordion)
  accordion!: MatAccordion;
  panelOpenState = false;
}
