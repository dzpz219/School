<?
$txt = "Mary had a little lamb";
echo base64_encode($txt).'<br>';
echo base64_decode(base64_encode($txt));
?>