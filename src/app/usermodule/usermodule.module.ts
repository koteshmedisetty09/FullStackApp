import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//import { LoginComponent } from './usermodule/login/login.component';
//import { UserLoginComponent } from './usermodule/user-login/user-login.component';
//import { UsermoduleRoutingModule } from './usermodule-routing.module';
//import { LoginComponent } from './login/login.component';
//import { UserLoginComponent } from './user-login/user-login.component';
import { UsermoduleRoutingModule } from './usermodule-routing.module';
import { ListItemsComponent } from './list-items.component';
// import { ValidateUserModule } from './usermodule/validate-user.component'
// import { LoginUserComponent } from './login-user/login-user.component';
// import {ValidateUserComponent} from './usermodule/validate-user.component';
@NgModule({
  declarations: [ListItemsComponent],  
  imports: [   
    CommonModule,
 //  LoginComponent,
 //  UserLoginComponent,
   UsermoduleRoutingModule,
 //   ValidateUserModule
  ]
})
export class UsermoduleModule { }
     