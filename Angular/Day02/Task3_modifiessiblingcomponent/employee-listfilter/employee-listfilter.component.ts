import { Component, OnInit,EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-employee-listfilter',
  templateUrl: './employee-listfilter.component.html',
  styleUrls: ['./employee-listfilter.component.css']
})
export class EmployeeListfilterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Output()
  passingoptionclick:EventEmitter<string>=new EventEmitter();

  option_click(input:string){
this.passingoptionclick.emit(input);
  }
}
