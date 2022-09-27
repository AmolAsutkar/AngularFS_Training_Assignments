import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorsAppoinmentComponent } from './doctors-appoinment.component';

describe('DoctorsAppoinmentComponent', () => {
  let component: DoctorsAppoinmentComponent;
  let fixture: ComponentFixture<DoctorsAppoinmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoctorsAppoinmentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorsAppoinmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
