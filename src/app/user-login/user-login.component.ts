import { Component, OnInit } from '@angular/core';
// import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { first } from 'rxjs/operators';
import { AlertService } from '../alert-service.service';
import { AuthenticationService } from '../authentication-service.service';

import { User } from 'src/app/User';
import { UserService } from '../usermodule/user.service';
import { invalid } from '@angular/compiler/src/render3/view/util';


// import { AlertService, AuthenticationService } from '../_services';

@Component({

 selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  formdata;

  user: User = new User();
  // submitted: boolean;

   submitted = false;
   returnUrl: string;
list: any = [];
  // tslint:disable-next-line: max-line-length
  constructor( private formBuilder: FormBuilder, private userService: UserService, private route: ActivatedRoute, private router: Router) { }
  ngOnInit() {
   this.formdata = this.formBuilder.group ({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });

  // reset login status
  // this.userService.logout();

  // get return url from route parameters or default to '/'
  // this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
  }
  passwordvalidation(formcontrol) {
     if (formcontrol.value.length < 5) {
        return {password : true};
     }
  }


  onClickRegister() {
    this.router.navigate(['login']);

  }
  onClickAdmin() {
    this.router.navigate(['adminlogin']);

  }


  get User() { return this.formdata.controls; }

  onClickUserSubmit() { this.submitted = true;

   // stop here if form is invalid
                        if (this.formdata.invalid) {
                                         return;
                                                     }

  // this.loading = true;
                        this.userService.login(this.user.username , this.user.password)

       .subscribe(
           data => {
            console.log(data);

            const id = data.userid;

            localStorage.setItem('dataSource', id);

            console.log('ids' + id);
            if (data == null && data == undefined  )      {

              alert('invalid credentials');

            }

            else {
              console.log(data);
              this.router.navigate(['/findbyitemname', id]);

            }

           },
           error => console.log(error))
                        

}
}



