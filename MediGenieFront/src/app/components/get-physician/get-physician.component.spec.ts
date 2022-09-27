import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPhysicianComponent } from './get-physician.component';

describe('GetPhysicianComponent', () => {
  let component: GetPhysicianComponent;
  let fixture: ComponentFixture<GetPhysicianComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPhysicianComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPhysicianComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
