import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/Usuario';
import * as myGlobals from '../variables/globals'

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http:HttpClient) { 
  }

  public crearUsuario(usuario) {
    console.log(usuario);
    return this.http.post<Usuario>(myGlobals.url+"/crear/usuario/rest", usuario, httpOptions);
  }
  public getSesion(){
    return this.http.get<Usuario>(myGlobals.url+"/get/session")
  }
  public deleteUsuario(idUsuario){
    
    var urlendpoint = myGlobals.url+"/eliminar/usuario/rest/"+idUsuario;
    console.log(urlendpoint);
    return this.http.delete(urlendpoint);
  }

  public getUsuario(/*idUsuario*/) {
    return this.http.get<Usuario>(myGlobals.url+"/get/session");
  } 

  public getPerfiles(idUsuario) {
    return this.http.get<Usuario[]>(myGlobals.url+"/listar/posiblesMatches/rest/"+idUsuario);
  } 
}


