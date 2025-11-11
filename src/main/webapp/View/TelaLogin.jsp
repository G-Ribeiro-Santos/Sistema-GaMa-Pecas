<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
	body{
		font-family: Arial, sans-serif;
		display: flex;
		justify-content: space-around; 
		margin: 40px;
	}
	.caixa{
		padding: 20px;
		border: 1px solid #ccc;
		border-radius: 10px;
		width: 300px;
	}
	input {
		width: 100%;
		padding: 10px;
		margin-bottom: 10px;
		border-radius: 5px;
		border: 1px solid #ccc;
	}
	button {
		width: 100%;
		padding: 10px;
		border-radius: 5px;
		border: none;
		background-color: #191970;
		color: #ffffff;
		font-size: 16px;
	}
	
</style>

 <script>

 function tentaLogin(){ 
    var email = document.getElementById("emailLogin").value;
 	var senha = document.getElementById("senhaLogin").value;

 	$.ajax({
        
        type:"GET",//or POST
        url:'http://localhost:7080/ajaxforjson/Testajax',
                           //  (or whatever your url is)
        data:{data1:var1},
        //can send multipledata like {data1:var1,data2:var2,data3:var3
        //can use dataType:'text/html' or 'json' if response type expected 
        success:function(responsedata){
               // process on data
               alert("got response as "+"'"+responsedata+"'");
        }
     })
 }

    </script>
</head>
<body>

<div class="caixa" id="esquerda">
	<h2> Cadastro</h2>
	<input type="text" placeholder="Nome"> 
	<input type="email" placeholder="E-mail"> 
	<input type="password" placeholder="Senha"> 
	<button>Cadastrar</button>
</div>

<div class="caixa" id="direita">
	<h2>Login</h2>
	<input name="emailLogin" type="email" id="emailLogin" value="" placeholder="E-mail">
	<input name="passwordLogin" type="password" id="passwordLogin" value="" placeholder="Senha"> 
	<button onclick="tentaLogin();">Entrar</button>
</div>

<div class="caixa" id="foot" >
	<h2>Lembrar Senha</h2>
	<input type="email" placeholder="E-mail"> 
	<button>Recuperar senha</button>
</div>

<script type="text/javascript">
	$(document).ready(function()){
		$("#esquerda"). load("esquerda.jsp");
		$("#direita"). load("direita.jsp");
		$("#foot"). load("foot.jsp");
	}
</script>
</body>
</html>
