import { Component, OnInit } from '@angular/core';
import { LoginProfissionalService } from 'src/app/services/login-profissional.service';
import { LoginProfissionalDTO } from 'src/app/dto/login-profissional/login-profissionalDTO';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gerenciar-login-profissional',
  templateUrl: './gerenciar-login-profissional.component.html',
  styleUrls: ['./gerenciar-login-profissional.component.css']
})
export class GerenciarLoginProfissionalComponent implements OnInit {
  
  constructor(
    private router: Router,
    private loginProfissionalService: LoginProfissionalService
    ) { }

  nome: string;
  cpf: string;
  email: string;
  celular: string;
  senha: string;
  foto: any; 
  ativo: boolean;

  loginError: boolean;
  mensagemSucesso: boolean = false;
  loginProfissionalDTO: LoginProfissionalDTO;

  ngOnInit(): void {
  }

  incluir(){
    const loginProfissionalDTO: LoginProfissionalDTO = new LoginProfissionalDTO();
    loginProfissionalDTO.email = this.email;
    loginProfissionalDTO.senha = this.senha;
    loginProfissionalDTO.ativo = this.ativo;    
    loginProfissionalDTO.celular = this.celular;
    loginProfissionalDTO.cpf = this.cpf;
    loginProfissionalDTO.nome = this.nome;
    loginProfissionalDTO.foto = null;
    this.loginProfissionalService.incluir(loginProfissionalDTO)
    .subscribe( response => {
      this.mensagemSucesso = true;
    }, error => {      
      this.mensagemSucesso = false;
    })

  }



  // uploadFoto(event, loginProfissionalDTO){
  //   const files = event.target.files;
  //   if(files){
  //     const foto = files[0];
  //     const formData: FormData = new FormData();
  //     formData.append("foto", foto);
  //     this.loginProfissionalService.addFoto(loginProfissionalDTO, formData);
  //       //.subscribe(response => this.consultaid());
  //   }
  // }

}
