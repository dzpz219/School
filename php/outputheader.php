<html><body>
<?
// If PHP is set to use output buffering, content can be
// placed before 'header' calls without the header having
// already been sent.
//
// On CSU output buffering is enabled.
//
// But try uncommenting the below two line and see what happens:
// ob_end_clean();
// echo "Send output... <br>";
//
// ob_end_clean() erases the output buffer and turn off output
// buffering: http://php.net/manual/en/function.ob-end-clean.php
if (headers_sent())
{
  echo "Headers sent!";
//  header("Location: http://www.google.com");
}
else
{
  echo "Headers not yet sent!";
//  header("Location: http://www.google.com");
}
?>