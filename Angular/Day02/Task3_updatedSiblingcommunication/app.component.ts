import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'siblingcomponentupdated';
  sortOption:string = ""; 

  sortList(value:string){
    this.sortOption = value;
  }
}
