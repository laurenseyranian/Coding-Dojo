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
    editProduct: any = { name: "", quantity: "", price: "" };
    productId: any;
    errorsUpdate = [];


    ngOnInit() {
        this._route.params.subscribe((params: Params) => {
            this.productId = params['id']
        })
        this.readOneProduct();
    }
    readOneProduct() {
        let observable = this._httpService.readOneProduct(this.productId);
        observable.subscribe(data => {
            console.log("Read one Product", data)
            this.editProduct = data;
        });
    }
    updateOneProduct() {
        let observable = this._httpService.updateOneProduct(this.productId, this.editProduct);
        observable.subscribe(data => {
            console.log("Updated Product!", data)
            if (data['errors']) {
                this.errorsUpdate = data['errors']
            } else {
                this.errorsUpdate = [];
                this.editProduct = { name: "", quatity: "", price: "" };
                this.goHome();
            }
        })
    }
    goHome() {
        this._router.navigate(['/']);
    }
}
