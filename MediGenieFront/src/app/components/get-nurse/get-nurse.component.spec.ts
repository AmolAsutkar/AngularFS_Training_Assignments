import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetNurseComponent } from './get-nurse.component';

describe('GetNurseComponent', () => {
  let component: GetNurseComponent;
  let fixture: ComponentFixture<GetNurseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetNurseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetNurseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
