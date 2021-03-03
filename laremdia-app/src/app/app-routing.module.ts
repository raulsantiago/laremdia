import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginProfissionalComponent } from './components/login-profissional/login-profissional.component';

const routes: Routes = [
  { path: 'loginprofissional', component: LoginProfissionalComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
