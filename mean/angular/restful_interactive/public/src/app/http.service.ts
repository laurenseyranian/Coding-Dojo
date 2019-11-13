import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {
   constructor(private _http: HttpClient) {
      this.getTasks()
   }
   getTasks() {
      return this._http.get('/tasks');
   }
   getOneTask(id) {
      return this._http.get('/view/'+id);
   }
}