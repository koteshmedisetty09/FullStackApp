import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CustomersListComponent } from './customers-list/customers-list.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { SearchCustomersComponent } from './search-customers/search-customers.component';
import { LoginComponent } from './login/login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { CartListComponent } from './cart-list/cart-list.component';
//import { CartDetailsComponent } from './search-customers/cart-details.component';

const routes: Routes = [    

 { path: '', redirectTo: 'userlogin', pathMatch: 'full' },
 { path: 'userlogin', component: UserLoginComponent },

    
 { path: 'login', component: LoginComponent },
//{ path: '', loadChildren: './usermodule/Usermodule.module#UsermoduleModule' },

 { path: 'customer', component: CustomersListComponent },
  { path: 'add', component: CreateCustomerComponent },
  { path: 'findbyitemname/:userid', component: SearchCustomersComponent },
  { path: 'findbyitemname', component: SearchCustomersComponent },

  { path: 'cart', component: CartListComponent },
  { path: 'cart/:userid', component: CartListComponent },


  { path: 'edit/:id', component: CreateCustomerComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
