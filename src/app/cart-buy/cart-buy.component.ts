import { Component, OnInit } from '@angular/core';
import { CartService } from 'FullStackApp/src/app/cart.service';
import { AddressService } from '../address.service';
import { Router } from '@angular/router';
import { Cart } from 'FullStackApp/src/app/Cart';
import { Address } from 'cluster';

@Component({
  selector: 'app-cart-buy',
  templateUrl: './cart-buy.component.html',
  styleUrls: ['./cart-buy.component.css']
})
export class CartBuyComponent implements OnInit {

  address: Address[];
  
  previewPhoto: boolean;
  cart: Cart[];


  
total: number =0;
  items: any;
//userid: number;



  constructor(private cartService: CartService ,  private addressService: AddressService, private router: Router ) { }
  ngOnInit() {



    const user = localStorage.getItem('dataSource');
    // tslint:disable-next-line: radix
    const userid =parseInt(user);
    
    
    
    
    
   
    
    this.cartService.getAllCartitems(userid).subscribe(cartlist => {
      this.cart = cartlist;
     // let id=items.userid;
     // console.log("cart-ids"+id);
      this.cart.forEach(item => {
        console.log(item);
       
        this.total = this.total + item.price;
        console.log(this.total);
      });
      return this.total;
    });
    
    
    
    
    this.addressService.getAllAddress(userid).subscribe(cartlist => {
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
    
    
    reloadData() {
    
     
    const user = localStorage.getItem('dataSource');
    // tslint:disable-next-line: radix
    const userid =parseInt(user);
    
    
    this.addressService.getAllAddress(userid).subscribe(cartlist => {
      this.address = cartlist;
     
      console.log(this.address);
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
    
    
    
    
    
    setPrimary(){
      
    }
    
    
      togglePhotoPreview() {
        this.previewPhoto = !this.previewPhoto;
      }
    
      
    
      buyNow() {
        const userid= localStorage.getItem('dataSource');
        alert('Thank you for Shopping with us');
       
        this.router.navigate(['cart/cartaddress/', userid]);
      
    
      }
    
      addmoreItems() {
       
    
        const id=localStorage.getItem('dataSource');
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
      
      removeAddress(addressid : number){
        console.log(addressid);
        
        this.addressService.deleteAddress(addressid)
          .subscribe(
            data => {
              console.log(data);
              this.reloadData();
    
            },
            error => console.log(error));
    
    
      }
    
      
    
      // tslint:disable-next-line: variable-name
    
    }
    