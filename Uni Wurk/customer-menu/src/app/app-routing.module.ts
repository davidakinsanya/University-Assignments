import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { MenuGridComponent } from './menu-grid/menu-grid.component';

const routes: Routes = [
    { path: 'cart', component: CartComponent },
    { path: '', component: MenuGridComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
