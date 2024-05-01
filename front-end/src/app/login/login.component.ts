import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  email: String = "";
  password: String = "";

  constructor(private router: Router, private http: HttpClient)
  {

  }

  login(){
    let bodyData = {
      "email": this.email,
      "password": this.password
    };
    this.http.post("http://localhost:8080/api/v1/employee/login", bodyData, {responseType: 'json'}).subscribe((resultData: any) => {
      console.log(resultData);
      if(resultData.message == "Email not exits") {
        alert("Email not exists");
      } else if(resultData.message == "Login Success") {
        this.router.navigateByUrl("/home");
      } else {
        alert("Incorrect Email and Password not match");
      }
    });
    
  }
}
