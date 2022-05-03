import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employeedetails',
  templateUrl: './employeedetails.component.html',
  styleUrls: ['./employeedetails.component.css']
})
export class EmployeedetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  employeeArray:Emps[] =[
    {empnumber :1, empname:"smith",empjob:"Admin", empsal:1000,empdept:"electronics"},
    {empnumber :2, empname:"ram",empjob:"Manager", empsal:2000,empdept:"computer"},
    {empnumber :3, empname:"ramesh",empjob:"hr", empsal:5000,empdept:"IT"}
  ];
}
class Emps{
  empnumber:number=0;
  empname:string="";
  empjob:string="";
  empsal:number=0;
  empdept:string="";
}