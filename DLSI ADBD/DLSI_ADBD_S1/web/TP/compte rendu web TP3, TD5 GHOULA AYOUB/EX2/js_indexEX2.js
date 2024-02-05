function age() {
    var date = document.getElementById("date").value;
        const dateTable= date.split("/");
        if(dateTable.length===3){
			var mois=dateTable[1];
			var annee=dateTable[2];
			var dateJ= new Date();
			var age=dateJ.getFullYear()-annee;
			document.getElementById('result').innerHTML = 'Vous êtes né au mois : ' + mois + ' de l\'année : ' + annee + '<br>' + 'Votre âge= ' + age;
		}
		else{
			document.getElementById('result').innerHTML ='plz entrer la date au format jj/mm/aaaa';
		}
    }
