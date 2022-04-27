import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-cards',
  templateUrl: './product-cards.component.html',
  styleUrls: ['./product-cards.component.css']
})
export class ProductCardsComponent implements OnInit {

  Productarray:Product[]=[
      {pid:45,pname:"sofa",price:9000,category:"furniture",qty:2},    
      {pid:87,pname:"bed",price:88000,category:"furniture",qty:6},
      {pid:45,pname:"cylinder",price:7000,category:"kithchen",qty:9},
      {pid:45,pname:"gas",price:87000,category:"kithchen",qty:27},



  ];

 

  constructor() { }

  ngOnInit(): void {
  }

}
export class Product {
    
  public pid:number=0;
   public pname:string="";
   public price:number=0;
    public category:string="";
    public qty:number=0;
 
 }