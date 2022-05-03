import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FancycardsComponent } from './fancycards/fancycards.component';
import { StudentdetailsComponent } from './studentdetails/studentdetails.component';
import { EmployeedetailsComponent } from './employeedetails/employeedetails.component';
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    FancycardsComponent,
    StudentdetailsComponent,
    EmployeedetailsComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
