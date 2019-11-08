import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
show:boolean=false;
hide:boolean=false;
  constructor( private router: Router ) { 

    const userid= localStorage.getItem('dataSource');
    if(userid!= null ){
    this.show = false;
    }
  else{
this.show=true;

  }
  }

  ngOnInit() {
  }


  logOut() {
    localStorage.clear();
    this.router.navigate(['userlogin']);  }


}
