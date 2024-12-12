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









/** -------------------------------------------------------------------------------------------------------------------------------------------------------------- */
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


/** act 3 */
// Chargement des données depuis le fichier CSV
d3.csv("voyageurs_jours.csv", function(data) {
    var body = d3.select("body");

    // Conversion des visiteurs en nombre entier
    data.forEach(function(d) {
        d.nb_visiteurs = +d.nb_visiteurs;
    });

    // Dimensions et marges du graphique
    var marges = { haut: 20, droit: 20, bas: 30, gauche: 40 },
        largeurTotale = 500,
        hauteurTotale = 400,
        largeurInterne = largeurTotale - marges.gauche - marges.droit,
        hauteurInterne = hauteurTotale - marges.haut - marges.bas;

    // Définition des échelles
    var echelleX = d3.scale.ordinal()
        .domain(data.map(function(d) { return d.jours; })) // Récupère les jours
        .rangeRoundBands([0, largeurInterne], 0.2);// Espacement entre les barres

    var echelleY = d3.scale.linear()
        .domain([0, d3.max(data, function(d) { return d.nb_visiteurs; })]) // Maximum des visiteurs
        .range([hauteurInterne, 0]); // Inverse pour que 0 soit en bas

    // Création de l'élément SVG
    var svg = body.append("svg")
        .attr("width", largeurTotale)
        .attr("height", hauteurTotale)
        .append("g")
        .attr("transform", "translate(" + marges.gauche + "," + marges.haut + ")");

    // Axes
    var axeX = d3.svg.axis()
    .scale(echelleX)
    .orient("bottom");

var axeY = d3.svg.axis()
    .scale(echelleY)
    .orient("left");

    // Ajout de l'axe X
    svg.append("g")
        .attr("class", "x axis")
        .attr("transform", "translate(0," + hauteurInterne + ")") // Positionnement en bas
        .call(axeX);

    // Ajout de l'axe Y
    svg.append("g")
        .attr("class", "y axis")
        .call(axeY);

    // Ajout des barres
    svg.selectAll(".bar")
        .data(data)
        .enter()
        .append("rect")
        .attr("class", "bar")
        .attr("x", function(d) { return echelleX(d.jours); }) // Position horizontale
        .attr("y", function(d) { return echelleY(d.nb_visiteurs); }) // Position verticale
        .attr("width", echelleX.bandwidth()) // Largeur des barres
        .attr("height", function(d) { return hauteurInterne - echelleY(d.nb_visiteurs); }) // Hauteur des barres
        .attr("fill", "steelblue"); // Couleur des barres
});


/** act 4 */


var donnees = [
    { type: "Article 1", count: 5170, price: 80 },
    { type: "Article 2", count: 4820, price: 50},
    { type: "Article 3", count: 245, price: 40 },
    { type: "Article 4", count: 520 , price: 150 },
    { type: "Article 5", count: 1300 , price: 75 },
    { type: "Article 6", count: 150 , price: 25 },
    { type: "Article 7", count: 250 , price: 80 },
    { type: "Article 8", count: 500 , price: 120 }
    ];
    // Liste des modalités de la variable type
    var type_modalites = donnees.map(function(d) { return d.type; });
    // Prix (moyen) maximum
    var prix_max = d3.max(donnees, function(d) { return d.price; });
    // Définition des marges et de la taille du graphique
    var marges = {haut: 20, droit: 20, bas: 30, gauche: 40},
    largeurTotale = 500,
    hauteurTotale = 400,
    largeurInterne = largeurTotale - marges.gauche - marges.droit,
    hauteurInterne = hauteurTotale - marges.haut - marges.bas;
    // Echelle pour les prix sur l'axe Y
    var echelleY = d3.scale.linear()
    .domain([0, prix_max])
    .range([hauteurInterne, 0]);
    // Echelle pour le type sur l'axe X
    var echelleX = d3.scale.ordinal()
    .domain(type_modalites)
    .rangeRoundBands([0, largeurInterne], 0.2);
    // Echelle pour le type affectant une couleur automatique à chaque type
    var echelleCouleur = d3.scale.ordinal(d3["schemeSet1"])
    .domain(type_modalites);
    // Création de l'axe X
    var axeX = d3.axisBottom()
    .scale(echelleX);
    // Création de l'axe Y
var axeY = d3.axisLeft()
.scale(echelleY);
// Création du graphique
var graphique = d3.select("#graph").append("svg")
.attr("width", largeurTotale)
.attr("height", hauteurTotale)
.append("g")
.attr("transform", "translate(" + marges.gauche + "," + marges.haut +
")");
// Ajout de l'axe X au graphique
graphique.append("g")
.attr("class", "x axis")//n'affiche pas l'axe des x
.attr("transform", "translate(0," + hauteurInterne + ")")
.call(axeX);
// Ajout de l'axe Y au graphique
graphique.append("g")
.attr("class", "y axis")//n'affiche pas l'axe des y
.call(axeY);
graphique.append("text")
.attr("transform", "rotate(-90)")
.attr("y", 20)
//.attr("dy", ".71em")
.style("text-anchor", "end")
.text("Prix Vente");

graphique.selectAll(".bar")
.data(donnees)
.enter()
.append("rect")
.attr("class", "bar")
.attr("x", function(d) { return echelleX(d.type); })
.attr("width", echelleX.bandwidth())//largeur de chaque bar
.attr("y", function(d) { return echelleY(d.price); })
.attr("height", function(d) { return hauteurInterne - echelleY(d.price);
})// l'hauteur de chaque bar
.style("fill", function(d) { return echelleCouleur(d.type); });
