import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-change-forgot-password',
  templateUrl: './change-forgot-password.component.html',
  styleUrls: ['./change-forgot-password.component.scss']
})
export class ChangeForgotPasswordComponent implements OnInit {

  currentUser: any

  form: any = {
    email: null,
    newPassword: null,
    confirmNewPassword: null
  };

  errorMessage = ''
  hide = true
  conHide = true;

  constructor(private userService: UserService,
    private router: Router,
    private tokenStorageService: TokenStorageService,
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

  changeForgotPassword() {

    const { email, newPassword, confirmNewPassword} = this.form;

    if(this.checkPasswordStrength(newPassword)) {
      if (newPassword == confirmNewPassword) {
        this.userService.changeForgotPassword(email, newPassword).subscribe(
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
        this.toastr.error("New Password and New Confirm Password must match.", "Error");
      }
    }
  }

}
