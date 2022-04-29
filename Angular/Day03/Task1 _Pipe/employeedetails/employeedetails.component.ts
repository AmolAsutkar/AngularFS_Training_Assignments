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

  

  public EmployeeArray:any[]  =
  [
    {empno : 1, empname:"Amol", performancegrade: 5},
    {empno : 2, empname:"asutkar", performancegrade: 6},
    {empno : 3, empname:"shankar", performancegrade: 7},
    {empno : 4, empname:"ajya", performancegrade: 8},
    {empno : 5, empname:"shubham", performancegrade: 9},
  ];
}
