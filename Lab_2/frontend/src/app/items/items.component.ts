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

  constructor(private service:ServiceService){}

  ngOnInit(): void {
        this.service.getEnteties().subscribe(
      (entities)=>{
        this.EntityList=entities;
      }
    )
  }

}
