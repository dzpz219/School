$(document).ready(function() {
	if (Modernizr.geolocation){
		$(".geoNo").hide();
	}
	else{
		$(".geoYes").hide();
	}
	maps();
});

function maps () {
	navigator.geolocation.getCurrentPosition(show_map, errorCallback);
}

function show_map(position) {
	var	latitude = position.coords.latitude,
		longitude = position.coords.longitude;

	map = new GMaps({
		div: '#map',
		lat: latitude,
		lng: longitude
	});

	map.addMarker({
		lat: latitude,
		lng: longitude,
		title: 'Current Location',
		infoWindow: {
			content: "GPS puts you at: <br />" + "Latitude: " + latitude + "<br />" + "Longitude: " + longitude
		}
	});
}

function errorCallback(error) {
	$("#errorMsg").append(errorMessage(error.code), error.message, "<br />The following is a default map:");
	map = new GMaps({
		div: '#map',
		lat: 43.2384911,
		lng: -79.8892571
	});

	map.addMarker({
		lat: 43.2384911,
		lng: -79.8892571,
		title: 'Default Location'
	});
}

function errorMessage(code) {
	switch(code){
		case 1: return "PERMISSION_DENIED, ";
			break;
		case 2: return "POSITION_UNAVAILABLE, ";
			break;
		case 3: return "TIMEOUT, ";
			break;
	}
}