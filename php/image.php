<?
header("content-Type: image/jpeg");

$img = ImageCreate(9 * 10 + 1, 17);

// Note that the first call to ImageColorAllocate fills in the
// background color, and the 2nd fills in the foreground color
// and returns a color identifier
$bg_color   = ImageColorAllocate($img, 0, 0, 0); //black
$text_color = ImageColorAllocate($img, 255, 255, 255); //white

ImageString($img,5,1,0,$_GET[content],$text_color);
ImageJpeg($img);
ImageDestroy($img);

?>