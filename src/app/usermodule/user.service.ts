// import { Injectable } from '@angular/core';


 


import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { Customer } from './customer';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // tslint:disable-next-line: no-unused-expression
  
  
  private baseUrl = 'http://localhost:9097/api/user';

  constructor(private http: HttpClient) { }
   
     
  
  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createUser(user: any): Observable<any> {
    console.log('sdfdfs');
    console.log(user);
    return this.http.post(this.baseUrl, user);
  }

  login(username: string, password: string) {
    console.log(username);
    return this.http.get(`${this.baseUrl}/${username}/${password}`);
      
      } 
      

 

      logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
 


}
