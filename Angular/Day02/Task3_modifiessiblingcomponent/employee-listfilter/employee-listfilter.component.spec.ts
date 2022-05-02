import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListfilterComponent } from './employee-listfilter.component';

describe('EmployeeListfilterComponent', () => {
  let component: EmployeeListfilterComponent;
  let fixture: ComponentFixture<EmployeeListfilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListfilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListfilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
