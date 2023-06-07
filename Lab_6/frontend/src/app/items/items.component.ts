import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  EntityList:Entity[]=[];
  showAddForm:boolean=false;
  selectedEntity?:Entity;

  constructor(private service:ServiceService){}

  ngOnInit(): void {
    this.updateEntities();
    this.service.list.subscribe(
      (list:Entity[])=>{
        this.EntityList=list;
        console.log(this.EntityList);
      }
    )
  }

  updateEntities(){
    this.service.getEnteties().subscribe(
      (ents)=>{
        this.service.setList(ents)
      }
    )
  }

  addEntity(ent:Entity){
    this.service.postEntity(ent).subscribe(
      (ents)=>{
        this.updateEntities();
      }
    )
  }

  deleteEntity(ent:Entity){
    this.service.deleteEntity(ent).subscribe(
      ()=>{
        this.updateEntities();
      }
    )
  }

  onSelect(ent:Entity){
    if(this.selectedEntity && ent.id==this.selectedEntity.id){
      this.selectedEntity=undefined
    } else{
      this.selectedEntity=ent
        document.getElementById("update")?.scrollIntoView({
          behavior: "smooth",
          block: "center",
          inline: "nearest"
        });
    }
  }

  closeUpdate(){
    this.selectedEntity=undefined;
  }

}
