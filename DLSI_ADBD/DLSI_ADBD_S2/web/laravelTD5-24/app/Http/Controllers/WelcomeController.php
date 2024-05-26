<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class WelcomeController extends Controller
{
    //
    public function index($prenom,$nom){
       // return view('home',['fname'=>$prenom,'lname'=>$nom]);
     //  return view('home',compact('prenom','nom'));
//passage d'un seul param
    // return view('home')->with('prenom',$prenom);

//passage de plusieurs params
     return view('home')->with(['prenom'=>$prenom,'nom'=>$nom]);
    }
}
