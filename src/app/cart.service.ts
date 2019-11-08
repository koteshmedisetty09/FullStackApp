
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cart } from './Cart';
@Injectable({
  providedIn: 'root'
})
export class CartService {

  private baseUrl = 'http://localhost:9097/api/cart';

  constructor(private http: HttpClient) { }



    createCart(item: any, userid: any  ) : Observable<any> {
      console.log('in cart service');
      console.log(item);
      console.log(userid);

      const bob: Person = {
        userid, itemlist: item
    };

      return this.http.post(this.baseUrl, bob  );
   }






  // createCart(item: any ) : Observable<any> {
  //   console.log('in cart service');
  //   console.log(item);

  //   return this.http.post(this.baseUrl, item );
  // }




    // tslint:disable-next-line: variable-name
    deleteCartItem(id: number): Observable<any> {
      console.log('indelete cart');
      console.log(id);

      return this.http.delete(`${this.baseUrl}/${id}`);
    }


  // tslint:disable-next-line: variable-name
  getAllCartitems(userid: any): Observable<any> {
    console.log(userid);
    return this.http.get(`${this.baseUrl}/${userid}`);
   // return this.http.get(this.baseUrl, userid);

}






}
class Person {
  userid: number;
  itemlist: any;
}