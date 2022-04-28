import { Component, Input ,OnInit } from '@angular/core';
import {Product } from '../model/Product';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {


  @Input() cat:string ="";


  filterProd:Product[]=[];
  constructor() { }

  ngOnInit(): void {
    alert(this.cat)
    this.filterProd = this.ProductArray.filter(item1 => item1.category == this.cat);

  }


  ProductArray:Product[] = [
    {pid :1, pname :"bed",price:5667,category:"furniture"} ,
    {pid :2, pname : "Television",price:5667,category:"electronics"} ,
    {pid :3, pname : "bat",price:5667,category:"sports"} ,
    {pid :4, pname : "shirt",price:5667,category:"clothes"} ,
    {pid :5, pname : "shoes",price:5667,category:"footware"} 

  ];

}
