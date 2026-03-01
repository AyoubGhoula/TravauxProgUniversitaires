import { Component, EventEmitter, inject, Input, Output, output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Ayoub } from '../ayoub';

@Component({
  selector: 'app-etudiant',
  imports: [FormsModule],
  templateUrl: './etudiant.html',
  styleUrl: './etudiant.css',
  providers: [Ayoub]

})
export class Etudiant {
  @Input() questionEnseigant : string ="";
  response : string = "";
  @Output() responseEvent = new EventEmitter<string>();

  envoyer(){
    this.responseEvent.emit(this.response);
        Ayoub.sayHello();

  }
}
