import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Errores } from './errores';

@Injectable({
  providedIn: 'root'
})
export class ErroresService {
  
  private urlBase = "";

  constructor(private clienteHttp: HttpClient) { }

  obtenerErrores(): Observable<Errores[]>{
    return this.clienteHttp.get<Errores[]>(this.urlBase);
    
    

  }
}
