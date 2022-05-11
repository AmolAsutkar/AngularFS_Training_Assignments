import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { GradePipe } from './grade.pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmployeedetailsComponent,
    GradePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
