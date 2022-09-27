import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  email = ''
  otp = ''
  generatedOtp = ''
  errorMessage = ''
  isInvalidUser = false;
  isEmailSent = false;
  isOtpInValid = false;

  constructor(private userService: UserService,
    private tokenStorageService: TokenStorageService,
    private router: Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {

  }

  forgotPassword() {
    this.isInvalidUser = false;
    this.userService.forgotPassword(this.email).subscribe(
      result => {
        this.isEmailSent = true;
        this.toastr.success("An OTP sent to your email", "Success");
        console.log(result);
        this.tokenStorageService.saveUser(result);
      },
      err => {
        this.errorMessage = err.error.message;
        this.isInvalidUser = true;
        this.toastr.error("Invalid email, please check your email", "Error");
        console.log(this.errorMessage);
      }
    )
  }

  checkOtp() {
   this.userService.verifyOtp(this.email, this.otp).subscribe(
     data => {
       console.log(data);
       this.toastr.success("OTP verified successfully", "Success");
       this.router.navigateByUrl("/change-forgot-password");
     },
     err => {
      this.errorMessage = err.error.message;
      this.isOtpInValid = true;
      this.toastr.error("Invalid OTP. Please try again.", "Error");
      console.log(this.errorMessage);
     }
   )
  }
}
