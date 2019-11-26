import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class HttpService {
    constructor(private _http: HttpClient) { }

    readAllProducts() {
        return this._http.get('/products_json');
    }
    readOneProduct(id) {
        return this._http.get('/read_json/' + id);
    }
    createOneProduct(newProduct) {
        return this._http.post('/create_json', newProduct);
    }
    updateOneProduct(id, product) {
        return this._http.put('/update_json/' + id, product);
    }
    deleteOneProduct(id) {
        return this._http.delete('/delete_json/' + id);
    }
}
