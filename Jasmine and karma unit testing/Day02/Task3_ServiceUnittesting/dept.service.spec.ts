import { TestBed } from '@angular/core/testing';

import { DeptService } from './dept.service';

describe('DeptService', () => {
  let service: DeptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should maintain default state', () => {
    let deptsArray:any[] = [
      {"deptid":10 , "deptname":"HR"},
      {"deptid":20 , "deptname":"Development"},
      {"deptid":30 , "deptname":"BA"},
      {"deptid":40 , "deptname":"QA"}
    ];
    
    expect(service.deptsArray).toEqual(deptsArray);
  });

  it('should perform addition of department operation', () => {
    let deptObj:any = {"deptid":50 , "deptname":"SM"};
    //let deptObj2:any = {"deptid":60 , "deptname":"SM"};
    service.addDept(deptObj);
    expect(service.deptsArray.find((item)=> item.deptid == deptObj["deptid"] && item.deptname == deptObj["deptname"])).toEqual(deptObj);
  });

  it('should not perform deletion of department operation with invalid department number', () => {
    //let deptNo = 101;
    let beforeLength = service.deptsArray.length;
    service.removeDept(1000);
    let afterLength = service.deptsArray.length;
    
    expect(beforeLength == afterLength).toEqual(true);
  });

  it('should perform deletion of department operation with valid department number', () => {
    let deptNo = 10;
    //let deptObj2:any = {"deptid":60 , "deptname":"SM"};
    let beforeLength = service.deptsArray.length;
    service.removeDept(deptNo);
    let afterLength = service.deptsArray.length;
    expect(beforeLength > afterLength).toEqual(true);
  });

  

});