import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url: string = environment.url;
  api: string = '/loginprofissional';

  constructor(private http: HttpClient) { }

  

}
