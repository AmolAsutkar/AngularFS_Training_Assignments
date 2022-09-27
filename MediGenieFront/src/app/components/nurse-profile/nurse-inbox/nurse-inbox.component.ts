import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
// import { InboxService } from 'src/app/services/inbox.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-nurse-inbox',
  templateUrl: './nurse-inbox.component.html',
  styleUrls: ['./nurse-inbox.component.scss']
})
export class NurseInboxComponent implements OnInit {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
  description:any;
  constructor(private observer: BreakpointObserver,private router:Router,private userService:UserService,private dialog: MatDialog){}
  
  displayedColumns = ["firstName"];

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

    ngOnInit(): void {
      this.userService.getPhysician().subscribe((data: User[])=>{
        console.log(data);
        this.user = data;
      }) 
    }

    user: User[] = [];

    getNurse(){
      this.userService.getPhysician().subscribe((data: User[])=>{
        console.log(data);
        this.user = data;
      }) 

    }
    
    form = new FormGroup({
      firstName: new FormControl(null),
      lastName: new FormControl(null),
      message: new FormControl(null),
    });
    

    saveMessage(){
      alert("message sent")
    }
  
   
   

}
