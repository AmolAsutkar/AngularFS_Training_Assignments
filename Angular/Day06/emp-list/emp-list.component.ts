import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';


@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  empno:any;
  empname:string = "";
  job:string = "";
  sal:any;
  deptno:any;

  emp_arr:any = [];

  constructor(private ds:DataService){
    
  }

  getData(){
    this.ds.getAllEmployees().subscribe((data:any) => {
      this.emp_arr = data;
    })
  }

  saveData(){
    let empObj:any = {};
    empObj.empno = this.empno;
    empObj.empname = this.empname;
    empObj.job = this.job;
    empObj.sal = this.sal;
    empObj.deptno = this.deptno;

    this.ds.addEmployee(empObj).subscribe( (result:any) => {
      alert("New Employee Added!");
      this.getData();
    })

  }

  updateData(){
    let empObj:any = {};
    empObj.empno = this.empno;
    empObj.empname = this.empname;
    empObj.job = this.job;
    empObj.sal = this.sal;
    empObj.deptno = this.deptno;

    this.ds.updateEmployee(empObj).subscribe( (result:any) => {
      alert("Employee Details Updated!");
      this.getData();
    })
  }

  deleteData(){
    this.ds.deleteEmployee(this.empno).subscribe ((result:any)=>{
      alert("Employee Details Deleted!");
      this.getData();
    })
  }

  ngOnInit(): void {
  }



}
