<?

class Example_m extends Model {
	private   $DBO;
	private   $DBH;
	 

	public function __construct(  )
	   { 
		 parent::__construct();
	   
		 $this->DBO = Database::getInstance();
		 $this->DBH = $this->DBO->getPDOConnection();
	   } 
		
		 
		public function getAllEntriesInPhonebook1 () {
				
				$sql = "SELECT   * from phonebook order by lname";	
				try {
					$rs = NULL;
					$rs = $this->DBH->query($sql);
					foreach ($rs as $row): 
							$arr[]  =  $row;  
					endforeach;
				}
				catch (PDOException $e){
					$this->DBO->showErrorPage("Unable to retrieve all entries from database",$e );							
				} 
				return $arr;
		}
		
		public function getAllEntriesInPhonebook2  () {
				
				$sql = "SELECT   * from phonebook where lname like ?  and fname like ? order by lname";	
				try {
					$values = array("%a%", "%b%");
					$rs = NULL;
					$rs = $this->DBH->prepare($sql);
					$rs->execute($values);
				}
				catch (PDOException $e){
					$this->DBO->showErrorPage("Unable to retrieve all entries from database",$e );							
				} 
		
				return $rs->fetchAll(PDO::FETCH_ASSOC);
		}
		
		
	
	
	 
}

?>