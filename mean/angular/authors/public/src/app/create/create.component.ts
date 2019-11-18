import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-create',
    templateUrl: './create.component.html',
    styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
    constructor(
        private _httpService: HttpService,
        private _route: ActivatedRoute,
        private _router: Router,
    ) { }
    newAuthor = { name: "" }

    ngOnInit() {
    }

    createOneAuthor() {
        let observable = this._httpService.createOneAuthor(this.newAuthor);
        observable.subscribe(data => {
            console.log("Create one author!", data)
            this.goHome();
        });
    }
    goHome() {
        this._router.navigate(['/']);
    }
}
