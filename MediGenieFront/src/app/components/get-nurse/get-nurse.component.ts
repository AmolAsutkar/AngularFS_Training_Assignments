import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSidenav } from '@angular/material/sidenav';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-get-nurse',
  templateUrl: './get-nurse.component.html',
  styleUrls: ['./get-nurse.component.scss']
})
export class GetNurseComponent implements OnInit {

  
  user!: User[];
  firstName: any;

  @ViewChild(MatSort, {static: true}) sort!:MatSort;
  
  @ViewChild(MatPaginator) paginator!:MatPaginator;

  displayedColumns = ["id", "firstName","createdAt","status", "actions"];
  dataSource:any;
  constructor(public dataService: UserService,private router:Router,private observer: BreakpointObserver) { }
  ngOnInit() {

    this.dataService.getPatient().subscribe((data: User[])=>{
      console.log(data);
      this.user = data;
      this.dataSource=new MatTableDataSource(this.user);
      
      this.dataSource.paginator=this.paginator;
      this.dataSource.sort=this.sort;
      
    })  

    
  }

  ngAfterInit(){

  }

  changeStatus(id:number){
    this.dataService.changeStatus(id).subscribe((data:any)=>{
      console.log(data);
      this.user = data;
      this.router.navigateByUrl('PatientUser');
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

    applyFilter(event:Event){
      const filterValue =(event.target as HTMLInputElement).value;
      this.dataSource.filter = filterValue.trim().toLowerCase();

      if(this.dataSource.paginator){
        this.dataSource.paginator.firstPage();
      }
    }

    
  
}

