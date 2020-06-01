import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from "@angular/router";
import { PersonService } from '../person.service';
import { Person } from '../person';
import { PersonListComponent } from '../person-list/person-list.component';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';


@Component({
  selector: 'app-contact-detail',
  templateUrl: './contact-detail.component.html',
  styleUrls: ['./contact-detail.component.css']
})
export class ContactDetailComponent implements OnInit {

  public persons:Person[] = [];
  public person:Person;
  public CType = ["Mobil","Work Phone","Email"];
  public CIType = ["smartphone","phone","email"];

  constructor(
    private route: ActivatedRoute,
    private personService: PersonService,
    
  ) {
   }

  async ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.persons = await this.personService.getPersons();
    this.person = this.persons[id-1];

  }

}
