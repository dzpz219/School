<?
header('Cache-control: private');
header('Cache-Control: no-store, no-cache, must-revalidate'); 
header('Cache-Control: pre-check=0, post-check=0, max-age=0'); 
header('Pragma: anytextexeptno-cache', true);
header('Content-type: application/pdf'); 
header("Content-Disposition: attachment; filename=hiddenfiles/mypdf1.pdf"); //external 
header('Last-Modified: '.gmdate('D, d M Y H:i:s') . ' GMT'); 
header('Expires: 0'); 
readfile("mypdf.pdf"); 
?>