import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemohttpComponent } from './demohttp.component';

describe('DemohttpComponent', () => {
  let component: DemohttpComponent;
  let fixture: ComponentFixture<DemohttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemohttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemohttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
