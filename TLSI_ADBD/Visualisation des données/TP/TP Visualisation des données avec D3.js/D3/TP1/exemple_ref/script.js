var body=d3.select("body");

var h1=body.append("h1");
h1.text("C’est mon premier exemple généré avec D3")
.style("color","red")
.style("text-align","center");

d3.select("body").append("p").text("Paragraphe 1 générée par D3 !");
body.append("a")
.attr("href","https://d3js.org/")
.text("Page officielle D3.js");

d3.select("body").append("img").attr("src","10808.jpg").attr("width","100px").attr("height","100px").attr("alt","Image générée par D3.js");


var body=d3.select("body")
.append("svg")
.attr({"width":"400px","height":"400px"})
.style("border","3px solid black");

var body=d3.select("body");
var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.style("border","3px solid black");
svg.append("circle")
.attr({"cx":"200px","cy":"200px","r":"60px"});