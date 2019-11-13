import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  constructor(private _httpService: HttpService) { }
  tasks = [];
  oneTask;

  ngOnInit() {
  }
  
  allTasks() {
    let observable = this._httpService.getTasks();
    observable.subscribe(data => {
      console.log("Got our tasks!", data)
      this.tasks = data;
    });
  }
  showTask(task) {
    let observable = this._httpService.getOneTask(task._id);
    observable.subscribe(data => {
      console.log("Got one task!", data)
      this.oneTask = data;
    });
  }
}
