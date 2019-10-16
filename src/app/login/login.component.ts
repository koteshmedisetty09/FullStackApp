import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, FormArray} from '@angular/forms';
import { Router} from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserService } from '../usermodule/user.service';
import { User } from 'src/app/User';

@Component({

  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 


  user: User = new User();
  submitted = false;
  


  constructor(private fb: FormBuilder,private userService: UserService, private router: Router) { }
   
  newuserForm: FormGroup;

  validationMessages = { 
    fullName: {
      required: 'Full Name is required.',
      minlength: 'Full Name must be greater than 2 characters.',
      maxlength: 'Full Name must be less than 10 characters.'
    },
    username: {
      required: 'user Name is required.',
      minlength: 'user Name must be greater than 2 characters.',
    },


    password: {
      required: 'password is required.',
      minlength: 'password must be greater than 6 characters.',
    }

    };

    formErrors = {
      fullName: '',
      username:'',
      password:''
     
    };
  







  ngOnInit() {
      this.newuserForm = this.fb.group({
        fullName: ['', [Validators.required,
          Validators.minLength(2), Validators.maxLength(10)]],

          username: ['', [Validators.required,
            Validators.minLength(2)]],

            password: ['', [Validators.required,
              Validators.minLength(6)]],
  
      });    
  }

  
  newuser(): void {
   this.submitted = false;
  // this.router.navigate(['/userlogin']);

 }

  

  passwordvalidation(formcontrol) {
     if (formcontrol.value.length < 5) {
        return {password : true};
     } 
  }

  logValidationErrors(group: FormGroup =this.newuserForm): void {
 
    Object.keys(group.controls).forEach((key: string) => {
      
      const abstractControl = group.get(key);
     
      if (abstractControl instanceof FormGroup) {
        this.logValidationErrors(abstractControl);
       
      } else {
        
        this.formErrors[key] = '';
        if (abstractControl && !abstractControl.valid && (abstractControl.touched || abstractControl.dirty))   {
         
          const messages = this.validationMessages[key];
         
          for (const errorKey in abstractControl.errors) {
            if (errorKey) {
              this.formErrors[key] += messages[errorKey] + ' ';
            }
          }
        }
  
  
        if (abstractControl instanceof FormGroup) {
          this.logValidationErrors(abstractControl);
        }
    
        
        if (abstractControl instanceof FormArray) {
          for (const control of abstractControl.controls) {
            if (control instanceof FormGroup) {
              this.logValidationErrors(control);
            }
          }
        }
  
      }
    });
  }



onClickSubmit() {
   this.save();
   alert('Reguister Successful');
   this.router.navigate(['userlogin']);
   
  }


save() {
   this.userService.createUser(this.user)
     .subscribe(

       data => {


         console.log(data);
         this.submitted = true;


       },
       error => console.log(error));
   // this.user = new User();



 }

}
