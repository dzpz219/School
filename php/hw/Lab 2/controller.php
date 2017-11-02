<!--
StAuth10127: I Chao Zhang, 000306946 certify that this material is my original work. 
No other person's work has been used without due acknowledgement. 
I have not made my work available to anyone else.
-->

<?

$TPL['title'] = "Lab 2";
$TPL['heading'] = "My Photo Galleries";
$TPL['description'] = file_get_contents("photos/d1/description.txt");

switch ($_REQUEST["act"]) :
	   
	case "allphotos": 
		$TPL['dp'] = 'displayAll';
	break;
	
	case "onephoto": 
		$TPL['dp'] = 'displayOne';
	break;
	
	default:
		$TPL['dp'] = 'displayThumbs';
endswitch;

function displayOne(){
	$directory = $_REQUEST[directory];
	$id = $_REQUEST[id];
	
	$folders = opendir("photos/$directory");
	$contents = file_get_contents("photos/$directory/description.txt");
	while ($imgs = readdir($folders)) {
		if ($imgs == "." || $imgs == ".." || $imgs == "_notes" || $imgs == "description.txt"){
		}
		else{
			$photos[] = $imgs;
		}
	}
	$length = count($photos) - 1;
	$current = $id + 1;
	sort($photos);
	$photo = $photos[$id];
	{	
		echo "<h3>$contents</h3>";
		echo "<h4>($current/$length)</h4>";
		echo "<li><a href='#' class='thumbnail'><img src='photos/$directory/$photo'></a></li>";
	}
}

function displayAll(){
	$directory = $_REQUEST[directory];
	$folders = opendir("photos/$directory/thumbs");
	$contents = file_get_contents("photos/$directory/description.txt");
	$id = 0;
	while ($imgs = readdir($folders)) {
		if ($imgs == "." || $imgs == ".." || $imgs == "_notes"){
		}
		else{
			$photos[] = $imgs;
		}
	}
	sort($photos);
	echo "<h3>$contents</h3>";
	foreach($photos as $photo)
	{	
		echo "<li><a href='gallery1.php?act=onephoto&directory=$directory&id=$id' class='thumbnail'><img src='photos/$directory/thumbs/$photo'></a></li>";
		$id++;
	}
}

function displayThumbs(){
	$FP = opendir("photos");
	while(false !== ($DIR = readdir($FP))){
		if ($DIR == "." || $DIR == ".."){
		}
		else{
			$directories[] = $DIR;
		}
	}
	sort($directories);
	foreach($directories as $directory)
	{
		$contents = file_get_contents("photos/$directory/description.txt");
		$folders = opendir("photos/$directory/thumbs");
		while ($imgs = readdir($folders)) {
			if ($imgs == "." || $imgs == ".." || $imgs == "_notes"){
			}
			else{
				$photos[] = $imgs;
			}
		}
		sort($photos);
		$photo = end($photos);
		echo "<li><a href='gallery1.php?act=allphotos&directory=$directory' class='thumbnail'><img src='photos/$directory/thumbs/$photo'></a>$contents</li>";
	}
}

?>