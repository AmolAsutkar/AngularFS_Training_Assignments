import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-emps-list',
  templateUrl: './emps-list.component.html',
  styleUrls: ['./emps-list.component.css']
})
export class EmpsListComponent implements OnInit, OnChanges {

  @Input()
  sortValue:string="";

  sorted_emp_list:Employee[] = [];

  emp_list:Employee[] = [
    {eid:201 , ename:"amol" , ejob:"mechanics" , esalary:9000 , edeptno:20},
    {eid:101 , ename:"asutkar" , ejob:"plumber" , esalary:1000 , edeptno:10},
    {eid:105 , ename:"piyush" , ejob:"engineer" , esalary:2000 , edeptno:10},
    {eid:209 , ename:"golu" , ejob:"labour" , esalary:5000 , edeptno:10},
    {eid:301 , ename:"raju" , ejob:"farmer" , esalary:1000 , edeptno:30},
    {eid:300 , ename:"shankar" , ejob:"teacher" , esalary:1000 , edeptno:30},
    {eid:305 , ename:"shivani" , ejob:"shopkeeper" , esalary:1000 , edeptno:30}

  ]; 

  constructor() { }
  ngOnChanges(): void {
    if(this.sortValue == ""){
      this.sorted_emp_list = this.emp_list;
    }
    if(this.sortValue == "1"){
      this.sorted_emp_list = this.emp_list.sort((e1,e2) => e1.eid - e2.eid);
    }
    if(this.sortValue == "2"){
      this.sorted_emp_list = this.emp_list.sort((e1,e2) => e1.ename > e2.ename ? 1 : -1);
    }
    if(this.sortValue == "3"){
      this.sorted_emp_list = this.emp_list.sort((e1,e2) => e1.ejob > e2.ejob ? 1 : -1);
    }
    if(this.sortValue == "4"){
      this.sorted_emp_list = this.emp_list.sort((e1,e2) => e1.esalary - e2.esalary);
    }
    if(this.sortValue == "5"){
      this.sorted_emp_list = this.emp_list.sort((e1,e2) => e1.edeptno - e2.edeptno);
    }
  }

  ngOnInit(): void {
    
  }

}

class Employee{
  eid:number = 0;
  ename:string = "";
  ejob:string = "";
  esalary:number = 0;
  edeptno:number = 0;
}