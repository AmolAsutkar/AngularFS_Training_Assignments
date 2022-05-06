import { Directive, ElementRef, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[appShadow]'
})
export class ShadowDirective {

  @Input()
  appShadow:string  = "";

  constructor(private _element:ElementRef) {

   }

  ngOnInit(): void {
    if(this.appShadow == ""){
      this.appShadow = "red";
    }
    this._element.nativeElement.style.color = this.appShadow;
  }

}
