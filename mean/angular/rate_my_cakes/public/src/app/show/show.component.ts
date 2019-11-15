import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-show',
    templateUrl: './show.component.html',
    styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
    showCake: any;
    cakeId;

    constructor(private _httpService: HttpService,
        private _router: Router,
        private _route: ActivatedRoute, ) { }

    ngOnInit() { 
        this._route.params.subscribe((params: Params)=>{
            this.cakeId = params['id']
        }) 
        this.readOneCake();
    }

    readOneCake() {
        let observable = this._httpService.readOneCake(this.cakeId);
        observable.subscribe(data => {
            console.log("Read one cake!", data)
            this.showCake = data;
            var sum = 0;
            var count = 0;
            for (var item of this.showCake.ratings){
                sum+=item.rating;
                count ++;
            }
            if (count == 0){
                this.showCake.avgRating=0;
            }
            else{
                this.showCake.avgRating = Math.round(sum/count);
            }
        });
    }
}
