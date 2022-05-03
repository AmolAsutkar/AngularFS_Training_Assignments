import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  productArr: any[] = [
    { pid: 1, pname: "bed", price: 100, category: "category1", qty: 4,picture:"assets/bed.png" },
    { pid: 2, pname: "sofa", price: 200, category: "category3", qty: 2,picture:"assets/sofa.png" },
    { pid: 3, pname: "cupboard", price: 300, category: "category1", qty: 4,picture:"assets/cupboard.png" },
    { pid: 4, pname: "tv", price: 400, category: "category7", qty: 6,picture:"assets/TV.png" },
    { pid: 5, pname: "shoes", price: 500, category: "category8", qty: 8,picture:"assets/shoes.png" },
  ];
  
}
