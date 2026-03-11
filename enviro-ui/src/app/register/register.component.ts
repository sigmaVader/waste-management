import { Component } from '@angular/core';
import { RegisterService } from './register.service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  emailAddress: string = '';
  name: string = '';
  password: string = '';
  message: string = '';

  constructor(
    private registerService: RegisterService,
    private router: Router
  ) {}

  registerUser() {
    const user = {
      name: this.name,
      emailAddress: this.emailAddress,
      password: this.password
    };

    this.registerService.register(user).subscribe({
      next: (response) => {
        this.message = response;
        alert(response);
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error(error);
        this.message = 'Registration failed';
      }
    });
  }
}