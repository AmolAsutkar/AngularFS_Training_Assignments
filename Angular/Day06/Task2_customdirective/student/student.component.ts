import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  
  sid: number = 0;
  sname: string = "";
  sdept: string = "";
  sloc: string = "";
  studentArray: any[] = [];

  result: any[] =[];

  constructor(private _studentService: StudentService) { }

  ngOnInit(): void {
  }

  getAllStudents() {
    this._studentService.getAll().subscribe((response: any) => {
      console.log(response);
      this.studentArray = response;
    });
  }

  add_student() {
    let studentObj: any = {};
    studentObj.sid = this.sid;
    studentObj.sname = this.sname;
    studentObj.sdept = this.sdept;
    studentObj.sloc = this.sloc;

    console.log(studentObj);

    this._studentService.addStudent(studentObj).subscribe((response: any) => {
      alert("New student details are added to the database");
      this.getAllStudents();
    })
  }

  select_student(sid: number) {
    this.sid = sid;
    this._studentService.getById(sid).subscribe((response: any) => {
      this.sid = response.sid;
      this.sname = response.sname;
      this.sdept = response.sdept;
      this.sloc = response.sloc;
    })

  }

  delete_student(sid: number) {
    // alert("Do you want to delete?")
    if (confirm('Do you really want to delete?')) {
      this._studentService.deleteStudent(sid).subscribe((response: any) => {
        this.getAllStudents();
      })
    }
  }

  update_student(sid: number) {
    let studentObj: any = {};
    studentObj.sid = this.sid;
    studentObj.sname = this.sname;
    studentObj.sdept = this.sdept;
    studentObj.sloc = this.sloc;

    console.log(studentObj);

    this._studentService.updateStudent(studentObj).subscribe((response: any) => {
      alert("student details are updated to the databse.");
      this.getAllStudents();
    })
  }

  handleClear() {
    this.sname = "";
    this.sdept = "";
    this.sloc = "";
  }

  getData1_click()
  {
    this._studentService.getStudentsByCity("Nellore").subscribe(response =>
      {
        console.log(response);
        this.result = response;
      });
  }

  getData2_click()
  {
    this._studentService.getStudentNames().subscribe(resData =>
      {
        this.result = resData;
      });
  }

  getData3_click()
  {
      this._studentService.getStudentsByBranchExcludingEEE().subscribe(resData =>
      {
        this.result = resData;
      });
  }

}
