import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  url:string="http://localhost:8080/servlet";

  constructor(private http:HttpClient) { }

  getEnteties():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url);
  }

  doPut(name: Object, img: Object, type: Object, weight: Object){
    this.http.put(this.url + "?name="+name+"&img="+img+".jpg&type="+type+"&weight="+weight, weight).subscribe(
      data => { console.log(data)}
    )
  }
}
