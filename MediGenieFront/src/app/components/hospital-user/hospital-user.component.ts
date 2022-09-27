import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

interface Role {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-hospital-user',
  templateUrl: './hospital-user.component.html',
  styleUrls: ['./hospital-user.component.scss']
})
export class HospitalUserComponent implements OnInit {

  form: any = {
    firstName: null,
    lastName: null,
    gender: null,
    dateOfBirth: null,
    email: null,
    mobileNumber: null,
    password: null
  };

  confirmPassword = ''

  isPasswordMatched = true;
  isRegistrationFailed = false;
  isRegistrationSuccess = false;
  errorMessage = ''
  hide = true

  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit() {

  }

  saveUser() {
    this.isPasswordMatched = true;
    this.isRegistrationFailed = false;
    
    const { firstName, lastName, gender, dateOfBirth, email, mobileNumber, password } = this.form;
    if(this.form.password == this.confirmPassword) {
      this.userService.saveUser(firstName, lastName, gender, dateOfBirth, email, mobileNumber, password).subscribe(
        data => {
          console.log('response', data);
          this.isRegistrationSuccess = true;
          // setTimeout(() => {
          //   this.router.navigateByUrl("/login");
          // }, 3000)
          
        },
        err => {
          this.errorMessage = err.error.message;
          this.isRegistrationFailed = true;
          console.log(this.errorMessage);
        }
      )
    } else {
      this.isPasswordMatched = false;
    }

  }

  reloadPage(): void {
    window.location.reload();
  }

}
