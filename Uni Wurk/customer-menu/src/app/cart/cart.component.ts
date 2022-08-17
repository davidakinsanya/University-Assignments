import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/models/Cart';
import { Order } from 'src/models/Order';
import { CartService } from './cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.sass']
})
export class CartComponent implements OnInit {
    cart: Cart = new Cart;
    orders: Order[] = [];
    html: string = "";

  constructor() { }

    ngOnInit(): void {
    }
}
