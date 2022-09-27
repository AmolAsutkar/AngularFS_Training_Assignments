import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { TokenStorageService } from 'src/app/services/token-storage.service'
import { ToastrService } from 'ngx-toastr';
import { timeout } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  form: any = {
    email: null,
    password: null
  };

  currentUser: any;
  firstLogin!: boolean;

  hide = true;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  role!: string;
  attempsremaining!: string;

  constructor(private router: Router,
    private userService: UserService,
    private tokenStorageService: TokenStorageService,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
    }
  }

  login_submit() {
    const { email, password } = this.form;

    this.userService.wronAttempt(email).subscribe(
      result => {
        console.log(result);
        this.attempsremaining = result.toString();
      }
    )

    this.userService.login(email, password).subscribe(
      data => {
        this.tokenStorageService.saveToken(data.accessToken);
        this.tokenStorageService.saveUser(data.user);
        console.log('This is the user');
        console.log(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorageService.getUser().roles;
        this.firstLogin = this.tokenStorageService.getUser().firstLogin;

        if (this.firstLogin == true) {
          this.router.navigateByUrl("/change-password");
        } else {
          if (this.tokenStorageService.getUser().roles[0].role == "ROLE_ADMIN") {
            this.toastr.success("User Logged In successfully", "Success")
            console.log(this.tokenStorageService.getUser().roles)
            this.router.navigateByUrl("/adminProfile");
          }
          else if (this.tokenStorageService.getUser().roles[0].role == "ROLE_PHYSICIAN") {
            this.toastr.success("User Logged In successfully", "Success")
            this.router.navigateByUrl("/profile");

          }
          else if (this.tokenStorageService.getUser().roles[0].role == "ROLE_PATIENT") {
            this.toastr.success("User Logged In successfully", "Success")
            this.router.navigateByUrl("/addDetails");
          }
        }
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
        console.log(this.errorMessage);

        this.toastr.error(this.errorMessage, "Error", {
          timeOut: 5000
        })

        if (parseInt(this.attempsremaining) < 2) {
          this.toastr.warning(2 - parseInt(this.attempsremaining) + " login attempts remaining", "", {
            timeOut: 5000
          })
        }
      }
    );
  }

}
