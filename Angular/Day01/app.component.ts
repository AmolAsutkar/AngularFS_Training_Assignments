import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-project';
  public EmployeeId:number =  54654564;
  public	EmployeeName: string ="Stephen" 
	public EmployeeJob: string = "Manger"
	public EmployeeSalary	:number=  75000;
	public EmployeeDepo 	:number=10;
}
