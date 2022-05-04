import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RxjxdemoComponent } from './rxjxdemo.component';

describe('RxjxdemoComponent', () => {
  let component: RxjxdemoComponent;
  let fixture: ComponentFixture<RxjxdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RxjxdemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RxjxdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
