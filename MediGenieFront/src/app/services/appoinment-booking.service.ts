//import { HttpClient } from '@angular/common/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//import { booking } from './models/booking';
//import { Viewappoinment } from './models/Viewappoinment';
//import { User } from './models/User';
import { booking } from '../models/booking';
import { User } from '../models/user';
import { userforphysicianname } from '../models/userforphysicianname';
import { Viewappoinment } from '../models/Viewappoinment';


Viewappoinment

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AppoinmentBookingService {

  private baseURL: string = "http://localhost:8070/api/user";

  constructor(private httpClient:HttpClient ) { }

//  book(booking:booking): Observable<booking> {
  //  return this.httpClient.post<booking>("http://localhost:8091/save", booking,{responseType:'text' as 'json'});
 // }
  
 book(booking:any):Observable<booking>{
    console.log(booking);
    return this.httpClient.post<booking>("http://localhost:8091/bookappoinment",booking,httpOptions);
  }

  getappoinments():Observable<Viewappoinment[]>{
    return this.httpClient.get<Viewappoinment[]>("http://localhost:8091/Viewappoinment");
  }

  getappoinment():Observable<Viewappoinment[]>{
    return this.httpClient.get<Viewappoinment[]>("http://localhost:8091//findById/{id}");
  }

  deleteappoinment():Observable<object>{
    return this.httpClient.delete("http://localhost:8091/deleteappoinment/{id}")
  }
  getPhysician():Observable<User[]>{
    return this.httpClient.get<User[]>(this.baseURL +'/findByRole?role='+"PHYSICIAN");
  }

 
 
}
