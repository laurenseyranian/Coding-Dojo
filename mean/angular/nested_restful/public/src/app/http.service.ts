import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {
   constructor(private _http: HttpClient) {
   }
   Tasks() {
      return this._http.get('/tasks');
   }
   viewOneTask(id) {
      return this._http.get('/view/'+id);
   }
   deleteOneTask(id) {
      return this._http.delete('/delete/'+id);
   }
   updateOneTask(id, task) {
      return this._http.put('/update/'+id, task);
   }
   createOneTask(task) {
      return this._http.post('/create', task);
   }
}