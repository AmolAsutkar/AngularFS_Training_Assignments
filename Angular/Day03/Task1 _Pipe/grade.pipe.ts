import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'grade'
})
export class GradePipe implements PipeTransform {

  transform(input:number):string
  {
     let output:string ="";
 
     if(input==5) output = "Good";
     if(input==6) output = "average";
     if(input==7) output = "very good";
     if(input==8) output = "excellent";
     if(input==9) output = "poor";

 
     return output;
  }
 
}
