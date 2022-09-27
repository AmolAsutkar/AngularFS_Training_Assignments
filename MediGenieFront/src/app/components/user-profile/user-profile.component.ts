import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {


  user:string="Sagar Motwani"
  hide = false;
  formGroup!: FormGroup;
  titleAlert: string = 'This field is required';
  post: any = '';
  form: FormGroup = new FormGroup({});
  constructor(private formBuilder: FormBuilder) { }



  ngOnInit() {
    this.createForm();
    // todo : service call with patchvalue code goes here before disabling
    this.formGroup.disable();
  }

  createForm() {
    let emailregex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    this.formGroup = this.formBuilder.group({
      'email': ["sagarmot6@gmail.com", [Validators.required, Validators.pattern(emailregex)]],
      'firstName': ["Sagar", Validators.required],
      'lastName': ["Motwani", Validators.required],
      'password': ["sagar123", [Validators.required]],
       title: ['Mr'],
      dob:[new Date(),[Validators.required]],
      empId:[null],
      role:[null],
    });
  }

  saveDetails(form: any) {
    alert('SUCCESS!! :-)\n\n' + JSON.stringify(form.value, null, 4));
  }

}