import { Component } from '@angular/core';
import { LoginProfissionalDTO } from 'src/app/dto/login-profissional/login-profissionalDTO';
import { LoginProfissionalService } from 'src/app/services/login-profissional.service';

@Component({
  selector: 'app-login-profissional',
  templateUrl: './login-profissional.component.html',
  styleUrls: ['./login-profissional.component.css']
})
export class LoginProfissionalComponent {

  constructor(private service: LoginProfissionalService) { }

  userEmail: string;
  password: string;
  loginError: boolean;

  onSubmit(){
    console.log(`Email: ${this.userEmail}, Senha: ${this.password}`);    
  }

 

}
