import { Component, Input, OnInit } from '@angular/core';
import { Emps } from '../Model/Emps';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  @Input() 
  employeefilter:string = "";
  empArrcopy:Emps[] = [];

  constructor() { }
  
  employeeArray:Emps[] =[
    {empnumber :1, empname:"smith",empjob:"Admin", empsal:1000,empdept:"electronics"},
    {empnumber :2, empname:"ram",empjob:"Manager", empsal:2000,empdept:"computer"},
    {empnumber :3, empname:"ramesh",empjob:"hr", empsal:5000,empdept:"IT"}
  ];
  ngOnInit(): void {
  }

  ngOnChanges(){
    if(this.employeefilter == "sortbyId"){
      this.empArrcopy = this.employeeArray.sort(function(a,b){return a.empnumber < b.empnumber ? 1 :-1});
      this.employeeArray = this.empArrcopy;
    }
}
}