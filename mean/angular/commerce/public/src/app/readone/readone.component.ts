import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-read',
    templateUrl: './readone.component.html',
    styleUrls: ['./readone.component.css']
})
export class ReadoneComponent implements OnInit {

    constructor(
        private _httpService: HttpService,
        private _route: ActivatedRoute,
        private _router: Router,
    ) { }

    productId: any;
    viewProduct: any = { name: "", quatity: "", price: "" };


    ngOnInit() {
        this._route.params.subscribe((params: Params)=>{
            this.productId = params['id']
        })
        this.readOneProduct();
    }

    readOneProduct() {
        let observable = this._httpService.readOneProduct(this.productId);
        observable.subscribe(data => {
            console.log("Read one Product", data)
            this.viewProduct = data;
        });
    }
    deleteOneProduct(product) {
        let observable = this._httpService.deleteOneProduct(product._id);
        observable.subscribe(data => {
            console.log("Deleted one product", data)
            this.goHome();
        });
    }
    goHome() {
        this._router.navigate(['/']);
    }
}
