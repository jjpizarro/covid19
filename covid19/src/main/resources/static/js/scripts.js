$(function(){
	
	$("button[type=submit]").on('click',function(ev){
		ev.preventDefault();
		var url = 'http://localhost:8080/login';
		var username = $('#inputUN').val();
		var pwd = $('#inputPassword').val();
		login(url,username,pwd);
		
	});
	
});


//curl -i -X POST http://localhost:8080/v1/login -d '{"username":"admin","password":"admin"}' -H "Content-Type: application/json"

var login = function(url, username, passwd){
	$.ajax({
		url:url,
		method:'POST',
		headers: {
			Accepts: "application/json"
		},
		contentType:'application/json',
		data:JSON.stringify({"username":username,"password":passwd}),
		success:function(data, textStatus, jqXHR){
			token = jqXHR.getResponseHeader("Authorization");
			console.log('console: login success;: '+token);
			localStorage.setItem('token',token);
			
			//locar la lógica después de logarse
			requestGETInfo("http://localhost:8080/departamentos");
		}
	});
};
//curl -i -X GET http://localhost:8880/v1/hello -H "Accept: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiQ70tyqQ"
var requestGETInfo = function(url){
	$.ajax({
		url:url,
		method:'GET',
		headers: {
			Accepts: "application/json",
			Authorization: localStorage.getItem('token')
				
		},
		success:function(data){
			//hacer algo con la respuesta
			console.log(data);
		}
	});
};

var requestGetInfo2 = function(url){
	$.ajax({
		url:url,
		method:'GET',
		beforeSend: function (xhr) {  
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Authorization", 'Bearer '+ localStorage.getItem('token'));
		},
		success:function(data){
			//hacer algo con la respuesta
		}
	});
}