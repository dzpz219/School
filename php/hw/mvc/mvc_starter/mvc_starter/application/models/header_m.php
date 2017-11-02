<?
class header_m extends Model{

	public function __construct()
	{
		parent::__construct();
	}
	private $navItems = array('Home', 'Staff', 'Supervisor', 'HelpDesk', 'Admin', 'Log', 'Register'); 

	public function displayNav($array){
		$header = '';
		foreach ($array as $item){
			$header .= "<li><a href='" . $_SERVER['PHP_SELF'] . "?>?c=example&m=" . strtolower($item) . "'>" . $item . "</a></li>";
		}
		return $header;
	}
}
?>