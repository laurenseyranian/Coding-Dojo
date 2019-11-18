import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class HttpService {
    constructor(private _http: HttpClient) { }

    readAllAuthors() {
        return this._http.get('/authors_json');
    }
    readOneAuthor(id) {
        return this._http.get('/read_json/' + id);
    }
    createOneAuthor(newAuthor) {
        return this._http.post('/create_json', newAuthor);
    }
    updateOneAuthor(id, author) {
        return this._http.put('/update_json/' + id, author);
    }
    deleteOneAuthor(id) {
        return this._http.delete('/delete_json/' + id);
    }
}
