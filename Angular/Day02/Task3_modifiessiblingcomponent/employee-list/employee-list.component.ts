import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input()
  sortvalue:string="";

  sorted_emp_list:Employee[]=[];

  emparray: Employee[]=[
    { empsnumber: 6, empsname: "amol", empssalary: 9000, empsjobtitle: "developer", empsdepartment: "software" },
    { empsnumber: 3, empsname: "bhale", empssalary: 7000, empsjobtitle: "juniortester", empsdepartment: "it" },
    { empsnumber: 9, empsname: "chetan", empssalary: 6000, empsjobtitle: "shop", empsdepartment: "business" },
    { empsnumber: 5, empsname: "dhoni", empssalary: 4000, empsjobtitle: "mechanical", empsdepartment: "svss" },

  ];

  ngOnChanges(): void {
    if(this.sortvalue == ''){
      this.sorted_emp_list = this.emparray;
    }
    if(this.sortvalue == 'a'){
      this.sorted_emp_list = this.emparray.sort((e1,e2) => e1.empsnumber - e2.empsnumber);
    }
    if(this.sortvalue == "b"){
      this.sorted_emp_list = this.emparray.sort((e1,e2) => e1.empsname > e2.empsname ? 1 : -1);
    }
    if(this.sortvalue == "c"){
      this.sorted_emp_list = this.emparray.sort((e1,e2) => e1.empssalary - e2.empssalary);
    }
    if(this.sortvalue == "d"){
      this.sorted_emp_list = this.emparray.sort((e1,e2) => e1.empsjobtitle > e2.empsjobtitle ? 1: -1);
    }
    if(this.sortvalue == "e"){
      this.sorted_emp_list = this.emparray.sort((e1,e2) => e1.empsdepartment > e2.empsdepartment ? 1: -1);
    }
  }
}

class Employee{
  public empsnumber:number=0;
  public empsname:string="";
   public empssalary:number=0;
   public empsjobtitle:string="";
  public empsdepartment:string="";
 }