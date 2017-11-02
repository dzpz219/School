<?
class View {
    
	function __construct() {
	}
	
	 
	
	function render ($templateFile,$vars) {
		$TPL = $vars;
		require_once(ROOT . '/application/views/'. strtolower($templateFile) . '.php');
		//Note: A header and footer can be loaded here automatically each time the view is called. 
		//require_once(ROOT . '/application/views/header.php');
	}

	function displayNav ($array) {
		$header = '';
		foreach ($array as $item){
			$header += "<li>" . $item . "</li>";
		}

		return $header;

	}
}
?>