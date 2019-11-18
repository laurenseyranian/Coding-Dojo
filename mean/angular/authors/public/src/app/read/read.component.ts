import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-read',
    templateUrl: './read.component.html',
    styleUrls: ['./read.component.css']
})
export class ReadComponent implements OnInit {

    constructor(
        private _httpService: HttpService,
        private _route: ActivatedRoute,
        private _router: Router,
    ) { }

    authors: any;

    ngOnInit() {
        this.readAllAuthors();
    }
    readAllAuthors() {
        let observable = this._httpService.readAllAuthors();
        observable.subscribe(data => {
            console.log("All Authors!", data)
            this.authors = data;
        });
    }
    deleteOneAuthor(author) {
        let observable = this._httpService.deleteOneAuthor(author._id);
        observable.subscribe(data => {
            console.log("Deleted one author", data)
            this.readAllAuthors();
        });
    }
}
