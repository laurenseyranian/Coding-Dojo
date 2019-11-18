import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-create',
    templateUrl: './update.component.html',
    styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
    constructor(
        private _httpService: HttpService,
        private _route: ActivatedRoute,
        private _router: Router,
        ) { }
    editAuthor: any = { name: "" };
    authorId: any;

    ngOnInit() {
        this._route.params.subscribe((params: Params)=>{
            this.authorId = params['id']
        })
        this.readOneAuthor(); 
    }
    readOneAuthor() {
        let observable = this._httpService.readOneAuthor(this.authorId);
        observable.subscribe(data => {
            console.log("Read one Author", data)
            this.editAuthor = data;
        });
    }
    updateOneAuthor() {
        let observable = this._httpService.updateOneAuthor(this.authorId, this.editAuthor);
        observable.subscribe(data => {
            console.log("Updated Author!", data)
            this.goHome();
        });
    }
    goHome() {
        this._router.navigate(['/']);
    }
}
