import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { ServiceService } from './services/service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Lab_1_f';

  EntityList:Entity[]=[];

  constructor(private service:ServiceService){}

  getEntities():void{
    this.service.getEnteties().subscribe(
      (entities)=>{
        this.EntityList=entities;
      }
    )
  }
}
