import { Directive, OnChanges,Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appCustom]'
})
export class CustomDirective {

  

  @Input()
  appCustom: string = '';

  constructor(private viewContainer: ViewContainerRef,
    private templateRef: TemplateRef<any>) { }


  ngOnChanges() {

    if (this.appCustom.toLocaleLowerCase() != 'sam') {
     
      this.viewContainer.createEmbeddedView(this.templateRef);
    }
    else {
      
      this.viewContainer.clear();
    }
  }

}
