<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hangman.html</title>
<style>
	#title{
		text-align: center;
	}
	#alphabet{
		text-align: center;
	}
	#alphabet span{
		margin:0 7px;
	}
	#alphabet span a{
		font-size: 1.5em;
		font-weight: bold;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, 'Arial Narrow', Arial, sans-serif;
	}
	#word{
		width:330px;
		margin: 50px auto;
		border: 1px double black;
		text-align: center;
	}
	#word>div{
		width:20px;
		height:30px;
		margin:3px 7px;
		display: inline-block;
		border-style: solid;
		border-width:2px;
		border-color:white white black white;
		
	}
	#word>div a{
		font-size: 1.4em;
		font-weight: bold;
		display:none;
	}
	#chance{
		margin:30px 0;
		text-align: center;
		font-weight: bold;
	}
	#image{
		margin:30px auto;		
		text-align: center;
	}
	#image img{
		width:330px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	
	function init_answer(){
		var html = "";
		word = words[Math.floor(Math.random()*words.length)]
		//console.log(word)
		for(let i=0;i<word.length;i++){
			html+="<div class='underline"+word.charAt(i)+"''><a class='word"+word.charAt(i)+"''>"+word.charAt(i)+"</a></div>"
		}
		$("#word").html(html)
	}
	
	function init_alphabet(){
		var html = "";
		for(let i=0;i<alphabets.length;i++){
			html+="<span><a data-alph="+alphabets[i]+">"+alphabets[i]+"</a></span>"
		}
		$("#alphabet").html(html)
	}
	
	function click(){
		let letter=""
		let correct=0
		let attempt=0
		let wrong=0
		let check=false
		$("#chance").html("남은 기회는 : "+7)
		$("#alphabet span a").click(function(){
			$(this).off('click')
			letter=$(this).data("alph")
			$(this).css("color","red")
			for(let i=0;i<word.length;i++){
				if(word.charAt(i)==letter){
					$("#word div.underline"+letter)
					.css("borderColor","white")	
					$("#word>div a.word"+letter).css("display","inline")
					$(this).css("color","blue")	
					correct++
					check=true
				}
			}
			if(!check) {
				wrong++
			}else{
				check=false
			}
			$("#chance").html("남은 기회는 : "+(7-wrong))
			$("#image").html("<img src='./images/image"+wrong+".png'>")
			if(wrong>=7){
				game_over()
			}else{
				if(correct==word.length){
					game_win()
				}
			}
		})
	}
	function game_win(){
		alert('추카추카~~ 똑똑한 사람입니다')
		$("#image").html("<img src='./images/image0.png'>")
		init_alphabet()
		init_answer()
		click()
	}
	function game_over(){
		alert('당신은 바보입니까?')
		$("#image").html("<img src='./images/image0.png'>")
		init_alphabet()
		init_answer()
		click()
	}
		
	$(function(){
		init_alphabet()
		init_answer()
		click()
	})
</script>
</head>
<body>
	
	<div id="wrap">
		<div id="title"><h1>Hangman Game</h1></div>
		<div id="word">
			<div class="underline${word }"><a class="word+word.charAt(i)"></a></div>
			
		</div>
		<div id="alphabet">
			<c:forEach items="${alphabets}" var="alpha">
				<span><a href="hangman_click?alpha=${alpha}">${alpha}</a></span>
			</c:forEach>	
		</div>
		<div id="chance">
			남은 기회는 : 7
		</div>
		<div id="image">
			<img src="./images/image0.png">
		</div>
	</div>
	
</body>
</html>