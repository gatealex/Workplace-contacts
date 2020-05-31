import { Injectable } from '@angular/core';
import { Department } from './department';
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
export class DepartmentService {
  private departmentUrl = 'http://localhost:8080/department';
  
  constructor(
    private http: HttpClient
  ) { }
  
  getDepartments(): Promise<Department[]> {
    return this.http.get<Department[]>(`${this.departmentUrl}`, httpOptions).toPromise();
  }

}
