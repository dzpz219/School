<!--
StAuth10127: I Chao Zhang, 000306946 certify that this material is my original work. 
No other person's work has been used without due acknowledgement. 
I have not made my work available to anyone else.
-->

<html>
<head>
<? include 'controller.php'; ?>
	<title><?=$TPL['title']?></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container text-center">
		<div class="col-xs-12">
			<h1 class="text-primary"><?=$TPL['heading']?></h1>
		</div>
		<ul class="list-inline text-center">
			<? $TPL['dp'](); ?>
		</ul>
	</div>
</body>
</html>