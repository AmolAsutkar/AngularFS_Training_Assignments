import { Component, Input ,OnInit } from '@angular/core';
import {Product } from '../model/Product';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {


  @Input()
  category:string='';

  filterProd:Product[]=[];
  constructor() { }

  ngOnInit(): void {
    this.filterProd = this.ProductArray.filter(item=>item.category == this.category);

  }


  ProductArray:Product[] = [
    {pid :1, pname :"bed",price:5667,category:"category1"} ,
    {pid :2, pname : "Television",price:5667,category:"category2"} ,
    {pid :3, pname : "bat",price:5667,category:"category3"} ,
    {pid :4, pname : "shirt",price:5667,category:"category4"} ,
    {pid :5, pname : "shoes",price:5667,category:"category5"} 

  ];

}
