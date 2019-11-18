import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-read',
    templateUrl: './readall.component.html',
    styleUrls: ['./readall.component.css']
})
export class ReadallComponent implements OnInit {

    constructor(
        private _httpService: HttpService,
        private _route: ActivatedRoute,
        private _router: Router,
    ) { }

    products: any;

    ngOnInit() {
        this.readAllProducts();
    }
    readAllProducts() {
        let observable = this._httpService.readAllProducts();
        observable.subscribe(data => {
            console.log("All Products!", data)
            this.products = data;
        });
    }
    deleteOneProduct(product) {
        let observable = this._httpService.deleteOneProduct(product._id);
        observable.subscribe(data => {
            console.log("Deleted one product", data)
            this.readAllProducts();
        });
    }
}
