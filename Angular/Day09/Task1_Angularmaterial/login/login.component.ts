import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  UserName:string = "";
  Password:string = "";
  result:string = "";
  count:number = 0;
  isDisabled:boolean = false;

  public login_click():void
  {
     if(this.UserName == "admin" && this.Password == "admin123")
     {
       this.result ="Welcome to Admin!";
     }
     else
     {
       this.count++;
       this.result = "Invalid username or password!"
       if(this.count == 3)
       {
         this.isDisabled = true;
       }
     }
  }


constructor() { }

ngOnInit(): void {
}

}
