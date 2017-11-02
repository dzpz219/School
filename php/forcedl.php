<?
$text = "This is some text.";
header("Content-Type: application/octet-stream");
header("content-disposition: attachment; filename=\"onlytext.txt\"");
header("Content-Length: " . strlen($text));
echo $text;
?>