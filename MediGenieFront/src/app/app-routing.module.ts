import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { PatientUserComponent } from './components/patient-user/patient-user.component';
import { AboutPageComponent } from './components/about-page/about-page.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { AdminComponent } from './components/admin/admin.component';
import { CreateHospitalUserComponent } from './components/create-hospital-user/create-hospital-user.component';
import { GetNurseComponent } from './components/get-nurse/get-nurse.component';
import { GetPatientComponent } from './components/get-patient/get-patient.component';
import { GetPhysicianComponent } from './components/get-physician/get-physician.component';
import { SearchUserComponent } from './components/search-user/search-user.component';
import { AuthGuardService } from './components/auth-guard.service';
import { AdminProfileComponent } from './components/admin-profile/admin-profile.component';
import { BookAppointmentComponent } from './components/patient-profile/book-appointment/book-appointment.component';
import { AddDetailsComponent } from './components/patient-profile/add-details/add-details.component';
import { VisitDetailsComponent } from './components/patient-profile/visit-details/visit-details.component';
import { PatientGuardService } from './components/patient-profile/patient-guard.service';
import { PhysicianAppointmentsComponent } from './components/physician-profile/physician-appointments/physician-appointments.component';
import { PhysicianPendingComponent } from './components/physician-profile/physician-pending/physician-pending.component';
import { PhysicianInboxComponent } from './components/physician-profile/physician-inbox/physician-inbox.component';
import { NurseAppointmentsComponent } from './components/nurse-profile/nurse-appointments/nurse-appointments.component';
import { PatientVitalsComponent } from './components/nurse-profile/patient-vitals/patient-vitals.component';
import { NurseInboxComponent } from './components/nurse-profile/nurse-inbox/nurse-inbox.component';
import { NurseProfileComponent } from './components/nurse-profile/nurse-profile/nurse-profile.component';
import { ChangeForgotPasswordComponent } from './components/change-forgot-password/change-forgot-password.component';
import { DefaultComponent } from './inbox/default/default.component';
import { ScheduleAppoinmentComponent } from './components/schedule-appoinment/schedule-appoinment.component';
import { ViewAppoinmentComponent } from './components/view-appoinment/view-appoinment.component';
import { DoctorsAppoinmentComponent } from './doctors-appoinment/doctors-appoinment.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
  
  {
    path: 'signup',
    component: PatientUserComponent,
    pathMatch: 'full',
  },
  {
    path: 'about',
    component: AboutPageComponent,
    pathMatch: 'full',
  },
  {
    path: 'forgot',
    component: ForgotPasswordComponent,
    pathMatch: 'full',
  },
  {
    path: 'change-forgot-password',
    component: ChangeForgotPasswordComponent,
    pathMatch: 'full',
  },
  {
    path: 'change-password',
    component: ChangePasswordComponent,
    pathMatch: 'full',
     canActivate: [AuthGuardService],
  },
  {
    path: 'change-password',
    component: ChangePasswordComponent,
    pathMatch: 'full',
  },
  {
    path: 'profile',
    component: ProfileComponent,
    pathMatch: 'full',
    canActivate: [AuthGuardService],
  },
  {
    path: 'user-profile',
    component: UserProfileComponent,
    pathMatch: 'full',
    canActivate: [AuthGuardService],
  },
  {
    path: 'visitDetails',
    component: VisitDetailsComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'bookAppointment',
    component: BookAppointmentComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'addDetails',
    component: AddDetailsComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'physicianAppointments',
    component: PhysicianAppointmentsComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'physicianPending',
    component: PhysicianPendingComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'physicianInbox',
    component: PhysicianInboxComponent,
    // canActivate: [AuthGuardService],
  },

  {
    path: 'nurseAppointments',
    component: NurseAppointmentsComponent,
  },
  {
    path: 'patientVitals',
    component: PatientVitalsComponent,
  },
  {
    path: 'nurseInbox',
    component: NurseInboxComponent,
  },
  {
    path: 'nurseProfile',
    component: NurseProfileComponent,
  },

  {
    path: 'adminProfile',
    component: AdminProfileComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'getNurse',
    component: GetNurseComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'getPhysician',
    component: GetPhysicianComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'getPatient',
    component: GetPatientComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'createUser',
    component: CreateHospitalUserComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'searchUser',
    component: SearchUserComponent,
    canActivate: [AuthGuardService],
  },
  {
    path: 'admin',
    component: AdminComponent,
    pathMatch: 'full',
    canActivate: [AuthGuardService],
  },
  {
    path: 'inbox2',
    component: DefaultComponent,
    pathMatch: 'full',
    // canActivate: [AuthGuardService],
  },
  {
    path: 'bookappoinment',
    component: ScheduleAppoinmentComponent,
    pathMatch: 'full',
  },
  
  {
    path: 'viewappoinment',
    component: ViewAppoinmentComponent,
    pathMatch: 'full',
  },
 
  {
    path: 'viewdoctorsappoinment',
    component: DoctorsAppoinmentComponent,
    pathMatch: 'full',
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
