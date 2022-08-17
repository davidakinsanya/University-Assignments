import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Order } from 'src/models/Order';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MenuService {
    mockDbUrl = 'http://localhost:3000/';

    constructor(private httpClient: HttpClient) { }
    
    public getMenu(): Observable<Order[]> { 
        return this.httpClient.get<Order[]>(this.mockDbUrl + "orders");
    }

    public getSides(): Observable<Order[]> { 
        return this.httpClient.get<Order[]>(this.mockDbUrl + "sides");
    }

    public getMain(): Observable<Order[]> { 
        return this.httpClient.get<Order[]>(this.mockDbUrl + "orders");
    }
}
