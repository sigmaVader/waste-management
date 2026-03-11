import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { LoginService } from './login.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,
    RouterLink
  ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  
  emailAddress: string = '';
  password: string = '';
  message: string='';

  constructor(



      private loginService:LoginService,
      private router:Router
  ){

   

  }




  loginUser() {
    

    const user={

      emailAddress: this.emailAddress,
      password:this.password


    };

    this.loginService.login(user).subscribe({

       next: (response)=>{

        this.message = response.toString();
        alert(response)

        if(response == 'User successfully logged in'){

          this.router.navigate(['/dashbord']);


        }

        


       },
       error: (error) =>{
        console.log(error)
           this.message = 'login failed';
       }

    })


  }

}