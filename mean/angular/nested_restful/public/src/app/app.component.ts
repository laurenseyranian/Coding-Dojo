import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  constructor(private _httpService: HttpService) { }
  tasks;
  task = {title:"",description:"",complete:""};
  showTask;

  ngOnInit() {
    this.Tasks();
  }
  
  Tasks() {
    let observable = this._httpService.Tasks();
    observable.subscribe(data => {
      console.log("All tasks!", data)
      this.tasks = data;
    });
  }
  showEditForm(task) {
    task.showEditForm =! task.showEditForm;
  }
  viewOneTask(task) {
    console.log("View one task!",task)
    this.showTask = task;
  }
  close() {
    console.log("Close task!")
    this.showTask= null;
  }
  deleteOneTask(task) {
    let observable = this._httpService.deleteOneTask(task._id);
    observable.subscribe(data => {
      console.log("Delete one task!", data)
      this.Tasks()
    });
  }
  updateOneTask(task) {
    let observable = this._httpService.updateOneTask(task._id, task);
    observable.subscribe(data => {
      console.log("Update one task!", data)
      this.Tasks()
    });
  }
  createOneTask() {
    let observable = this._httpService.createOneTask(this.task);
    observable.subscribe(data => {
      console.log("Create one task!", data)
      this.Tasks()
    });
  }

}
