import { Component, OnInit } from '@angular/core';
import { LoginProfissionalService } from 'src/app/services/login-profissional.service';
import { LoginProfissionalDTO } from 'src/app/dto/login-profissional/login-profissionalDTO';

@Component({
  selector: 'app-gerenciar-login-profissional',
  templateUrl: './gerenciar-login-profissional.component.html',
  styleUrls: ['./gerenciar-login-profissional.component.css']
})
export class GerenciarLoginProfissionalComponent implements OnInit {

  constructor(private service: LoginProfissionalService) { }

  loginProfissionalDTO: LoginProfissionalDTO;

  ngOnInit(): void {
  }

  uploadFoto(event, loginProfissionalDTO){
    const files = event.target.files;
    if(files){
      const foto = files[0];
      const formData: FormData = new FormData();
      formData.append("foto", foto);
      this.service.addFoto(loginProfissionalDTO, formData);
        //.subscribe(response => this.consultaid());
    }
  }

}
