import { Component, OnInit } from '@angular/core';
import { DataserviceService } from '../dataservice.service';


@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {

  constructor( private  serviceObj:DataserviceService){}

  ngOnInit(): void {
    this.getEmployeearrayfromService();
  }


  empno:number=0;
  empname:string="";
  empsal:number=0;
  empjob:string="";
  empdept:string="";
  empscomponentArray:any[]=[];

  getEmployeearrayfromService() {
    this.empscomponentArray = this.serviceObj.getEmployeearraydata();
  }

  addEmployee_click(){
   
    this.serviceObj.addEmployee(
      this.empno,
      this.empname,
      this.empsal,
      this.empjob,
      this.empdept);
  }

  removeEmployee_click(){
    
    this.serviceObj.removeEmployee(this.empno);
  }
}
