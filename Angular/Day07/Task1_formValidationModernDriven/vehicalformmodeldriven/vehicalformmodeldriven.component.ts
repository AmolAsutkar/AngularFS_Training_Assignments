import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators  } from '@angular/forms';

@Component({
  selector: 'app-vehicalformmodeldriven',
  templateUrl: './vehicalformmodeldriven.component.html',
  styleUrls: ['./vehicalformmodeldriven.component.css']
})
export class VehicalformmodeldrivenComponent implements OnInit {

  customerForm:FormGroup = new FormGroup({
    oname : new FormControl("", Validators.required),
    cntnumber : new FormControl("", [Validators.required,Validators.pattern('\\d{10}'),Validators.maxLength(10)]),
    registrationnumber : new FormControl("", [Validators.pattern('(([A-Za-z]){2,3}(|-)(?:[0-9]){1,2}(|-)(?:[A-Za-z]){2}(|-)([0-9]){1,4})|(([A-Za-z]){2,3}(|-)([0-9]){1,4})'), Validators.maxLength(10)]),
    email : new FormControl("", [Validators.email, Validators.required]),
    address : new FormControl("", Validators.required),
    vehicalmodel : new FormControl("", Validators.pattern('\\d{10}')),
    color : new FormControl("", Validators.required),
    year : new FormControl("", Validators.pattern('(20[0-1][0-9]|20[0-2][0-1]|2022)'))
  });

 constructor() { }

 ngOnInit(): void {
 }



 public submit_click():void
 {
     // ajax call to send data to server
     alert("vehicals Details are registered.");
     //let customerObj = this.customerForm.value;
     //console.log(customerObj);
 }

}
