import { Injectable } from '@angular/core';
//import { HttpClient } from 'selenium-webdriver/http';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private baseUrl = 'http://localhost:9097/api/address';

  constructor(private http: HttpClient) { }

  

  createAddress(address: any , userid: any ): Observable<any> {
    console.log('inside creation of address');
    console.log(address);
    console.log(userid);
    const bob: Person = {
      userid, AddressList: address
    
  };
  
    return this.http.post(this.baseUrl, bob  );
 }
 getAllAddress(userid: any): Observable<any> {
  console.log(userid);
  return this.http.get(`${this.baseUrl}/${userid}`);

  // return this.http.get(this.baseUrl, userid);

}


deleteAddress(addressid: number): Observable<any> {
  console.log('indelete ADDREWSS');
  console.log(addressid);        
       
  return this.http.delete(`${this.baseUrl}/${addressid}`);
}
  
}




class Person {
  userid: number;
  AddressList: any;
}
