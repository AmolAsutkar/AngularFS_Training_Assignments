
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input()
  item: any= {};
  
  @Output() onremoveprod = new EventEmitter<number>();


 public removeprod(dno: number){
  this.onremoveprod.emit(dno);

  }
}
