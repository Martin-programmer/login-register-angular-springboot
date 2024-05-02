import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})

export class RegisterComponent {
  employeeName: String = "";
  email: String = "";
  password: String = "";

  constructor(private http: HttpClient, private router: Router)
  {

  }

  save(){
    let bodyData = {
      "employeeName": this.employeeName,
      "email": this.email,
      "password": this.password
    };
    this.http.post("http://localhost:8080/api/v1/employee/save",bodyData,{responseType: 'text'}).subscribe((resultData: any) =>
    {
      console.log(resultData);
      alert("Employee Registred Successfully");
      this.router.navigateByUrl("/welcome");
    });
  }

}
