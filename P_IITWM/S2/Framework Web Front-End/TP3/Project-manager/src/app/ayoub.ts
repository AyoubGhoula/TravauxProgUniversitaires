import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Ayoub {
  
  Ayoub() {
    console.log('Ayoub');
  }

  static sayHello() {
    console.log('Hello from Ayoub!');
  }
  
}
