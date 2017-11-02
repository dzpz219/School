$(document).ready(function() {
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

function mapSearch() {
	var	latitude = parseFloat($("[name='Latitude']").val()),
		longitude = parseFloat($("[name='Longitude']").val());

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