import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { ReadComponent } from './read/read.component';


const routes: Routes = [
    {path: 'create', component: CreateComponent},
    // This is the first page that will render
    {path: '', component: ReadComponent},
    {path: 'read', component: ReadComponent},
    {path: 'update/:id', component: UpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
