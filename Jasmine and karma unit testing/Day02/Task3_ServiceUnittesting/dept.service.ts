import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DeptService {

  

  deptsArray:any[] = [
    {"deptid":10 , "deptname":"HR"},
    {"deptid":20 , "deptname":"Development"},
    {"deptid":30 , "deptname":"BA"},
    {"deptid":40 , "deptname":"QA"}
  ];

  addDept(deptObj:any){
    this.deptsArray.push(deptObj);
  }

  removeDept(dno:number){
    let index = this.deptsArray.findIndex((item) => item.deptid == dno);
    if(index != -1){
      this.deptsArray.splice(index,1);
    }
    
  }

  constructor() { }
}