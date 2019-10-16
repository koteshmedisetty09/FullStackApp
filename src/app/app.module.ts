import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { BrowserAnimations } from '@angular/platform-browser/animations';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { CartListComponent } from './cart-list/cart-list.component';
//import { CartDetailsComponent } from './search-customer/cart-details/cart-details.component';

    
@NgModule({ 
  declarations: [   
    AppComponent,  
   // BrowserAnimations,
    CreateCustomerComponent,
    CustomerDetailsComponent,
    CustomersListComponent,
    SearchCustomersComponent,
    HeaderComponent,
    FooterComponent,
   LoginComponent,
    UserLoginComponent,
    CartListComponent,
  //  CartDetailsComponent,

  //  MatSortModule
  ],
  imports: [
    BrowserModule, 
    AppRoutingModule,

    FormsModule,
    HttpClientModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
