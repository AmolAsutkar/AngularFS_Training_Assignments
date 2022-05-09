import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CategoriesComponent } from './categories/categories.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';


const routes: Routes = [
  { path : "", component: HomeComponent  },
    { path : "categories", component: CategoriesComponent},
    { path : "abtus", component: AboutusComponent  },
    { path : "Login", component: LoginComponent },
    { path : "contact", component: ContactComponent },
    {path : "details/:id" , component:ProductdetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
