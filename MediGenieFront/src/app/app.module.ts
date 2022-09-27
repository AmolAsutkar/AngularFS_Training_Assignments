import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {Ng2OrderModule} from 'ng2-order-pipe';
import {NgxPaginationModule} from 'ngx-pagination';

//import { AngularFireModule } from '@angular/fire';
//import { AngularFireDatabaseModule } from 'angularfire2/database';

import { MaterialModule } from './material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HospitalUserComponent } from './components/hospital-user/hospital-user.component';
import { PatientUserComponent } from './components/patient-user/patient-user.component';
import { LoginComponent } from './components/login/login.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { AboutPageComponent } from './components/about-page/about-page.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AuthInterceptor, authInterceptorProviders } from './helpers/auth.interceptor';
import { AdminComponent } from './components/admin/admin.component';
import { GetPhysicianComponent } from './components/get-physician/get-physician.component';
import { GetPatientComponent } from './components/get-patient/get-patient.component';
import { GetNurseComponent } from './components/get-nurse/get-nurse.component';
import { CreateHospitalUserComponent } from './components/create-hospital-user/create-hospital-user.component';
import { SearchUserComponent } from './components/search-user/search-user.component';
import { AuthGuardService } from './components/auth-guard.service';
import { AdminProfileComponent } from './components/admin-profile/admin-profile.component';
import { AddDetailsComponent } from './components/patient-profile/add-details/add-details.component';
import { BookAppointmentComponent } from './components/patient-profile/book-appointment/book-appointment.component';
import { VisitDetailsComponent } from './components/patient-profile/visit-details/visit-details.component';
import { PhysicianAppointmentsComponent } from './components/physician-profile/physician-appointments/physician-appointments.component';
import { PhysicianPendingComponent } from './components/physician-profile/physician-pending/physician-pending.component';
import { PhysicianInboxComponent } from './components/physician-profile/physician-inbox/physician-inbox.component';
// import { PatientCancelledComponent } from './components/patient-profile/patient-cancelled/patient-cancelled.component';
import { InboxComponent } from './components/physician-profile/inbox/inbox.component';
import { NurseInboxComponent } from './components/nurse-profile/nurse-inbox/nurse-inbox.component';
import { NurseAppointmentsComponent } from './components/nurse-profile/nurse-appointments/nurse-appointments.component';
import { PatientVitalsComponent } from './components/nurse-profile/patient-vitals/patient-vitals.component';
import { NurseProfileComponent } from './components/nurse-profile/nurse-profile/nurse-profile.component';
import { ToastrModule } from 'ngx-toastr';
import { InboxModule } from './inbox/inbox.module';
import { ChangeForgotPasswordComponent } from './components/change-forgot-password/change-forgot-password.component';
import { ScheduleAppoinmentComponent } from './components/schedule-appoinment/schedule-appoinment.component';
import { ViewAppoinmentComponent } from './components/view-appoinment/view-appoinment.component';
import { DoctorsAppoinmentComponent } from './doctors-appoinment/doctors-appoinment.component';

@NgModule({
  declarations: [
    AppComponent,
    HospitalUserComponent,
    PatientUserComponent,
    LoginComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    NavbarComponent,
    HomeComponent,
    UserProfileComponent,
    AboutPageComponent,
    ProfileComponent,
    AdminComponent,
    GetPhysicianComponent,
    GetPatientComponent,
    GetNurseComponent,
    CreateHospitalUserComponent,
    SearchUserComponent,
    AdminProfileComponent,
    AddDetailsComponent,
    BookAppointmentComponent,
    VisitDetailsComponent,
    PhysicianAppointmentsComponent,
    PhysicianPendingComponent,
    PhysicianInboxComponent,
    InboxComponent,
    NurseInboxComponent,
    NurseAppointmentsComponent,
    PatientVitalsComponent,
    NurseProfileComponent,
    ChangeForgotPasswordComponent,
    ScheduleAppoinmentComponent,
    ViewAppoinmentComponent,
    DoctorsAppoinmentComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    Ng2SearchPipeModule,
    MaterialModule,
    Ng2OrderModule,
    NgxPaginationModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    InboxModule
  ],
  providers: [authInterceptorProviders,
    {provide : AuthGuardService, useClass:AuthGuardService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
