import { Component, OnInit } from '@angular/core';
import { Dept } from '../model/dept';
import { map } from 'rxjs';


@Component({
  selector: 'app-dept-list',
  templateUrl: './dept-list.component.html',
  styleUrls: ['./dept-list.component.css']
})
export class DeptListComponent implements OnInit {

  deptno:number = 0;
  dname:string = "";
  loc:string = "";


  deptsArray:Dept[] = [
    {Deptno : 10, Dname : "Accounts",  Loc :  "Hyd"} ,
    {Deptno : 20, Dname : "Sales",  Loc :  "Pune"},
    {Deptno : 30, Dname : "Marketing",  Loc :  "Hyd"}
  ];

  constructor() { }

  ngOnInit(): void {
  }
  addDept_click()
  {
      let deptObj:Dept = new Dept();
      deptObj.Deptno = this.deptno;
      deptObj.Dname = this.dname;
      deptObj.Loc = this.loc;

      this.deptsArray.push(deptObj);
  }
  delete_click(Deptno:number)
  {
    let index = this.deptsArray.findIndex(item => item.Deptno == Deptno);
    this.deptsArray.splice(index, 1);
    // pop will remove always last index
    //let index=0;
   // this.deptsArray.pop();

   // anything you click first index will be deleted splice method takes two parameters first index and second is count
    //let index=0;
   // this.deptsArray.splice(index,1);
  }

  select_click(Deptno:number)
  {
    let deptObj:any = this.deptsArray.find(item => item.Deptno == Deptno);
    this.deptno = deptObj.deptno;
    this.dname = deptObj.dname;
    this.loc = deptObj.loc;
  }

  updateDept_click(Deptno:number)
  {
    
    let deptObj:any = this.deptsArray.find(item => item.Deptno == this.deptno);

    

    this.deptsArray.map(deptObj);
    deptObj.deptno = this.deptno 
    deptObj.dname = this.dname ;
    deptObj.loc = this.loc ;
    this.clearForm();
  }

  clearForm(){
    this.deptno = 0;
    this.dname = "";
    this.loc = "";
  }
}
