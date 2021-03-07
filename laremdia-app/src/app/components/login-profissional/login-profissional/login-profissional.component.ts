import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Auth } from 'src/app/dto/login-profissional/auth';
import { LoginProfissionalDTO } from 'src/app/dto/login-profissional/login-profissionalDTO';
import { LoginProfissionalService } from 'src/app/services/login-profissional.service';

@Component({
  selector: 'app-login-profissional',
  templateUrl: './login-profissional.component.html',
  styleUrls: ['./login-profissional.component.css']
})
export class LoginProfissionalComponent {

  constructor(
    private router: Router,
    private loginProfissionalService: LoginProfissionalService
    ) { }

  email: string;
  senha: string;
  loginError: boolean;
  mensagemSucesso: string;

  onSubmit(){
    console.log(`Email: ${this.email}, Senha: ${this.senha}`);    
  }

  incluir(){
    const loginProfissionalDTO: LoginProfissionalDTO = new LoginProfissionalDTO();
    loginProfissionalDTO.email = this.email;
    loginProfissionalDTO.senha = this.senha;
    this.loginProfissionalService.incluir(loginProfissionalDTO)
    .subscribe( response => {
      this.mensagemSucesso = "Cadastro realizado com sucesso! Efetue login";
      this.loginError = false;
    }, error => {
      this.loginError = true;
      this.mensagemSucesso = null;
    })

  }

 

}
