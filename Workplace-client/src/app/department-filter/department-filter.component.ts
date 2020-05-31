import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-department-filter',
  templateUrl: './department-filter.component.html',
  styleUrls: ['./department-filter.component.css']
})
export class DepartmentFilterComponent implements OnInit {

  public departments: string[] = [ 'Accounting', 'Economics', 'Finance', 'Management', 'Marketing' ];
  @Input('department') selectedDepartment: string = '';
  @Output() onChange = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  onFilterChange(department: string) {
    this.selectedDepartment = department;
    this.onChange.emit(department);
  }

}
