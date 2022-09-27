import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatSidenav } from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

interface Role {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-create-hospital-user',
  templateUrl: './create-hospital-user.component.html',
  styleUrls: ['./create-hospital-user.component.scss']
})
export class CreateHospitalUserComponent implements OnInit {

  myGroup!: FormGroup;
  constructor(
    public dataService: UserService,
    private router: Router,
    private observer: BreakpointObserver
  ) { }
  
  ngOnInit(): void {
    this.myGroup = new FormGroup({
      title: new FormControl('', [Validators.required]),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dateOfBirth:new FormControl(''),
      role:new FormControl('', Validators.required),
      mobileNumber:new FormControl('', Validators.required),
      status:new FormControl('', Validators.required),
      email:new FormControl('',Validators.required),
      employeeID:new FormControl('',Validators.required),
    });
  }
   
  get f(){
    return this.myGroup.controls;
  }
    
  submit(){
    console.log(this.myGroup.value);
    this.dataService.addUser(this.myGroup.value).subscribe(res => {
         console.log('User created successfully!');
         this.router.navigateByUrl('getPhysician');
    })
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
