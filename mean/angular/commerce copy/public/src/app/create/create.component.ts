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
    newProduct = { name: "", quatity: "", price: "" };
    errors = [];

    ngOnInit() {
    }

    createOneProduct() {
        let observable = this._httpService.createOneProduct(this.newProduct);
        observable.subscribe(data => {
            console.log("Create one product!", data)
            if (data['errors']) {
                this.errors = data['errors']
            } else {
                this.errors = [];
                this.newProduct = { name: "", quatity: "", price: "" }
                this.goHome();
            }
        })
    }
    goHome() {
        this._router.navigate(['/']);
    }
}
