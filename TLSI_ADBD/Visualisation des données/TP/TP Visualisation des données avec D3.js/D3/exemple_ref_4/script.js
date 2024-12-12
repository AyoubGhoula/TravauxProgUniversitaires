var tab = [15, 34, 27, 45, 24, 54, 12]; // Données
var body = d3.select("body");

// Échelles pour les axes
var echelleX = d3.scale.ordinal()
    .domain(["lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"])
    .rangeBands([30, 370], 0.2);

var echelleY = d3.scale.linear()
    .domain([0, 54]) // Maximum des données
    .range([370, 30]); // Inverser pour que 0 soit en bas

// Axes
var xAxe = d3.svg.axis().scale(echelleX).orient("bottom");
var yAxe = d3.svg.axis().scale(echelleY).orient("left");

// Zone SVG
var svg = body.append("svg")
    .attr("width", 400)
    .attr("height", 400);

// Barres
svg.selectAll("rect")
    .data(tab)
    .enter()
    .append("rect")
    .attr("fill", "green")
    .attr("stroke", "black")
    .attr("width", echelleX.rangeBand())
    .attr("height", function(d) { return 370 - echelleY(d); })
    .attr("y", function(d) { return echelleY(d); })
    .attr("x", function(d, i) { return echelleX(echelleX.domain()[i]); });

// Affichage des axes
svg.append("g")
    .attr("transform", "translate(0, 370)") // Position axe X
    .call(xAxe);

svg.append("g")
    .attr("transform", "translate(30, 0)") // Position axe Y
    .call(yAxe);


/** act 2 */
d3.csv("voyageurs_jours.csv", function(data) {
    var body = d3.select("body");

    // Conversion des données
    data.forEach(function(d) {
        d.nb_visiteurs = +d.nb_visiteurs; // Conversion en nombre
    });

    // Affichage des données
    var para = body.selectAll("p")
        .data(data)
        .enter()
        .append("p")
        .text(function(d) {
            return "Jour: " + d.jours + " - Nombre de visiteurs: " + d.nb_visiteurs;
        });

    // Calcul de la somme des visiteurs
    var somme = d3.sum(data, function(d) { return d.nb_visiteurs; });
    body.append("p").text("Nombre total de visiteurs: " + somme);
});


/** act 3 */

d3.csv("voyageurs_jours.csv", function(data) {
    data.forEach(function(d) {
        d.nb_visiteurs = +d.nb_visiteurs; // Conversion des données
    });

    var marges = { haut: 20, droit: 20, bas: 30, gauche: 40 },
        largeurTotale = 500,
        hauteurTotale = 400,
        largeurInterne = largeurTotale - marges.gauche - marges.droit,
        hauteurInterne = hauteurTotale - marges.haut - marges.bas;

    var echelleX = d3.scale.ordinal()
        .domain(data.map(function(d) { return d.jours; }))
        .rangeBands([0, largeurInterne], 0.2);

    var echelleY = d3.scale.linear()
        .domain([0, d3.max(data, function(d) { return d.nb_visiteurs; })])
        .range([hauteurInterne, 0]);

    var svg = d3.select("body").append("svg")
        .attr("width", largeurTotale)
        .attr("height", hauteurTotale)
        .append("g")
        .attr("transform", "translate(" + marges.gauche + "," + marges.haut + ")");

    var axeX = d3.svg.axis().scale(echelleX).orient("bottom");
    var axeY = d3.svg.axis().scale(echelleY).orient("left");

    svg.append("g")
        .attr("transform", "translate(0," + hauteurInterne + ")")
        .call(axeX);

    svg.append("g")
        .call(axeY);

    svg.selectAll(".bar")
        .data(data)
        .enter()
        .append("rect")
        .attr("x", function(d) { return echelleX(d.jours); })
        .attr("width", echelleX.rangeBand())
        .attr("y", function(d) { return echelleY(d.nb_visiteurs); })
        .attr("height", function(d) { return hauteurInterne - echelleY(d.nb_visiteurs); })
        .attr("fill", "steelblue");
});

/**act 4 */
var donnees = [
    { type: "Article 1", count: 5170, price: 80 },
    { type: "Article 2", count: 4820, price: 50 },
    { type: "Article 3", count: 245, price: 40 },
    { type: "Article 4", count: 520, price: 150 },
    { type: "Article 5", count: 1300, price: 75 },
    { type: "Article 6", count: 150, price: 25 },
    { type: "Article 7", count: 250, price: 80 },
    { type: "Article 8", count: 500, price: 120 }
];

// Liste des modalités de la variable type
var type_modalites = donnees.map(function(d) { return d.type; });

