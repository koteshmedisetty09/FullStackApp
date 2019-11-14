import { Component, OnInit, Input } from '@angular/core';
import { Items } from '../Items';
import { Cart } from '../Cart';
import { CartService } from '../cart.service';
import { Router, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import { AddressService } from '../address.service';
import { Observable } from 'rxjs';
//import { Address, Address } from 'FullStackApp/src/app/Address';
import { Address } from '../Address';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})

export class CartListComponent implements OnInit {


  address: Address[];

  previewPhoto: boolean;
  cart: Cart[];


  show: boolean ;
total = 0;
  items: any;
// userid: number;
// tslint:disable-next-line: variable-name
_address: Address = new Address();

  constructor(private cartService: CartService ,  private addressService: AddressService, private router: Router ) {
    const user = localStorage.getItem('dataSource');
    // tslint:disable-next-line: radix
    const userid = parseInt(user);
    this.getAllItems(userid);
    this.getAllAddress(userid);
    
  }





  ngOnInit() {
this.show = true;
  }

  getAllItems(userid) {
  this.cartService.getAllCartitems(userid).subscribe(cartlist => {
    this.cart = cartlist;
    this.cart.forEach(item => {
      console.log(item);
      this.total = this.total + item.price;
      console.log(this.total);
    });
    return this.total;
  });
}
  getAllAddress(userid) {

  this.addressService.getAllAddress(userid).subscribe(cartlist => {
    // tslint:disable-next-line: no-debugger
    debugger;
    this.address = cartlist;

    console.log(this.address);
    });
}

//   reloadData() {
//     const user= localStorage.getItem('dataSource');
// const userid=parseInt(user);
// console.log(this.items);
//     this.cartService.getAllCartitems(userid).subscribe(
//       (cartlist) => this.cart = cartlist,


//  //this.total= this.countTotal(),

//  (err) => console.log(err)

//  );

//   }


reloadData(userid) {


this.addressService.getAllAddress(userid).subscribe(cartlist => {
  this.address = cartlist;

  console.log(this.address);
  });


this.cartService.getAllCartitems(userid).subscribe(cartlist => {
    this.cart = cartlist;
    this.cart.forEach(item => {
      console.log(item);
      this.total = this.total + item.price;
      console.log(this.total);
    });
    return this.total;
  });
// this.cartService.getAllCartitems(userid).subscribe(cartlist => {
//     this.cart = cartlist;

//     this.cart.forEach(item => {
//       console.log(item);

//       this.total = this.total + item.price;
//       console.log(this.total);
//     });
//     return this.total;
//   });
}





setPrimary(addressid: number) {


  
  console.log('successfully address was set');
  
  
  console.log(addressid);

  this.addressService.updatePrimary(this._address,addressid) 
      .subscribe(
        data => {
          alert('changed preference successfully');
          console.log(data);
          console.log('in updation lag')

        }, 
        error => console.log(error));

} 
  

  togglePhotoPreview() {
    this.previewPhoto = !this.previewPhoto;
  }



  buyNow() {
    const userid = localStorage.getItem('dataSource');


    this.router.navigate(['cart/cartaddress/', userid]);


  }
  checkOut() {
  alert('Thank You For Shopping with us');
  }

  addmoreItems() {


    const id = localStorage.getItem('dataSource');
    this.router.navigate(['/findbyitemname', id]);

  }




  // tslint:disable-next-line: variable-name
  removeCart(cart_id: number) {
    const user = localStorage.getItem('dataSource');
    // tslint:disable-next-line: radix
    const userid = parseInt(user);
    console.log(cart_id);

    this.cartService.deleteCartItem(cart_id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData(userid);

        },
        error => console.log(error));
  }

  removeAddress(addressid: number) {
    console.log(addressid);
    const user = localStorage.getItem('dataSource');
    const userid = parseInt(user);

    this.addressService.deleteAddress(addressid)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData(userid);

        },
        error => console.log(error));


  }



  // tslint:disable-next-line: variable-name

}
