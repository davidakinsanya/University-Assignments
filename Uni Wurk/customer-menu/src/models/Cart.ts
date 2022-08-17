import { Order } from "./Order";

export class Cart {
  orderList: Order[] = [];
  priceList: number[] = [];
  totalPrice: number = 0;
  tableNo: number = 0;
}