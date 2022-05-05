import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {


  getUrl: string = "http://localhost:3000/students/";

  constructor(private _httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this._httpClient.get(this.getUrl);
  }

  getById(id: number): any {
    return this._httpClient.get(this.getUrl+ id);
  }

  addStudent(obj: any): any {
    return this._httpClient.post(this.getUrl, obj);
  }

  updateStudent(obj: any): any {
    return this._httpClient.put(this.getUrl + obj.sid, obj);
  }

  deleteStudent(id: number): any {
    return this._httpClient.delete(this.getUrl+ id);
  }

   //  Customizing the response using RxJS operators

  getStudentsByCity(city: string):Observable<any[]>{
    return this._httpClient.get<any[]>(this.getUrl).pipe(
      map(res => {
        return  res.filter(item => item.sloc == city);
      })
    )
  }

  getStudentNames():Observable<string[]>
  {
    return this._httpClient.get<any[]>(this.getUrl).pipe(
      map(res => {
        return res.map(item => { return item.sname });
    })
    );
  }

  getStudentsByBranchExcludingEEE(): Observable<any[]> {
    return this._httpClient.get<any[]>(this.getUrl).pipe(
      map(res =>{
        return res.filter(item => item.sdept != "EEE")
      })
    )
  }

}
