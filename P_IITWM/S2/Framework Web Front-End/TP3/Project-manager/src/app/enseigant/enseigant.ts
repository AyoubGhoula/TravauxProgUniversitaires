import { Component, OnInit } from '@angular/core';
import { Etudiant } from '../etudiant/etudiant';

@Component({
  selector: 'app-enseigant',
  imports: [Etudiant],
  templateUrl: './enseigant.html',
  styleUrl: './enseigant.css',
})
export class Enseigant {

  question : string = "1 + 1 = 3 ?";
  response : string = ""; 
  result : string = "";

recevoir(reponseEtudiant : string){
  this.response = reponseEtudiant;    
  if(this.response === "2"){
    this.result = "Bonne réponse";
  } else {
    this.result = "Mauvaise réponse";
  }
}
}
