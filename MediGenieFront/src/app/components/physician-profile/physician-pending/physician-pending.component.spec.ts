import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PhysicianPendingComponent } from './physician-pending.component';

describe('PhysicianPendingComponent', () => {
  let component: PhysicianPendingComponent;
  let fixture: ComponentFixture<PhysicianPendingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PhysicianPendingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PhysicianPendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
