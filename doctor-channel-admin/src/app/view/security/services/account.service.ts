import {Injectable} from '@angular/core';
import {User} from '../model/model.user';
import {AppSettings} from '../../../settings/app-settings';
import {HttpClient} from '../../../../../node_modules/@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  constructor(private http: HttpClient) {
  }

  public createAccount(user: User): Observable<any> {
    return this.http.post<any>(AppSettings.API_ENDPOINT + '/account/register', user);
  }
}
