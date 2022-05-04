import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Subscription } from 'rxjs';



@Component({
  selector: 'app-rxjxdemo',
  templateUrl: './rxjxdemo.component.html',
  styleUrls: ['./rxjxdemo.component.css']
})
export class RxjxdemoComponent  {

  inputItem: string = '';
  id:number=0;

  todoListObj: any[] = [
    { id: 1, itemName: "learn react js basic", isDone: true },
    { id: 2, itemName: "prectice react js", isDone: false },
    { id: 3, itemName: "learn redux", isDone: false },
    { id: 4, itemName: "code portfolio in react", isDone: false },
    { id: 5, itemName: "learn react native", isDone: false }
  ];


  constructor() { }

  ngOnInit(): void {
  }



  addNew_click() {
    let todoObj: any = new Object();
    todoObj.itemName = this.inputItem;
    this.todoListObj.push(todoObj);
  }


  delete_click(id: number): void {
    let index = this.todoListObj.findIndex(item => item.id == id);
    this.todoListObj.splice(index, 1);
  }




  select_click(id: number) {
    let obj: any = this.todoListObj.filter(item => item.id == id);
    this.inputItem = obj[0].itemName;
    // obj.itemName = this.inputItem; 
    this.id = id;

  }


  update_click() {
    let obj: any = this.todoListObj.filter(item => item.id == this.id);
   
    obj[0].itemName = this.inputItem; 
    obj[0].id = this.id; 
   
  

  }


  DeleteDone_click() {
    this.todoListObj = this.todoListObj.filter(todo => todo.isDone == false);

  }

  DeleteAll_click() {
    this.todoListObj = [{}];
  }

}