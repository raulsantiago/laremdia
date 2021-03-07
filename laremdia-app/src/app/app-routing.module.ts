import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GerenciarLoginClienteComponent } from './components/login-cliente/gerenciar-login-cliente/gerenciar-login-cliente.component';
import { LoginClienteComponent } from './components/login-cliente/login-cliente/login-cliente.component';
import { GerenciarLoginProfissionalComponent } from './components/login-profissional/gerenciar-login-profissional/gerenciar-login-profissional.component';
import { LoginProfissionalComponent } from './components/login-profissional/login-profissional/login-profissional.component';

const routes: Routes = [
  { path: 'loginprofissional', component: LoginProfissionalComponent },
  { path: 'cadastroprofissional', component: GerenciarLoginProfissionalComponent },
  { path: 'logincliente', component: LoginClienteComponent },
  { path: 'cadastrocliente', component: GerenciarLoginClienteComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
