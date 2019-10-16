import { Component, OnInit, Input } from '@angular/core';
import { Items } from '../Items';
import { Cart } from '../Cart';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css']
})

export class CartListComponent implements OnInit {
 

  previewPhoto: boolean;
  cart: Cart[];


  
total: number =0;
  items: any;
//userid: number;



  constructor(private cartService: CartService , private router: Router ) { }

  ngOnInit() {
this.reloadData();
const userid = localStorage.getItem('dataSource');

this.cartService.getAllCartitems(userid).subscribe(items => {
  this.items = items;
 // let id=items.userid;
 // console.log("cart-ids"+id);
  this.items.forEach(item => {
    console.log(item);
   
    this.total = this.total + item.price; 
  });
  return this.total;
});








  }


  reloadData() {
    const userid= localStorage.getItem('dataSource');

    this.cartService.getAllCartitems(userid).subscribe(
      (cartlist) => this.cart = cartlist,

     
 // this.total= this.countTotal(),

 (err) => console.log(err)

 );

  }



  togglePhotoPreview() {
    this.previewPhoto = !this.previewPhoto;
  }



  buyNow() {
    alert('Thank you for Shopping with us');

  

  }

  logOut() {
    localStorage.clear();
    this.router.navigate(['userlogin']);  }

  addmoreItems() {
   

    let id=this.items.userid;
    this.router.navigate(['/findbyitemname', id]);

  }




  // tslint:disable-next-line: variable-name
  removeCart(cart_id: number) {
    console.log(cart_id);
    
    this.cartService.deleteCartItem(cart_id)
      .subscribe(
        data => {
          console.log(data);
      this.reloadData();

        },
        error => console.log(error));
  }



  

  // tslint:disable-next-line: variable-name

}
