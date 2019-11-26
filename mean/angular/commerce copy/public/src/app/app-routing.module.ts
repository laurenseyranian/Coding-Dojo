import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { ReadallComponent } from './readall/readall.component';
import { ReadoneComponent } from './readone/readone.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
    {path: 'products/new', component: CreateComponent},
    {path: '', component: ReadallComponent},
    {path: 'products', component: ReadallComponent},
    {path: 'products/:id', component: ReadoneComponent},
    {path: 'products/edit/:id', component: UpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }