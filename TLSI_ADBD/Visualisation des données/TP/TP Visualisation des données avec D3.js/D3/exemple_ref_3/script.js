var tab=[15,34,27,45,24,54,12];
var body=d3.select("body");
var echelleX=d3.scale.ordinal()//au lieu de linear() choisir ordinal()
.domain(["lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"])
.rangeBands([30, 370]);
var echelleY=d3.scale.linear()
.domain([0,54])//domaine sous forme de valeurs calculables
.range([370,30]);
var xAxe = d3.svg.axis()
.scale(echelleX)
.orient("bottom");
var yAxe = d3.svg.axis()

.scale(echelleY)
.orient("left");
var svg=body.append("svg");
svg.attr({"width":"400px","height":"400px"})
svg.selectAll("rect")
.data(tab)
.enter()
.append("rect")
.attr({"fill":"green","stroke":"black"})
.attr("width",function(d,i){

return (310/tab.length);
})
.attr("height",function(d,i){
    return (370-echelleY(d))
    })
    .attr("y",function(d,i){
    
    return (echelleY(d))
    })
    .attr("x",function(d,i){
    
    return (30+i*340/tab.length)
    });
    
    svg.append("g")//affichage de l'axe des x dans la fenêtre svg
    .style("font-family","sans-serif")
    
    .style("font-size","9px")
    .attr({"fill": "none","stroke": "black"})
    .attr("transform","translate(0,370)")
    .call(xAxe);
    svg.append("g")//affichage de l'axe des y dans la fenêtre svg
    .style("font-family","sans-serif")
    .style("font-size","11px")
    .attr({"fill": "none","stroke": "black"})
    .attr("transform","translate(30,0)")
    .call(yAxe);
    console.log(d3.version);

    d3.csv("C:/Users/ASUS/Desktop/GitHub/TravauxProgUniversitaires/TLSI_ADBD/voyageurs_jours.csv", function(error, data) {
        if (error) {
            console.error("Error loading CSV:", error);
            return;
        }
        console.log("Data loaded:", data);
    
        // Proceed to create your visualization here
    });


var body=d3.select("body");
d3.csv("voyageurs_jours.csv",function(data){
var para=body.selectAll("p").data(data);
para.enter()
.append("p")
.text(function(d,i){
return ("Jour: "+d.jours+"- Nombre de visiteurs: "+d.nb_visiteurs)
});
var somme=0;
data.forEach(function(d){//foreach eq à for (i=0;i<data.length;i++)
d.nb_visiteurs= +d.nb_visiteurs;//transformation de la chaine en entier

somme=somme+d.nb_visiteurs;
});
body.append("p").text("Nombre total de visiteurs: "+somme);
});