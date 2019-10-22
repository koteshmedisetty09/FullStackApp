import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
      ) { }

    ngOnInit() {
        // reset login status

   
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
    }

    login() {
        this.loading = true;
        // tslint:disable-next-line: triple-equals
        if (this.model.username == 'kotesh' &&  this.model.password   =='kotesh123'   ) {

          alert('Valid admin')
          this.router.navigate(['add']);

        }
        else{

          alert('Invalid User')
        }
      }


      onClickadminLogin(){

        this.router.navigate(['add']);      }
}
