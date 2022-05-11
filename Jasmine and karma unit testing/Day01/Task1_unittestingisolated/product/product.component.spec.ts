import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { ProductComponent } from './product.component';

describe('ProductComponent', () => {
  let component: ProductComponent;
  let fixture: ComponentFixture<ProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductComponent ],
      imports: [FormsModule]

    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

    //default test case

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // default quantity should be 1
  it('should default quantity to be 1', () => {
    const qty: number = component.quantity;
    expect(qty).toBe(1);
  });

  it('should result contains empty', () => {
    let messageObj = fixture.nativeElement.querySelector('span');
    expect(messageObj.textContent).toBe('');
  });

   //result method by calling method  getTotalAmount()
   it('should result contains "Total Amount : 110"', () => {
    component.unitprice = 55;
    component.quantity = 2;
    component.getTotalAmount();
    const strOutput: string = component.totalAmount;
    //console.log(component.totalAmount)
    expect(strOutput).toBe("Total Amount : 110");
  });

//result method by calling method  getTotalAmount()
it('should result contains "Total Amount : NaN"', () => {
  component.unitprice = 556;
  component.quantity = "fdg";
  component.getTotalAmount();
  const strOutput: string = component.totalAmount;
 // console.log(component.totalAmount)
  expect(strOutput).toBe("Total Amount : NaN");
});

//check Quantity is updating
it('should set the Quantity to 9 in textbox', () => {

  let inputArray = fixture.nativeElement.querySelectorAll('input');
  inputArray[2].value = 9;
  inputArray[2].dispatchEvent(new Event('input'));
  expect(component.quantity).toBe('9');
});

it('should set the Unit price to 6 in textbox', () => {

  let inputArray = fixture.nativeElement.querySelectorAll('input');

  inputArray[1].value = 6;
  inputArray[1].dispatchEvent(new Event('input'));
  expect(component.unitprice).toBe('6');
});

it('should display message in span "Total Amount : 36"', () => {

  const inputArray = fixture.nativeElement.querySelectorAll("input");

  inputArray[0].value = 'mobile';
  inputArray[0].dispatchEvent(new Event('input'));

  inputArray[1].value = 12;
  inputArray[1].dispatchEvent(new Event('input'));


  inputArray[2].value = 3;
  inputArray[2].dispatchEvent(new Event('input'));

  let inputObj = fixture.nativeElement.querySelector('button');
  inputObj.dispatchEvent(new Event('click'));

  fixture.detectChanges();

  let parObj = fixture.nativeElement.querySelector('span');
  expect(parObj.textContent).toBe("Total Amount : 36");


});

});
