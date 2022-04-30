import { Injectable } from '@angular/core';
import { NumberValueAccessor } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  emparray: Employee[]=[
    { empsnumber: 6589, empsname: "subham", empssalary: 98900, empsjobtitle: "developer", empsdepartment: "software" },
    { empsnumber: 6580, empsname: "shankar", empssalary: 97900, empsjobtitle: "tester", empsdepartment: "IT" },
    { empsnumber: 6584, empsname: "jatade", empssalary: 78900, empsjobtitle: "dataanalyst", empsdepartment: "DS" },

  ];
  constructor() { }
  
  public getEmployeearraydata(): any[]{
    return this.emparray;
  }
  addEmployee(empno:number,empname:string,empsal:number,empjob:string,empdept:string)
    {
     let empObj:Employee = new Employee();

    
    
    empObj.empsnumber=empno;
    empObj.empsname=empname;
    empObj.empssalary=empsal;
    empObj.empsjobtitle=empjob;
    empObj.empsdepartment=empdept;
   
this.emparray.push(empObj);

   }
  
removeEmployee(empno:Number){
let index=this.emparray.findIndex((item)=>item.empsnumber == empno)
  this.emparray.slice(index,1);
  alert(empno);
 //alert(this.empsnumber)
 //console.log(empsnumber);
}
}

class Employee{
 public empsnumber:number=0;
 public empsname:string="";
  public empssalary:number=0;
  public empsjobtitle:string="";
 public empsdepartment:string="";
}