import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  form: any = {
    email: null,
    oldPassword: null,
    newPassword: null
  };

  confirmNewPassword = ''

  oldHide = true;
  newHide = true;
  newConHide = true;

  currentUser: any;
  errorMessage = '';

  constructor(private tokenStorageService: TokenStorageService,
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
    this.form.email = this.tokenStorageService.getUser().email;
  }

  checkPasswordStrength(str: string): boolean {
    var pattern = new RegExp(
      "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-+_!@#$%^&*.,?]).+$"
    );

    if (pattern.test(str) && str.length >= 8) {
      return true;
    } else {
      this.toastr.warning("Password must contain atleast 8 characters with one Uppercase, one Lowercase, one Special character and one numeric value.", "Warning");
      return false;
    }
  }

  changePassword() {

    const { email, oldPassword, newPassword } = this.form;

    if(email == null || oldPassword == null || newPassword == null) {
      this.toastr.error("Please fill all the fields", "Error");
    } else {
      if (this.checkPasswordStrength(newPassword)) {
        if (oldPassword == newPassword) {
          this.toastr.error("Current and New Password must be different.", "Error");
        } else {
          if (newPassword == this.confirmNewPassword) {
            this.userService.changePassword(email, oldPassword, newPassword).subscribe(
              data => {
                console.log(data);
                this.toastr.success("Password Changed. Please login again.", "Success");
                setTimeout(() => {
                  this.router.navigateByUrl("/login");
                }, 3000)
              },
              err => {
                this.errorMessage = err.error.message;
                console.log(this.errorMessage);
                this.toastr.error(this.errorMessage, "Error");
              }
            )
          } else {
            this.toastr.error("New Password and Confirm New Password must match.", "Error");
          }
        }
      }
    }

    
  }
}
