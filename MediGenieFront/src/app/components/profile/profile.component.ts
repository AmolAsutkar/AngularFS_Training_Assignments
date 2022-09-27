import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

export interface Role{
  roleId:number;
  role:string;
}

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  currentUser: any;
  roles: Role[] = [];
  role!: string;


  constructor(private tokenStorageService: TokenStorageService, private router:Router) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
    this.roles = this.tokenStorageService.getUser().roles;
    this.role = this.roles[0].role;
    

    
      
    }
  }


