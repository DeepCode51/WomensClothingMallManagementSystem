//验证码点击更新
function change(img) {
		
	img.src="getcode?"+new Date().getTime();
}

//点击事件

var flag=true;  //标记位

function FocusItem(obj) {
	
	if($(obj).attr('name') == 'verycode') {
		$(obj).next().next().html('').removeClass('error');
		
	}else {
		$(obj).next('span').html('').removeClass('error');
	}
}

//验证
function CheckItem(obj) {
	var msgBox = $(obj).next('span');
	
	switch($(obj).attr('name')) {
		case "id":
			if(obj.value == "") {
				msgBox.html('用户名(ID)不能为空');
				msgBox.addClass('error');
				flag=false;
			}else {
				var url="usernamecheck?name="+encodeURI($(obj).val())+"&"+new Date().getTime();
				//url请求检查的servlet codeservlet
				
				// "false" "true" 判断
				$.get(url, function(data){
				
					
					if(data == "false") {
						msgBox.html('用户名已存在！');
						msgBox.addClass('error');
						flag=false;
					}else{
						msgBox.html().removeClass('error');
						flag=true;
					}
				});	
			}
			break;
			
		case "pwd":
			if(obj.value == "") {
				msgBox.html('密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else{
					flag=true;
	        }
			break;
			
		case "rpwd":
			if(obj.value == "") {
				msgBox.html('确认密码不能为空');
				msgBox.addClass('error');
				flag=false;
			}else if($(obj).val() !=$('input[name="pwd"]').val() ){
				msgBox.html('两次输入密码不一致');
				msgBox.addClass('error');
				flag=false;
			}else{
				flag=true;
			}
			break;
			
		case "verycode":
			var  numshow = $(obj).next().next();
			
			if(obj.value == "") {
				numshow.html('验证码不能为空');
				numshow.addClass('error');
				flag=false;
			}else {
			
				var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
				
				$.get(url, function(data){
					if(data=="false") {
						numshow.html('验证码输入有误');
						numshow.addClass('error');
						flag=false;
					}else{
						numshow.html().removeClass('error');  //删除样式
						flag=true;
					}
					
				});
			
			}
			break;
			
	
	}
	
}


//检查表单
function checkForm(frm) {
	
	var els = frm.getElementsByTagName('input');
	
	//判断有 onblur 个属性的才是需要验证的
	
	for(var i=0; i<els.length; i++) {
		
		if(els[i] !=null ){
			if(els[i].getAttribute("onblur")) {
				CheckItem(els[i]);  //调用CheckItem（）方法
			}
		}
	}
	
	return flag;
	
}
