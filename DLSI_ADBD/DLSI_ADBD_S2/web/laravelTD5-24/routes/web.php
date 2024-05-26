<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\WelcomeController;
use App\Http\Controllers\TestController;
use App\Http\Controllers\UsersController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

// Route::get('/', function () {
//     return view('welcome');
// })->name('index');

Route::get('/',[WelcomeController::class,'index']);

Route::get('/home/{prenom}/{nom}',[WelcomeController::class,'index'])
->where(['prenom'=>'[a-zA-Z ]+','nom'=>'[a-zA-Z ]+']);

// Route::get('/start',function(){
//     return view('start');
// })->name('start');

route::get('/start/{nom}/{age}',[TestController::class,'index'])
->where(['nom'=>'[a-zA-Z ]+','age'=>'[0-9]+']);

// Route::get('/start',function(){
//     return "<h1>Hello, i'am your fisrt route</h1>";
// })->name('start');

//formulaire
Route::get('/users',[UsersController::class,'create'])->name('create_user');
Route::post('/users',[UsersController::class,'store'])->name('store_user');