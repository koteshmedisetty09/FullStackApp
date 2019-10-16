
import { User } from './User';
import { Items } from './Items';

export class Cart {

    // tslint:disable-next-line: variable-name
    cart_id: number; 
    // tslint:disable-next-line: variable-name
    product_name: string;
    price: number;
    image?:string;
    user:  User;
    items: Items[];
         
} 
     