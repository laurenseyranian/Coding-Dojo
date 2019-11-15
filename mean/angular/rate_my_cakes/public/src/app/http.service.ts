
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private _http: HttpClient) { }

  allCakes() {
    return this._http.get('/cakes');
  }
  createOneCake(cake) {
    return this._http.post('/create_cake', cake);
  }
  createOneRating(cake) {
    return this._http.post('/create_rating', cake);
  }
  readOneCake(id) {
    return this._http.get('/read/' + id);
  }
  updateOneCake(id, cake) {
    return this._http.put('/update/' + id, cake);
  }
  deleteOneCake(id) {
    return this._http.delete('/delete/' + id);
  }


}
