

// function MaFonction (f){
//     f();
//     }
//     MaFonction(function(){alert("Cela fonctionne")});



// var body=d3.select("body");
// body.append("p")
// .text(function(){
// var monTexte="Création d'un texte à travers une fonction";
// return monTexte;});


// var body=d3.select("body");
// body.append("p")
// .style("color",function(){
// var couleur=prompt("choisissez une couleur 1-rouge 2-bleue (tapez 1 ou 2)");

// if (couleur=="1"){
// return "red";
// }
// else if (couleur=="2"){
// return "blue";
// }
// else{
// return "black";
// }
// })
// .text("Création d'un texte avec couleur à travers une fonction");


var tab=[15, 8, 20, 10, 35, 18, 22, 5, 40, 11, 6,8,25];
var body=d3.select("body");
body.selectAll("p")
.data(tab)
.enter()
.append("p")
.text(function(d,i){
return ("La valeur numéro "+i+" du tableau est : "+d)
});



// var tab=[15, 8, 20, 10, 35, 18, 22, 5, 40, 11, 6];
// var body=d3.select("body");
// var svg=body.append("svg");
// svg.attr({"width":"500px","height":"500px"})
// svg.style("border","1px solid black");
// svg.selectAll("rect")
// .data(tab)
// .enter()
// .append("rect")
// .attr({"height":"30px","x":"100px","fill":"blue","stroke":"black"})
// .attr("width",function(d,i){
// return d*10
// })
// .attr("y",function(d,i){return i*30
// });




var tab=[[6,4],[20,10],[2,15],[8,10],[25,9],[3,3],[30,15]]
var body=d3.select("body");
var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","1px solid black");
svg.selectAll("circle")
.data(tab)
.enter()
.append("circle")
.attr({"r":"7px","fill":"red","stroke":"black"})
.attr("cx",function(d,i){
return (d[0]);
})
.attr("cy",function(d,i){
return (d[1]);
});


var tab=[[6,4],[20,10],[2,15],[8,10],[25,9],[3,3],[30,15]]
var body=d3.select("body");
var echelleX=d3.scale.linear();
echelleX.domain([2,30]);
echelleX.range([30,370]);
var echelleY=d3.scale.linear();
echelleY.domain([3,15]);
echelleY.range([30,370]);
var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","1px solid black");
svg.selectAll("circle")
.data(tab)
.enter()
.append("circle")
.attr({"r":"7px","fill":"yellow","stroke":"black"})
.attr("cx",function(d,i){
return (echelleX(d[0]));
})
.attr("cy",function(d,i){
return (370-echelleY(d[1]));
});




var tab=[[6,4],[20,10],[2,15],[8,10],[25,9],[3,3],[30,15]]
var body=d3.select("body");
var echelleX=d3.scale.linear()
.domain([2,30])
.range([30,370]);
var echelleY=d3.scale.linear()
.domain([3,15])
.range([370,30]);
var xAxe=d3.svg.axis().scale(echelleX).orient("bottom");

var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","1px solid black");
svg.selectAll("circle")
.data(tab)
.enter()
.append("circle")
.attr({"r":"7px","fill":"green","stroke":"black"})
.attr("cx",function(d,i){
return (echelleX(d[0]));
})
.attr("cy",function(d,i){
return (echelleY(d[1]));
});
svg.append("g").call(xAxe);





var tab=[[6,4],[20,10],[2,15],[8,10],[25,9],[3,3],[30,15]]
var body=d3.select("body");
var echelleX=d3.scale.linear()
.domain([2,30])
.range([30,370]);
var echelleY=d3.scale.linear()
.domain([3,15])
.range([370,30]);

var xAxe = d3.svg.axis()

.scale(echelleX)
.orient("bottom");

var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","1px solid black");
svg.selectAll("circle")
.data(tab)
.enter()
.append("circle")
.attr({"r":"7px","fill":"black","stroke":"black"})
.attr("cx",function(d,i){
return (echelleX(d[0]));
})
.attr("cy",function(d,i){
return (echelleY(d[1]));
});
svg.append("g").attr("transform","translate(0,370)").call(xAxe);







var tab=[[6,4],[20,10],[2,15],[8,10],[25,9],[3,3],[30,15]]
var body=d3.select("body");
var echelleX=d3.scale.linear()
.domain([2,30])
.range([30,370]);
var echelleY=d3.scale.linear()
.domain([3,15])
.range([370,30]);

var xAxe = d3.svg.axis()

.scale(echelleX)
.orient("bottom");

var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","1px solid black");
svg.selectAll("circle")
.data(tab)
.enter()
.append("circle")
.attr({"r":"7px","fill":"black","stroke":"black"})
.attr("cx",function(d,i){
return (echelleX(d[0]));
})
.attr("cy",function(d,i){
return (echelleY(d[1]));
});
svg.append("g")
.style("font-family","sans-serif")
.style("font-size","11px")
.attr({"fill":"none","stroke":"black"})
.attr("transform","translate(0,370)")
.call(xAxe);



var tab = [[6, 4], [20, 10], [2, 15], [8, 10], [25, 9], [3, 3], [30, 15]];

var body = d3.select("body");

var echelleX = d3.scale.linear()
    .domain([0, 30]) 
    .range([30, 370]);

var echelleY = d3.scale.linear()
    .domain([0, 15]) 
    .range([370, 30]);

var xAxe = d3.svg.axis()
    .scale(echelleX)
    .orient("bottom");

var yAxe = d3.svg.axis()
    .scale(echelleY)
    .orient("left");

var svg = body.append("svg");
svg.attr({ "width": "400px", "height": "400px" });
svg.style("border", "1px solid black");

svg.selectAll("circle")
    .data(tab)
    .enter()
    .append("circle")
    .attr({ "r": "7px", "fill": "black", "stroke": "black" })
    .attr("cx", function (d) {
        return echelleX(d[0]);
    })
    .attr("cy", function (d) {
        return echelleY(d[1]);
    });

svg.append("g")
    .style("font-family", "sans-serif")
    .style("font-size", "11px")
    .attr({ "fill": "none", "stroke": "black" })
    .attr("transform", "translate(0,370)") 
    .call(xAxe);

svg.append("g")
    .style("font-family", "sans-serif")
    .style("font-size", "11px")
    .attr({ "fill": "none", "stroke": "black" })
    .attr("transform", "translate(30,0)") 
    .call(yAxe);



    