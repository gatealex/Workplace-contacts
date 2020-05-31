import { Injectable } from '@angular/core';
import { Person } from "./person";
import {Contact} from "./contact" 
import { DepartmentService } from './department.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 
     'Content-Type': 'application/json',
     'Authorization': 'beluci111 password', 
  })
};

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private personUrl = 'http://localhost:8080/person';
  
  constructor(
    private http: HttpClient
  ) { }

  getPersons(): Promise<Person[]> {
    return this.http.get<Person[]>(`${this.personUrl}`, httpOptions).toPromise();
  }

  getPerson(id: number): Promise<Person> {
    return this.http.get<Person>(`${this.personUrl}/${id}`, httpOptions).toPromise();
  }

  createPerson(person: Person): Promise<Person> {
    return this.http.post<Person>(`${this.personUrl}`, person, httpOptions).toPromise();
  }

  updatePerson(person: Person): Promise<Person> {
    return this.http.put<Person>(`${this.personUrl}/${person.id}`, person, httpOptions).toPromise();
  }

  deletePerson(id): Promise<Person> {
    return this.http.delete<Person>(`${this.personUrl}/${id}`, httpOptions).toPromise();
  }


  
}