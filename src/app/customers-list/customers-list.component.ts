import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
//import { BrowserAnimations } from '@angular/platform-browser/animations';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
import { CustomerDetailsComponent } from '../customer-details/customer-details.component';
import {
  trigger,
  state, 
  style,
  animate,
  transition
} from '@angular/animations';




@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css'],
  animations: [
    trigger('buttonTextStateTrigger', [
      state('shown', style({
        opacity: 1
      })),
      state('transitioning', style({
        opacity: 0.3
      })),
      transition('shown => transitioning', animate('600ms ease-out')),
      transition('transitioning => shown', animate('600ms ease-in'))
    ])
  ]
})
export class CustomersListComponent implements OnInit {
  //buttonTextState:any;

// The current state of the button text
buttonTextState = 'shown';
// The text currently being show
buttonText = "ADD TO CART";
// The text that will be shown when the transition is finished
transitionButtonText = "ADD TO CART";



  customers: Observable<Customer[]>;
 
  @Input() customer: Customer;
  _router: any;


  constructor(private customerService: CustomerService ) { }

  ngOnInit() {
    this.reloadData();
    

  }


  updateActive(isActive: boolean, id: any , name: string  ) {
    this.customerService.updateCustomer(id, name)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  editButtonClick(id: any, value: any){

  
    this.customerService.editCustomer(id,value).subscribe(
    data =>{
      console.log(data);
      this.reloadData();
    }  
    );
  }


  deleteCustomers() {
    this.customerService.deleteAll()
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  deleteCustomer(id:any) {
    
    this.customerService.deleteCustomer(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }



  reloadData() {


  
    
  //  this.customers = this.customerService.getCustomersList();

  this.customerService.getCustomersList()
  .subscribe(
    customers =>{ this.customers=customers;
      console.log(this.customers);

    },
  );





  }





    
  
    /**
     * Respond to the transition event of the button text
     * by setting the text awaiting transition then setting the state as shown
     */
    buttonTextTransitioned(event) {
      this.buttonText = this.transitionButtonText;
      this.buttonTextState = this.buttonTextState = 'shown';
    }
  
    onAddToCart() {
      // Kick off the first transition
      this.buttonTextState = 'transitioning';
      this.transitionButtonText = 'ADDING...';
  
      // Do whatever logic here. If it is asynchronous, put the remaining code in your subscribe/then callbacks
      // Note if your logic is snappy, you could leave the timeouts in to simulate the animation for a better UX
  
      setTimeout(() => {
        this.buttonTextState = 'transitioning';
        this.transitionButtonText = 'ADDED';
      }, 1800);
  
      // Reset button text
      setTimeout(() => {
        this.buttonTextState = 'transitioning';
        this.transitionButtonText = 'ADD TO CART';
      }, 3600);
    }

}
