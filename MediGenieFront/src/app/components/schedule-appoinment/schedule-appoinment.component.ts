import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { booking } from 'src/app/models/booking';
import { User } from 'src/app/models/user';
//import { AppoinmentBookingService } from '../services/appoinment-booking.service';
import { Viewappoinment } from 'src/app/models/Viewappoinment';
import { AppoinmentBookingService } from 'src/app/services/appoinment-booking.service';
//import { User } from '../models/User';
import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { MatAccordion } from '@angular/material/expansion';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { userforphysicianname } from 'src/app/models/userforphysicianname';

@Component({
  selector: 'app-schedule-appoinment',
  templateUrl: './schedule-appoinment.component.html',
  styleUrls: ['./schedule-appoinment.component.scss']
})
export class ScheduleAppoinmentComponent implements OnInit {
  
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;


  user: User[] = [];
  userforphysicianname: userforphysicianname[]=[];
  userForm!: FormGroup
  title = 'formvalidation'
  submitted = false
  message:any

  formGroup!: FormGroup;
  titleAlert: string = 'This field is required';
  post: any = '';
  form: FormGroup = new FormGroup({});
  currentUser : any;
  currentusername : any;
  currentphysicianname : any;
  currentuserrole : any;
  booking:booking =new booking();

  constructor(private formBuilder: FormBuilder,
     private router: Router,
     private observer: BreakpointObserver,
     public service : AppoinmentBookingService,
     private tokenService : TokenStorageService

     ) { }

  ngOnInit() {
   // this.createForm();
   this.currentUser = this.tokenService.getUser().id;
   //this.currentusername=this.tokenService.getUser().firstName;
   //this.currentuserrole=this.tokenService.getUser().role;
   
   this.currentuserrole=this.tokenService.getUser().roles[0].role
   
   
 console.log(this.currentUser +" current user id")
 //console.log(this.currentusername +" current user currentusername")
 console.log(this.currentuserrole +" current user currentuserrole")


    this.service.getPhysician().subscribe((data: User[])=>{
      console.log(data);
      this.user = data;
      
  })
    this.form = this.formBuilder.group({
     
      meetingtitle: ['', Validators.required],
      description: ['', Validators.required],
      physicianname:[this.currentphysicianname],
      appoinmentDate: [null, [Validators.required]],
      time: [null, [Validators.required]],
      reason: ['', [Validators.required]],
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      userId: [this.currentUser],
      physicianId:['',Validators.required]



    });

    

  }


  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
   // this.router.navigateByUrl("user-profile")
  }

  

  bookAppoinment() {

    
    console.log(this.form.value);
    this.service.book(this.form.value).subscribe(res =>{
      console.log('Booking created successfully!');

this.router.navigate(['/viewappoinment']);
    })
    
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


  @ViewChild(MatAccordion)
  accordion!: MatAccordion;
  panelOpenState = false;

}
