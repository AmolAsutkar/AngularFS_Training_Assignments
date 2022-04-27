import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-freind-list',
  templateUrl: './freind-list.component.html',
  styleUrls: ['./freind-list.component.css']
})
export class FreindListComponent implements OnInit {

  FriendsArray:string[]=["Amol","Ajinkya","Shubham"];

  constructor() { }

  ngOnInit(): void {
  }

}
