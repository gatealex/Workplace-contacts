import {Contact} from './contact';
import { Department } from './department';

export class Person {
    public id: number = 0;
    public name: string = '';
    public departments: Department[] = [];
    public contacts: Contact[] = [];
}