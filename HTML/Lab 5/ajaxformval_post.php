<?php
	$json = array(
				'validated' => $_REQUEST[flag],
				'postData' => array(
										'uname' => $_REQUEST[uname],
										'email' => $_REQUEST[email],
										'fname' => $_REQUEST[fname],
										'lname' => $_REQUEST[lname]
									)
				);
	echo json_encode($json);
?>