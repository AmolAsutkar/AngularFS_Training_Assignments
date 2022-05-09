import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.css']
})
export class ProductdetailsComponent implements OnInit {

  constructor(private   route: ActivatedRoute) { }
  
  productArr:any = {};
  productArrcpy: any[] = [
    { pid: 1, pname: "mi", price: 10000, category: "gaming", qty: 1 },
    { pid: 2, pname: "samsung", price: 20000, category: "music", qty: 2 },
    { pid: 3, pname: "realme", price: 30000, category: " amoleddisplay", qty: 4 },
    { pid: 4, pname: "iphone", price: 40000, category: "battery", qty: 6 }
  ];

  ngOnInit(): void {
    let selecteproduct =this.route.snapshot.params["id"];
    this.productArr = this.productArrcpy.filter(item => item.pid == selecteproduct);

    console.log(this.productArr)
  }

}
