import { Component, OnInit, SystemJsNgModuleLoader } from '@angular/core';
import { PersonService } from '../person.service';
import { Person } from '../person';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  public filteredPerson: Person[];
  public selectedDepartment: string;
  public selectedPerson: Person;

  public mergedDepartments: String[] = [];

  public persons: Person[] = [];
  public departments:Department[] = [];
  constructor(private personService: PersonService, private departmentService:DepartmentService) { 
    
  }

  public async ngOnInit() {
    this.selectedDepartment = "";
    this.persons = await this.personService.getPersons();
    this.departments = await this.departmentService.getDepartments();
    this.addDepToPerson();
    this.filter();
    this.mergeDepartments();
  }

  addDepToPerson(){
    //console.log(this.departments[0].people[0]);
    this.persons.forEach(person => {
      person.departments = [];
    });
    

    this.departments.forEach(department => {
      department.people.forEach(person => {
        console.log( person.id);
        console.log(department);
        this.persons[person.id-1].departments.push(department);
        console.log( this.persons[person.id-1].departments);
      });
    });
    console.log("this");
    console.log(this.persons);
    
  }

  onFilterChange(department: string) {
    this.selectedDepartment = department;
    this.filter();
  }

  //Lord have mercy on my soul | 3 hours to find bind()
  filter() {
    this.filteredPerson = this.selectedDepartment === ''
    ? this.persons
    : this.persons.filter(this.filterByDepartment.bind(this));
  }

  filterByDepartment(person){
    let found = false;
    person.departments.forEach(d => {
      if (d.name === (this.selectedDepartment)){
        return found = true;
      }
    }); 
    return found;
  }

  mergeDepartments(){
    this.persons.forEach(person => {
      let concatDepartment:String = '';
        if(person.departments.length > 1){
          person.departments.forEach((department,index) => {
            if(index!=0)
              concatDepartment = concatDepartment.concat("-",department.name);
            else concatDepartment = person.departments[0].name;
          });
      } else {
        concatDepartment = person.departments[0].name;
      }
      this.mergedDepartments.push(concatDepartment);
    });
  }

  onSelectPerson(person) {
    if(this.selectedPerson == person) {
      this.selectedPerson = null
    } else
    this.selectedPerson = person;
  }

  onNewClick() {
    this.selectedPerson = new Person();
  }

  getPerson(): Person[] {
    return this.persons;
  }

  getPersonId(id: number): Person[] {
    return this.persons.filter(i => i.id == id);
  }

  onFormSubmit(person: Person) {
    
  }
}
