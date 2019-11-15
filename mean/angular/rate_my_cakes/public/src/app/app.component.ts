import { Component, OnInit } from '@angular/core';
import { HttpService } from './http.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    constructor(private _httpService: HttpService) { }
    allcakes: any;
    newCake: any;
    newRating: { rating: "", comment: "" };
    showStats;


    ngOnInit() {
        this.allCakes();
        this.newCake = { name: "", image: "" }
    }

    allCakes() {
        let observable = this._httpService.allCakes();
        observable.subscribe(data => {
            console.log("All cakes!", data)
            for (var cake of data) {
                cake.newRating = { rating: 0, comment: "" }

                console.log(cake)
            }
            this.allcakes = data;
        });
    }
    createOneCake() {
        let observable = this._httpService.createOneCake(this.newCake);
        observable.subscribe(data => {
            console.log("Create one cake!", data)
            this.allCakes()
        });
    }

    updateOneCake(cake) {
        let observable = this._httpService.updateOneCake(cake._id, cake.newRating);
        observable.subscribe(data => {
            console.log("Update one cake!", data)
            cake.newRating = { rating: 0, comment: "" }
            this.allCakes()
        });
    }
    showStatsWindow(cake){
        
        this.showStats = cake;
    }
    deleteOneCake(cake) {
        let observable = this._httpService.deleteOneCake(cake._id);
        observable.subscribe(data => {
            console.log("Delete one cake!", data)
            this.allCakes()
        });
    }
}
