import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  url:string = "http://localhost:3500/emp/";

  constructor(private httpObj:HttpClient) { }

  public getAllEmployees() : Observable<any>{

    return this.httpObj.get(this.url);

  }

  public addEmployee(empObj:any){

    return this.httpObj.post(this.url,empObj);

  }

  public updateEmployee(empObj:any){

    return this.httpObj.put(this.url + empObj.empno , empObj);

  }

  public deleteEmployee(empno:number){

    return this.httpObj.delete(this.url + empno);

  }
}
