import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpsListComponent } from './emps-list/emps-list.component';
import { SortOptionsComponent } from './sort-options/sort-options.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpsListComponent,
    SortOptionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
