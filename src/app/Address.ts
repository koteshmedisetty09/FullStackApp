import { User } from 'FullStackApp/src/app/User';



export class Address {
    id: number;
    fullName: string;


    pincode: number;


    currentaddress: string;
    primary =false;
    user: User;
}
