import { Component, OnInit, OnChanges, Input, Output, EventEmitter } from '@angular/core';
import { Person } from '../person';

@Component({
  selector: 'app-person-form',
  templateUrl: './person-form.component.html',
  styleUrls: ['./person-form.component.css']
})
export class PersonFormComponent implements OnInit {

  public model:Person = null;
  public departments: string[] = [ 'Accounting', 'Economics', 'Finance', 'Management', 'Marketing' ];
  
  @Output() onSubmit = new EventEmitter<Person>();
  @Input() person: Person;

  constructor() { }

  ngOnChanges() {
    this.model = Object.assign({}, this.person);
  }

  submit(form) {
    if (!form.valid) {
      return;
    }
    this.onSubmit.emit(this.model);
  }

  ngOnInit(): void {
  }

}
