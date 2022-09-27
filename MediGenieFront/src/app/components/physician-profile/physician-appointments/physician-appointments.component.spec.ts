import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicianAppointmentsComponent } from './physician-appointments.component';

describe('PhysicianAppointmentsComponent', () => {
  let component: PhysicianAppointmentsComponent;
  let fixture: ComponentFixture<PhysicianAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhysicianAppointmentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhysicianAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
