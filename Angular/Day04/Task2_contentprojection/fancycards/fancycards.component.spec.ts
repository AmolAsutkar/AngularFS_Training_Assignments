import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FancycardsComponent } from './fancycards.component';

describe('FancycardsComponent', () => {
  let component: FancycardsComponent;
  let fixture: ComponentFixture<FancycardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FancycardsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FancycardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
