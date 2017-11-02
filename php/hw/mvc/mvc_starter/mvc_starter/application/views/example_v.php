<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Phone Book Example</title>
<link rel="stylesheet" type="text/css" href="public/css/styles.css"/>
</head>

<body>
<div id='main'>
<h1>OOP MVC Mini-Framework Starter Example</h1>

<ol id="nav">
  <li><a href="<?= $_SERVER['PHP_SELF'] ?>">Home</a></li>
  <li><a href="<?= $_SERVER['PHP_SELF'] ?>?c=example&m=showEntries1">Show Names 1</a></li>
  <li><a href="<?= $_SERVER['PHP_SELF'] ?>?c=example&m=showEntries2">Show Names 2</a></li>
  </ol>

<? if ($TPL['dispWelcomeMsg']): ?>
	<h3>Welcome! <?= $TPL['msg'] ?></h3>
    <p id="latin">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, 
    totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta 
    sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit,
     sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro 
     quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia
      non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. 
      Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi 
      ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate 
      velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla
       pariatur?</p>

<? endif; ?>

 
<? if ($TPL['dispErrorMsg']): ?>
	<p class="errorMsg"><?= $TPL['errorMsg'] ?></p>
<? endif; ?>

<? if ($TPL['dispAllPhonebookEntries']): ?>
    <ol>
    <?  foreach ($TPL['names']  as $row): ?>
      <li><?= $row['fname'] ?> <?= $row['lname'] ?>, Dept: <?= $row['dept'] ?> </li>
    <? endforeach; ?>
</ol>
<? endif; ?>
</div>
</body>
</html>