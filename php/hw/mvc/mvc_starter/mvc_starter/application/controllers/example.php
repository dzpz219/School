<?
class Example extends Controller {
	
	 function __construct() {
		  parent::__construct();
		  
	}
	
	 
	function index () { 
		$TPL['dispWelcomeMsg'] = true;
		$TPL['msg'] = 'This is Sessions.Com!';
		$TPL['content'] = 'Home Page'
		$this->view->render('example_v',$TPL);
	}
	
	function showEntries1() {
		
		$MOD = new Example_m;
		$TPL['names'] = $MOD->getAllEntriesInPhonebook1();
		
		if (sizeof($TPL['names']) == 0 ):
			$TPL['dispErrorMsg'] = true;
			$TPL['errorMsg'] = "No records in database table";
		endif; 
		
		$TPL['dispAllPhonebookEntries'] = true;
		$this->view->render('example_v',$TPL);
		
	}
	
	
	function showEntries2() {
		
		$MOD = new Example_m;
		$TPL['names'] = $MOD->getAllEntriesInPhonebook2();
		
		if (sizeof($TPL['names']) == 0 ):
			$TPL['dispErrorMsg'] = true;
			$TPL['errorMsg'] = "No records in database table";
		endif; 
		
		$TPL['dispAllPhonebookEntries'] = true;
		$this->view->render('example_v',$TPL);
		
	}
}
?>

	