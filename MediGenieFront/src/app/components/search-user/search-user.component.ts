import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

export interface Role{
  roleId:number;
  role:string;
}


@Component({
  selector: 'app-search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.scss']
})
export class SearchUserComponent implements OnInit {

  currentUser: any;
  roles: Role[] = [];
  role!: string;


  constructor(private dataService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private observer: BreakpointObserver) { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  getUser(event:any){
    this.dataService.getById(event).subscribe((data:any)=>{
      console.log(data);
      this.currentUser = data;
    });
  }

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;


  
  ngAfterViewInit() {
    this.observer
      .observe(['(max-width: 800px)'])
      .subscribe((res) => {
        if (res.matches) {
          this.sidenav.mode = 'over';
          this.sidenav.close();
        } else {
          this.sidenav.mode = 'side';
          this.sidenav.open();
        }
      });
    }

}
