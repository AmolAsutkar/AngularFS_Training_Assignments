import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'salarypipe',
  pure: true

})
export class SalarypipePipe implements PipeTransform {

  transform(inputData: any[], value1: number, value2: number): any[] {
      return inputData.filter(item => item.sal >= value1 && item.sal < value2);
     }
}
