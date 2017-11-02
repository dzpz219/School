$(document).ready(function() {
	if (Modernizr.geolocation){
		$(".geoNo").hide();
	}
	else{
		$(".geoYes").hide();
	}

	$("#json").append("<pre>", JSON.stringify(listRecCenters, null, '\t'), "</pre>");
	$("#json").hide();

	mapsRec();
});

function mapsRec(city) {
	mapsRec = new GMaps({
		div: '#mapRec',
		lat: 43.2608104,
		lng: -79.90,
		zoom: 10
	});

	for (i = 0; i < listRecCenters.length; i++){
		mapsRec.addMarker({
			lat: Number(listRecCenters[i].latitude),
			lng: Number(listRecCenters[i].longitude),
			title: listRecCenters[i].name,
			infoWindow: {
				content: "<div id='mapsRecInfo'>" 
				+ "<img style='float:right;' src='img/rec.jpg' height='50' width='50'>" 
				+ listRecCenters[i].name
				+ "<br />"
				+ listRecCenters[i].address
				+ "<br />"
				+ listRecCenters[i].city + " " + listRecCenters[i].phone
				+ "</div>"
			}
		});
	}
}

function filter (city) {
	var tmp = _.where(listRecCenters, {"city": city});

	if (city == ''){
		tmp = listRecCenters;
	}

	mapsRec = new GMaps({
		div: '#mapRec',
		lat: 43.2608104,
		lng: -79.90,
		zoom: 10
	});

	for (i = 0; i < tmp.length; i++){
		mapsRec.addMarker({
			lat: Number(tmp[i].latitude),
			lng: Number(tmp[i].longitude),
			title: tmp[i].name,
			infoWindow: {
				content: "<div id='mapsRecInfo'>" 
				+ "<img style='float:right;' src='img/rec.jpg' height='50' width='50'>" 
				+ tmp[i].name
				+ "<br />"
				+ tmp[i].address
				+ "<br />"
				+ tmp[i].city + " " + tmp[i].phone
				+ "</div>"
			}
		});
	}
}

function showJSON() {
	$("#json").toggle();
}