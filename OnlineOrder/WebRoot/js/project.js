/****注册页面判断与提示*****/
//验证手机号
function checkMobile() {
	var pwd = document.getElementById("mobile").value.trim();
	if(pwd.length == 0) {
		alert("手机号不能为空！");
		document.getElementById("mobile").focus();
		return false;
	}
	var regex = "^\\d{11}$"
	if(!pwd.match(regex)) {
		alert("手机号由11位数组成");
		document.getElementById("mobile").select();
		return false;
	}
	return true;
}
/*
 * 验证用户名格式是否正确的方法
 */
function checkUsername() {
	var username = document.getElementById("username").value.trim();
	if(username.length == 0) {
		alert("用户名不能为空!");
		document.getElementById("username").focus();
		return false;
	}
	var regex1 = "^[a-zA-Z0-9]{6,12}$";
	if(!username.match(regex1)) {
		alert("用户名必须由6-12位大小写字母数字、下划线组成!");
		document.getElementById("username").select();
		return false;
	}
	return true;
}
/*
 * 判断姓名
 */
function checkName() {
	var name = document.getElementById("name").value.trim();
	if(name.length == 0) {
		alert("姓名不能为空!");
		document.getElementById("name").focus();
		return false;
	}
	return true;
}
/**
 * 验证邮箱
 */
function checkEmail() {
	var email = document.getElementById("email").value.trim();
	var regex = "^[\\w.-]+@[\\w.-]+\\.\\w+$";
	if(email.length == 0) {
		alert("邮箱不能为空!");
		document.getElementById("email").focus();
		return false;
	} else if(!email.match(regex)) {
		alert("邮箱格式不正确!");
		document.getElementById("email").select();
		return false;
	}
	return true;
}
/*
 * 判断地址
 */
function checkAddress() {
	var name = document.getElementById("address").value.trim();
	if(name.length == 0) {
		alert("地址不能为空!");
		document.getElementById("address").focus();
		return false;
	}
	return true;
}
/*
 * 验证密码格式的方法
 */
function checkPwd1() {
	var password1 = document.getElementById("paw1").value.trim();
	if(password1.length == 0) {
		alert("密码不能为空！");
		document.getElementById("paw1").focus();
		return false;
	}
	var regex1 = "^[a-zA-Z0-9]{6,12}$";
	if(!password1.match(regex1)) {
		alert("密码必须由6-12位大小写字母数字、下划线组成!");
		document.getElementById("paw1").select();
		return false;
	}
	return true;
}
/*
 * 验证再次输入密码正确的方法
 */

function checkPwd2() {
	var paw2 = document.getElementById("paw").value.trim();
	var paw1 = document.getElementById("paw1").value.trim();
	if(paw2 != paw1) {
		alert("确认密码输入错误");
		document.getElementById("paw").select();
		return false;
	}
	if(paw2.length == 0) {
		alert("密码不能为空！");
		document.getElementById("paw").focus();
		return false;
	}
	return true;
}
//总方法
function submits() {
	if(checkUsername() && checkName() && checkEmail()&& checkMobile() &&checkAddress() && checkPwd1() && checkPwd2()) {
		return true;
	} else {
		return false;
	}
}
//更改密码
function updatePaw(){
	if(checkPwd1() && checkPwd2()) {
		return true;
	} else {
		return false;
	}
}
/***分类点击事件***/
function classify(nape){
	if(nape == "早餐"){
		document.getElementById("classify1").style.display="block";
		document.getElementById("classify2").style.display="none";
		document.getElementById("classify3").style.display="none";
	}else if(nape=="正餐"){
		document.getElementById("classify1").style.display="none";
		document.getElementById("classify3").style.display="none";
		document.getElementById("classify2").style.display="block";
	}else if(nape=="夜宵"){
		document.getElementById("classify1").style.display="none";
		document.getElementById("classify2").style.display="none";
		document.getElementById("classify3").style.display="block";
	}
}
