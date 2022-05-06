import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VehicalformmodeldrivenComponent } from './vehicalformmodeldriven.component';

describe('VehicalformmodeldrivenComponent', () => {
  let component: VehicalformmodeldrivenComponent;
  let fixture: ComponentFixture<VehicalformmodeldrivenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VehicalformmodeldrivenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VehicalformmodeldrivenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
