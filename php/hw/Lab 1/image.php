<?
$counter = file_get_contents("count.txt");
$counter += 1;
file_put_contents("count.txt", $counter);

header("content-Type: image/jpeg");
$imgObj = ImageCreate(9 * 10 + 1, 17);
ImageColorAllocate($imgObj, 0 ,0, 0); //black
$textColor = ImageColorAllocate($imgObj, 255, 255, 255); //white 
ImageString($imgObj,5,1,0,$counter,$textColor);
ImageJpeg($imgObj);
 
?>