import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  productArr: any[] = [
    { pid: 1, pname: "Electronics" },
    { pid: 2, pname: "Furniture" },
    { pid: 3, pname: "Garments" },
    { pid: 4, pname: "Sports"}
  ];
}
