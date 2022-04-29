import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-sort-options',
  templateUrl: './sort-options.component.html',
  styleUrls: ['./sort-options.component.css']
})
export class SortOptionsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Output()
  onOptionClick:EventEmitter<string> = new EventEmitter();

  option_click(value:number){
    this.onOptionClick.emit(value.toString());
  }

}
