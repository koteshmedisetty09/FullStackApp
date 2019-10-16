import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})  
export class CustomerService {

    
  private baseUrl = 'http://localhost:9097/api/customers';

  private baseUrl2 = 'http://localhost:9097/api/items';


  constructor(private http: HttpClient) { }

  getCustomer(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCustomer(customer: any): Observable<any> {
    return this.http.post(this.baseUrl, customer);
  }

  updateCustomer(id: number, Name: string): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, Name);
  }



  // editCustomer(id : number,Name: string): Observable <any>{
  //   return this.http.put(`${this.baseUrl}/${id}`,Name);

  // }



  editCustomer(id: number, value: any): Observable<any> {
  
    return this.http.put(`${this.baseUrl}/${id}`, value );
}
  handleError(handleError: any): import("rxjs").OperatorFunction<void, any> {
    throw new Error("Method not implemented.");
  }
 


  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getCustomersList(): Observable<any> {

  
    return this.http.get(this.baseUrl);
  } 

  getCustomersByAge(age: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/age/${age}`);
  }
  getItemsByCompanyName(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/items/${name}`);
  }


  getItemsList(): Observable<any> {

  
    return this.http.get(this.baseUrl2);
  } 




  deleteAll(): Observable<any> {
    return this.http.delete(this.baseUrl);
  }
}
