import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private _httpService: HttpService) { }
  cake: any;
  newCake: any = { "name": "", "image": "" }; 
  showCake;

  ngOnInit() {
    this.allCakes();
    this.newCake = {name : "", image : ""}
  }

  allCakes() {
    let observable = this._httpService.allCakes();
    observable.subscribe(data => {
      console.log("All cakes!", data)
      this.cake = data;
    });
  }
  createOneCake() {
    let observable = this._httpService.createOneCake(this.cake);
    observable.subscribe(data => {
      console.log("Create one cake!", data)
      this.allCakes()
    });
  }
  createOneRating() {
    let observable = this._httpService.createOneRating(this.cake);
    observable.subscribe(data => {
      console.log("Create one rating!", data)
      this.allCakes()
    });
  }
  readOneCake(cake) {
    console.log("Read one cake!",cake)
    this.showCake = cake;
  }
  updateOneCake(cake) {
    let observable = this._httpService.updateOneCake(cake._id, cake);
    observable.subscribe(data => {
      console.log("Update one cake!", data)
      this.allCakes()
    });
  }
  deleteOneCake(cake) {
    let observable = this._httpService.deleteOneCake(cake._id);
    observable.subscribe(data => {
      console.log("Delete one cake!", data)
      this.allCakes()
    });
  }
}
