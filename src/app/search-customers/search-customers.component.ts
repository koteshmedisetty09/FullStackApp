import { Component, OnInit } from '@angular/core';

import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Items } from '../Items';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { Cart } from '../Cart';
import { User } from '../User';
import { UserService } from '../usermodule/user.service';

@Component({
  selector: 'app-search-customers',
  templateUrl: './search-customers.component.html',
  styleUrls: ['./search-customers.component.css']
})
/*
export class SearchCustomersComponent implements OnInit {

  age: number;


  customers: Customer[];

  constructor(private dataService: CustomerService) { }

  ngOnInit() {
    this.age = 0;
  }

  private searchCustomers() {
    this.customers = [];
    this.dataService.getCustomersByAge(this.age)
      .subscribe(customers => this.customers = customers);
  }

  onSubmit() {
    this.searchCustomers();
  }

}
*/


export class SearchCustomersComponent implements OnInit {
  user: User = new User();

  // age: number;
  name: string;
// userid: number;
  total: number;
   items: Items;
   cart: Cart;

  // tslint:disable-next-line: variable-name
  _router: any;
  previewPhoto: boolean;
  // itemsList: Items;

  // tslint:disable-next-line: max-line-length
  constructor(private router: Router, private userservice: UserService , private dataService: CustomerService , private cartService: CartService) { }

  ngOnInit() {
    this.name = null;
  //  this.userid = null;
    this.getData();


    //  this.userservice.login(this.user.username , this.user.password)

    //  .subscribe(
    //      data => {
    //       console.log(data);
    //      //this.list.push({"id":userid})

    //      console.log(data.userid);
    //    const id=data.userid;
    //    console.log('ids' +id);
    //       if (data== null){

    //         alert('invalid credentials');

    //       }
    //       else{
    //         console.log(data);
    //         this.router.navigate(['/findbyitemname',id]);

    //       }

    //     },
    //     error => console.log(error));






  }


  togglePhotoPreview() {
    this.previewPhoto = !this.previewPhoto;
  }


  getData() {
 //  this.customers = this.customerService.getCustomersList();

 this.dataService.getItemsList()
 // tslint:disable-next-line: deprecation
 .subscribe(
  items => {this.items = items;
            this.total = items.price;
            console.log( this.total);
            console.log(this.items);


   },
 );


 this.userservice.getUser(this.user.userid)
 // tslint:disable-next-line: deprecation
 .subscribe(
  user => {this.user = user;

           console.log( this.user);



   },
 );




  }

  private searchCustomers() {

    this.dataService.getItemsByCompanyName(this.name)
      .subscribe(items => this.items = items);
  }


  myfunction(item: any) {

console.log(localStorage.getItem('dataSource'));
const userid = localStorage.getItem('dataSource');
// console.log(userid);

console.log('hru');
this.cartService.createCart(item, userid)
      .subscribe(
        data => {
          console.log(data);
       //   this.router.navigate(['cart']);

          alert('item added to cart successfully');
        },
        error => console.log(error));
  }


  logOut() {
    localStorage.clear();
    this.router.navigate(['userlogin']);
  }



  viewCart() {
    const userid = localStorage.getItem('dataSource');
    console.log(userid);
    this.router.navigate(['/cart', userid]);
  }


  onSubmit() {
    this.searchCustomers();
  }

}