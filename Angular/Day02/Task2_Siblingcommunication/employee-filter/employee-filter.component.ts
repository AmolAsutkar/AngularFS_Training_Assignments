import { Component,Output,OnInit, Input,EventEmitter } from '@angular/core';
import { Emps } from '../Model/Emps';

@Component({
  selector: 'app-employee-filter',
  templateUrl: './employee-filter.component.html',
  styleUrls: ['./employee-filter.component.css']
})
export class EmployeeFilterComponent implements OnInit {
  

  @Output()
  onClickSortFilter:EventEmitter<string> = new EventEmitter();
  
  sortEmpNo:string = '';


  constructor() { }

  ngOnInit(): void {
  }

  sortEmpname(){
    alert('vmbmb')
    
   // this.onClickSortFilter.emit(empname);
  }

  sort_EmpNo(evntName:string){
    this.onClickSortFilter.emit(evntName);
  }
}
