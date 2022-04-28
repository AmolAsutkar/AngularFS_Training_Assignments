import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'siblingcommunication';

  filters:string = 'sortenvt';

  Sort(sortfilter:string){

    this.filters = sortfilter;
  }
}
