import {Pipe, PipeTransform} from '@angular/core';
import {isNull, isNullOrUndefined} from 'util';

@Pipe({
  name: 'filter',
  pure: false
})
export class FilterPipe implements PipeTransform {

  transform(array: any[], queryString: string) {

    if (isNullOrUndefined(array)) {
      return array;
    }

    const regEx = new RegExp(queryString, 'gi');

    return array.filter(element => {
        for (const property in element) {
          if (!isNullOrUndefined(element[property]) && regEx.test(element[property].toString())) {
            return true;
          }
        }
      }
    );
  }

}
