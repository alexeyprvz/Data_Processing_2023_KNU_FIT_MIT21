import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Entity } from '../interfaces/entity';
import { Observable } from 'rxjs/internal/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  list = new BehaviorSubject<Entity[]>([]);

  url:string="http://localhost:6080/back-end/api/granades";

  constructor(private http:HttpClient) { }

  getEnteties():Observable<Entity[]>{
    return this.http.get<Entity[]>(this.url + "/get");
  }

  postEntity(ent:Entity):Observable<Entity[]>{
    return this.http.post<Entity[]>(this.url + "/post", ent);
  }

  putEntity(ent:Entity):Observable<Entity[]>{
    return this.http.put<Entity[]>(this.url + "/update" + `/${ent.id}`, ent);
  }

  deleteEntity(ent:Entity):Observable<Entity[]>{
    return this.http.delete<Entity[]>(this.url + "/delete" + `/${ent.id}`);
  }

  setList(list:Entity[]){
    this.list.next(list);
  }


  // doPut(name: Object, img: Object, type: Object, weight: Object){
  //   this.http.put(this.url + "?name="+name+"&img="+img+".jpg&type="+type+"&weight="+weight, weight).subscribe(
  //     data => { console.log(data)}
  //   )
  // }
}
