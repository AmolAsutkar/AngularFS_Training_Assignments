import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productname:string = '';
  unitprice:any = 0;
  quantity:any = 1;
  totalAmount:string = '';
  //mystyle:string = '';

  constructor() { }

  ngOnInit(): void {
  }
  
   getTotalAmount(){
    this.totalAmount ="Total Amount : "+ this.unitprice*this.quantity;
  }
}
