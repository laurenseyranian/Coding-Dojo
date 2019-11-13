import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'coins-routed';
  gold = 0;
  activityLog =[];

  addGold(num1, num2, location) {
    const num = Math.floor(Math.random() *num1 + num2)
    this.gold += num;
    if (num > 0) {
      this.activityLog.unshift("You won " + num + " from " + location)
    }
    else {
      this.activityLog.unshift("You lost " + num + " from " + location)
    }
    console.log("This is new number being added from", location, num)
    console.log("This is the new number after click", location, this.gold)
  }
  resetGold(){
    this.gold=0;
    this.activityLog =[]
  }
}
