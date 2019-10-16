import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
//import { UserLoginComponent } from './user-login/user-login.component';
//import { LoginComponent } from './login/login.component';

const routes: Routes = [

 
  //{ path: '', component: LoginComponent }

];
  
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsermoduleRoutingModule { }
