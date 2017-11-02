$(document).ready(function(){

	$("fieldset").find("input:text").each(function(){
		$(this).after('<p class="note"></p></div>')
	})

	$("input:button").click(function(){
		$("fieldset").find("p").each(function(){
			$(this).text("");
		})
		$("fieldset").find("label").each(function(){
			$(this).removeClass("error");
		})
		$("fieldset").find("input:text").each(function(){
			$(this).removeClass("error");
			$(this).val("");
		})
		$("#ajax-message").text("Let's do this again").css("color", "purple");
		$("#debug").text("");
	})

	$("#ajax-form").submit(function(){
			var	validated = true;
			$("#ajax-message").text("Thank you for your submission").css("color", "green");
		$(this).find("input:text").each(function(){
			var	inputValue = $(this).val(),
				inputName = $(this).attr('name');
			if (inputValue == ""){
				validated = false;
				$("#ajax-message").text("An error has occurred. See messages below").css("color", "red");
				$(this).addClass("error");
				
				switch (inputName){
					case "uname":
						$("label[for='uname']").addClass('error')
						$(this).next().text("Please enter your name.");
						break;
					case "email":
						$("label[for='email']").addClass('error')
						$(this).next().text("An email address is required.");
						break;
					case "fname":
						$("label[for='fname']").addClass('error')
						$(this).next().text("We very much require your first name.");
						break;
					case "lname":
						$("label[for='lname']").addClass('error')
						$(this).next().text("Your last name must be entered too.");
						break;
				}
			}
			else{
				$(this).removeClass("error");
				$(this).next().text("");
				$("label[for=" + inputName + "]").removeClass("error");
			}
			$(this).val($.trim(inputValue));
		})
		$.post(	"ajaxformval_post.php",	$("#ajax-form").serialize() + "&flag=" + validated,
		function(data){$("#debug").html(JSON.stringify(data, null, 4))},"json"
	)}
)})