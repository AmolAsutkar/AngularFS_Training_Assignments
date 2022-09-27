import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import {MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA} from "@angular/material/dialog";
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { User } from 'src/app/models/user';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { InboxComponent } from '../inbox/inbox.component';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-physician-inbox',
  templateUrl: './physician-inbox.component.html',
  styleUrls: ['./physician-inbox.component.scss']
})
export class PhysicianInboxComponent {
  
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
      this.userService.getNurse().subscribe((data: User[])=>{
        console.log(data);
        this.user = data;
      }) 
    }

    user: User[] = [];

    getNurse(){
      this.userService.getNurse().subscribe((data: User[])=>{
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