// Prix (moyen) maximum
var prix_max = d3.max(donnees, function(d) { return d.price; });

// Définition des marges et dimensions du graphique
var marges = { haut: 20, droit: 20, bas: 30, gauche: 40 },
    largeurTotale = 500,
    hauteurTotale = 400,
    largeurInterne = largeurTotale - marges.gauche - marges.droit,
    hauteurInterne = hauteurTotale - marges.haut - marges.bas;

// Échelle pour les prix (axe Y)
var echelleY = d3.scale.linear()
    .domain([0, prix_max])
    .range([hauteurInterne, 0]);

// Échelle pour les types (axe X)
var echelleX = d3.scale.ordinal()
    .domain(type_modalites)
    .rangeBands([0, largeurInterne], 0.2); // Espacement entre les barres

// Échelle pour les couleurs (facultatif)
var echelleCouleur = d3.scale.category10()
    .domain(type_modalites);

// Création du graphique SVG
var graphique = d3.select("#graph").append("svg")
    .attr("width", largeurTotale)
    .attr("height", hauteurTotale)
    .append("g")
    .attr("transform", "translate(" + marges.gauche + "," + marges.haut + ")");

// Création des axes
var axeX = d3.svg.axis()
    .scale(echelleX)
    .orient("bottom");

var axeY = d3.svg.axis()
    .scale(echelleY)
    .orient("left");

// Ajout des axes au graphique
graphique.append("g")
    .attr("class", "x axis")
    .attr("transform", "translate(0," + hauteurInterne + ")")
    .call(axeX);

graphique.append("g")
    .attr("class", "y axis")
    .call(axeY);

// Label de l'axe Y
graphique.append("text")
    .attr("transform", "rotate(-90)")
    .attr("y", -marges.gauche + 10)
    .attr("x", -hauteurInterne / 2)
    .attr("dy", ".71em")
    .style("text-anchor", "middle")
    .text("Prix Vente (€)");

// Ajout des barres
graphique.selectAll(".bar")
    .data(donnees)
    .enter()
    .append("rect")
    .attr("class", "bar")
    .attr("x", function(d) { return echelleX(d.type); }) // Position X
    .attr("width", echelleX.rangeBand()) // Largeur de chaque barre
    .attr("y", function(d) { return echelleY(d.price); }) // Position Y
    .attr("height", function(d) { return hauteurInterne - echelleY(d.price); }) // Hauteur de la barre
    .style("fill", function(d) { return echelleCouleur(d.type); }); // Couleur



/**act 5 */


var tab = [
    { "valeur": 15287000, "nom": "États-Unis" },
    { "valeur": 10550000, "nom": "Chine" },
    { "valeur": 3562000, "nom": "Japon" },
    { "valeur": 2606000, "nom": "Allemagne" },
    { "valeur": 2030000, "nom": "Royaume-Uni" },
    { "valeur": 1653000, "nom": "France" }
];

var couleurs = ["green", "purple", "yellow", "blue", "black", "red"];

// Sélection et configuration de la zone SVG
var body = d3.select("body");
var svg = body.append("svg")
    .attr("width", 600)
    .attr("height", 600);

// Création du générateur de "pie"
var pieTab = d3.layout.pie()
    .value(function(d) { return d.valeur; }); // Transformation des valeurs en angles

// Création du générateur d'arcs
var arc = d3.svg.arc()
    .outerRadius(200) // Rayon extérieur du diagramme
    .innerRadius(0);  // Diagramme plein (pas de trou au centre)

// Création des groupes pour les portions du camembert
var grp = svg.selectAll("g.arcs")
    .data(pieTab(tab))
    .enter()
    .append("g")
    .attr("class", "arcs")
    .attr("transform", "translate(300,300)"); // Positionnement au centre de la zone SVG

// Création des portions (chemins <path>)
grp.append("path")
    .attr("fill", function(d, i) { return couleurs[i]; }) // Couleurs des portions
    .attr("d", arc); // Dessin des arcs

// Création des légendes
var leg = svg.selectAll("g.legende")
    .data(tab)
    .enter()
    .append("g")
    .attr("class", "legende")
    .attr("transform", function(d, i) {
        return "translate(450," + (100 + 30 * i) + ")"; // Positionnement des légendes
    });

// Carrés colorés pour la légende
leg.append("rect")
    .attr("width", 15)
    .attr("height", 15)
    .attr("fill", function(d, i) { return couleurs[i]; });

// Texte de la légende
leg.append("text")
    .attr("x", 25) // Décalage à droite des carrés colorés
    .attr("y", 12) // Alignement vertical
    .attr("fill", "black")
    .style("font-size", "12px")
    .text(function(d) { return d.nom; }); // Affichage des noms des pays

