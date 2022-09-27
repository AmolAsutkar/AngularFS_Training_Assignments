import { Component, OnInit ,ViewChild} from '@angular/core';
import { AppoinmentBookingService } from 'src/app/services/appoinment-booking.service';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { MatAccordion } from '@angular/material/expansion';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ViewAppoinmentComponent } from '../components/view-appoinment/view-appoinment.component';
import { Viewappoinment } from '../models/Viewappoinment';



@Component({
  selector: 'app-doctors-appoinment',
  templateUrl: './doctors-appoinment.component.html',
  styleUrls: ['./doctors-appoinment.component.scss']
})
export class DoctorsAppoinmentComponent implements OnInit {

  displayedColumns = ["id","firstName", "lastName", "meetingtitle","description","physican", "appoinmentdate","time","actions"];

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  todayDate:Date = new Date();

  
  currentUser : any;
  Viewappoinment: Viewappoinment[] = [];
 
  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private observer: BreakpointObserver,
    public service : AppoinmentBookingService,
    private tokenService : TokenStorageService

    ) { }
  ngOnInit(): void {
    this.currentUser = this.tokenService.getUser().id;
    console.log(this.currentUser +" current user id")


    this.service.getappoinment().subscribe((data: Viewappoinment[])=>{
      console.log(data);
      this.Viewappoinment=data;
           })

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
