<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
</head>
<body>
	<form method="POST" action="/submitSurvey">
		<div style="display: flex; flex-direction: column;">
			<label>Your Name: <input type="text" name="name"></label>
			<label>Dojo Location: 
				<select name="dojoLocation">
					<option value="Bellevue">Bellevue</option>
					<option value="Chicago">Chicago</option>
					<option value="SanJose">San Jose</option>
				</select>
			</label>
			<label>Favorite Language:
				<select name="favoriteLanguage">
					<option value="java">Java</option>
					<option value="python">Python</option>
					<option value="javascript">JavaScript</option>
					<option value="c">C</option>
				</select>
			</label>
			<label>Comment:
				<textarea name="comment" rows="4" cols="50"></textarea>
			</label>
			<button>Submit</button>
		</div>
	</form>
</body>
</html>