import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { ContactDetailComponent } from './contact-detail/contact-detail.component';
import { PersonFormComponent } from './person-form/person-form.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/persons',
    pathMatch: 'full'
  },
  {
    path: 'persons',
    component: PersonListComponent
  },
  {
    path: 'persons/new',
    component: PersonFormComponent
  },
  {
    path: 'persons/:id',
    component: ContactDetailComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
