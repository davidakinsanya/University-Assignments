import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Cart } from 'src/models/Cart';
import { Order } from 'src/models/Order';

@Injectable({
  providedIn: 'root'
})
    
export class CartService {
    cart: Cart = new Cart;
    html: string = "";
    constructor() { }
    
    addToCart(order: Order) { 
        this.cart.orderList.push(order);
        this.cart.priceList.push(order.price);
        this.cart.totalPrice += order.price;

        console.log(this.cart);
    }

    completeOrder() { 
        // push cart to database
    }

    getOrders(): Observable<Order[]> { 
        return of(this.cart.orderList);
    }

    displayCart(order: Order) { 
        this.html = `<p>${order.meal} || ${order.price}</p><br/>`
    }
}
