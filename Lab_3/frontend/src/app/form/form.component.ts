import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Entity } from '../interfaces/entity';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent{

  constructor(private service:ServiceService) { }

  @Input() ent?:Entity
  @Output() updated:EventEmitter<null> = new EventEmitter();

  updateEntity(){
    if(this.ent){
      this.service.putEntity(this.ent).subscribe(
        ()=>{
          this.updated.emit();
        }
      )
    }
  }

  // name:string = "";
  // img:string = "";
  // type:string = "";
  // weight:number = 0;

  // getName(val: string){
  //   console.warn(val);
  //   this.name = val;
  // }

  // getImg(val: string){
  //   console.warn(val);
  //   this.img = val;
  // }

  // getType(val: string){
  //   console.warn(val);
  //   this.type = val;
  // }

  // getWeight(w: NgForm) {
  //   this.weight = parseInt(w.value.weight)
  // }

  // OnClick(): void {
  //   console.log(this.name);
  //   console.log(this.img);
  //   console.log(this.type);
  //   console.log(this.weight);
  //   this.service.doPut(this.name, this.img, this.type, this.weight);
  // }

}
