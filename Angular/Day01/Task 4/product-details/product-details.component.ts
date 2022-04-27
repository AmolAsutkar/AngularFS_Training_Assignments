import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
     prodprice:number = 0;
     prodname:string = "";
     qty:number = 0;
     amount:number=0;
     strcolor:string=""

  constructor() { }

  ngOnInit(): void {
  }

   calculate(){
    
   this.amount=this.prodprice*this.qty;
   if(this.amount>1000){
     this.strcolor="color:green;"
   }
   else{
    this.strcolor="color:Red;"
  }
   }
}
