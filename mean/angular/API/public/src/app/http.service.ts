import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class HttpService {
   constructor(private _http: HttpClient) {
      this.getPokemon();
   }
   getPokemon() {
      let mew = this._http.get('https://pokeapi.co/api/v2/pokemon/mew/');
      mew.subscribe(data =>{
         console.log( "Data" , data)
         console.log("Height" , data.height)
         console.log("Stats" , data.stats)
      })
      let ability = this._http.get('https://pokeapi.co/api/v2/ability/28/');
      ability.subscribe(data =>{
         console.log("Pokemon with ability 28" , data.pokemon)
      })
   }
}