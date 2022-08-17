import { Component, OnInit, Input } from '@angular/core';
import { Order } from 'src/models/Order';
import { CartService } from '../cart/cart.service';
import { MenuService } from './menu.service';

@Component({
  selector: 'app-menu-grid',
  templateUrl: './menu-grid.component.html',
  styleUrls: ['./menu-grid.component.sass']
})
    
export class MenuGridComponent implements OnInit {

    orders: Order[] = [];
    cartOrders: Order[] = []
    html: string = "";
    
  constructor(private menuService: MenuService, private cart: CartService) { }
    

    ngOnInit(): void {
        this.menuService.getMenu().subscribe(orders => { 
            this.orders = orders;
        });
    }
    
    getSides() { 
        this.menuService.getSides().subscribe(orders => { 
            this.orders = orders;
        });
    }

    getMain() { 
        this.menuService.getMain().subscribe(orders => { 
            this.orders = orders;
        });        
    }

    getStarters() { 

    }

    getDrinks() { 

    }

    getDessert() { 

    }

    addToCart(order: Order) { 
        this.html = `<p>${order.meal}: £${order.price}</p><br/>`
        this.cart.addToCart(order);
    }

    showInfo(order: Order) { 

    }
}
