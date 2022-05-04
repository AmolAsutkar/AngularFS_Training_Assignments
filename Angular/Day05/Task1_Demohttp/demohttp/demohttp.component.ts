import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-demohttp',
  templateUrl: './demohttp.component.html',
  styleUrls: ['./demohttp.component.css']
})
export class DemohttpComponent  {

  constructor(private httpclient: HttpClient) { }


UserArray : any  = [];
 
get_data()
{
let  url = "https://reqres.in/api/users";

this.httpclient.get(url).subscribe(data => {
  this.UserArray = data;
  console.log(this.UserArray);
});
}

}
