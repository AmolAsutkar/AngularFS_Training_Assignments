import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';
import { map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL: string = "http://localhost:8070/api/user";

  constructor(private _httpClient: HttpClient) { }

  getUser(id: number): Observable<User> {
    return this._httpClient.get<User>(`${this.baseURL}/${id}`).pipe(
      map(response => response)
    )
  }

saveUser( firstName: string, lastName: string, gender: string,
dateOfBirth: string, email: string, mobileNumber: string, password: string): Observable<any> {
 return this._httpClient.post(this.baseURL+'/signup', {
 firstName, lastName, gender, dateOfBirth, email, mobileNumber, password
 }, httpOptions)
}



  login(email: string, password: string): Observable<any> {
    return this._httpClient.post(this.baseURL+'/signin', {
      email, password
    }, httpOptions)
  }

  changePassword(email: string, oldPassword: string, newPassword: string) {
    return this._httpClient.put(this.baseURL+'/changePassword', {
      email, oldPassword, newPassword
    }, httpOptions)
  }
  
   forgotPassword(email: string) {
    return this._httpClient.post(this.baseURL+'/forgotPassword', {
      email
    }, httpOptions)
  }

  changeForgotPassword(email: string, newPassword: string) {
    return this._httpClient.post(this.baseURL+'/changeForgotPassword', {
      email, newPassword
    }, httpOptions)
  }

  verifyOtp(email: string, otp: string) {
    return this._httpClient.post(this.baseURL+"/verifyOtp", {
      email, otp
    }, httpOptions)
  }

  wronAttempt(email: string) {
    return this._httpClient.post(this.baseURL+'/wrongAttempt', {
      email, httpOptions
    })
  }

  getNurse():Observable<User[]>{
    return this._httpClient.get<User[]>(this.baseURL +'/findByRole?role='+"NURSE");
  }

  getPhysician():Observable<User[]>{
    return this._httpClient.get<User[]>(this.baseURL +'/findByRole?role='+"PHYSICIAN");
  }

  getPatient():Observable<User[]>{
    return this._httpClient.get<User[]>(this.baseURL +'/findByRole?role='+"PATIENT");
  }

  changeStatus(id:number): Observable<User> {
    return this._httpClient.put<User>(this.baseURL + '/changeStatus/' + id, httpOptions);
  }

  getById(id:number): Observable<User> {
    return this._httpClient.get<User>(this.baseURL  + '/findById/'+id);
  }

  addUser(user:any):Observable<User>{
    console.log(user);
    return this._httpClient.post<User>(this.baseURL+'/signup',user,httpOptions);
  }
}
 
