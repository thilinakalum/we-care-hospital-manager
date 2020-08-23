import {Injectable} from '@angular/core';
import {User} from '../model/model.user';
import {AppSettings} from '../../../settings/app-settings';
import {HttpClient, HttpHeaders} from '../../../../../node_modules/@angular/common/http';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  public logIn(user: User): Observable<any> {

    // creating base64 encoded String from user name and password
    var base64Credential: string = btoa(user.username + ':' + user.password);
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept': 'application/json',
        'Authorization': 'Basic ' + base64Credential
      })
    };

    return this.http.get<any>(AppSettings.API_ENDPOINT + '/account/login', {headers: httpOptions.headers});
  }

  logOut(): Observable<any> {
    // remove user from local storage to log user out
    return this.http.post<any>(AppSettings.API_ENDPOINT + 'logout', null);
  }
}
