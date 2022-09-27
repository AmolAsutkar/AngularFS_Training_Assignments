import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-patient-user',
  templateUrl: './patient-user.component.html',
  styleUrls: ['./patient-user.component.scss']
})
export class PatientUserComponent implements OnInit {


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

  today = new Date();

  errorMessage = ''
  hide = true
  conHide = true;

  constructor(private userService: UserService,
    private router: Router, private toastr: ToastrService) { }

  ngOnInit() {

  }

  checkPasswordStrength(str: string): boolean {
    var pattern = new RegExp(
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).+$"
    );

    if (pattern.test(str) && str.length >= 8) {
      return true;
    } else {
      return false;
    }
  }

  saveUser() {

    const { firstName, lastName, gender, dateOfBirth, email, mobileNumber, password } = this.form;

    if (firstName == null || lastName == null || gender == null || dateOfBirth == null || email == null || mobileNumber == null || password == null) {
      this.toastr.error("Please fill the all required fields", "Error");
    }
    else {
      if (this.checkPasswordStrength(password)) {
        if (this.form.password == this.confirmPassword) {
          this.userService.saveUser(firstName, lastName, gender, dateOfBirth, email, mobileNumber, password).subscribe(
            data => {
              console.log('response', data);
              this.toastr.success("User Registered successfully", "Success", {
                timeOut: 5000
              })
              setTimeout(() => {
                this.router.navigateByUrl("/login");
              }, 2000)
              this.toastr.info("Please Login for more details", "Info")
            },
            err => {
              this.errorMessage = err.error.message;
              console.log(this.errorMessage);
              this.toastr.error(this.errorMessage, "Failure")
            }
          )
        } else {
          this.toastr.error("Password and Confirm Password must be same. Please check again.", "Error")
        }
      } else {
        this.toastr.error(" Password must contain atleast 8 characters with one Uppercase, one Lowercase, one Special character and one Numeric value.", "Failure", {
          timeOut: 5000
        });
      }
    }
  }
}
