import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AddressService } from '../address.service';
import { Address } from '../Address';


@Component({
  selector: 'app-cart-address',
  templateUrl: './cart-address.component.html',
  styleUrls: ['./cart-address.component.css']
})
export class CartAddressComponent implements OnInit {
  [x: string]: any;

  address: Address[];

  _address: Address = new Address();
 constructor(private fb: FormBuilder,
             private route: ActivatedRoute,
             private addressService: AddressService,
             private router: Router) { }

employeeForm: FormGroup;

pageTitle: string;
selectedFile = null;
error: string;


validationMessages = {
  fullName: {
    required: 'Full Name is required.',
    minlength: 'Full Name must be greater than 2 characters.',
    maxlength: 'Full Name must be less than 10 characters.'
  },
 
  currentaddress: {
    required: 'address is required.',
  },
  city: {
    required: 'city is required.',
  },
  pincode: {
    required: 'Proficiency is required.',
  },
};
formErrors = {
  fullName: '',
  currentaddress: '',
  city: '',
  state: '',
  pincode: '',
  country: ''
};

  ngOnInit() {

    this.employeeForm = this.fb.group({
      fullName: ['', [Validators.required,
      Validators.minLength(2), Validators.maxLength(10)]],


      // contactPreference:['email'],
      // email: ['', [Validators.required, ]],
      // phone: [''],


      currentaddress: ['', [Validators.required ]],
  pincode: [''],

      //  location: this.fb.array([

      //    this.addLocFormGroup()
      //   ]),





       skills: this.fb.array([

         this.addSkillFormGroup()
       ]),

    });

  
    const user = localStorage.getItem('dataSource');
    // tslint:disable-next-line: radix
    const userid =parseInt(user);
    this.addressService.getAllAddress(userid).subscribe(cartlist => {
      this.address = cartlist;
     
      console.log(this.address);
      });
    

  }



  addSkillButtonClick(): void {
    (this.employeeForm.get('skills') as FormArray).push(this.addSkillFormGroup()); // pushing new form group into this form array
  }
  removeSkillButtonClick(skillGroupIndex: number): void {
    const skillsFormArray = (this.employeeForm.get('skills') as FormArray);
    skillsFormArray.removeAt(skillGroupIndex);
    skillsFormArray.markAsDirty();
    skillsFormArray.markAsTouched();

    }


    onClickSave() {

    }



  addSkillFormGroup(): FormGroup {
    console.log('hi');
    return this.fb.group({
      skillName: ['', Validators.required],
      experienceInYears: ['', Validators.required],
      proficiency: ['', Validators.required]
    });
  }


  logValidationErrors(group: FormGroup = this.employeeForm): void {

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


  onSubmit() {
    console.log('hee');
    console.log(this._address);

    this.save();


  }


  onClickPrimary(){

  }
 



  save() {

console.log(localStorage.getItem('dataSource'));
const userid = localStorage.getItem('dataSource');

this.addressService.createAddress(this._address, userid)
      .subscribe(
        (        data: any) => {
          console.log('inside angular createaddress');
          console.log(data);

        },
        (        error: any) => console.log(error));


this.router.navigate(['/cart',userid]);


  }




}
