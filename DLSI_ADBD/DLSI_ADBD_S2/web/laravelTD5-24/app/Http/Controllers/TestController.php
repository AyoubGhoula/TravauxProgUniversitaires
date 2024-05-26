<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TestController extends Controller
{
    //
    public function index($nom,$age){
        return view('start',compact('nom','age'));
    }
}
