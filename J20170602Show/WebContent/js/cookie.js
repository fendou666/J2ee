function setCookie(key, value, expiredays){
	if(expiredays == null){
		var time = new Date();
		time.setDate(time.getDate() + 20); 
		expiredays = time.toUTCString();
	}
	document.cookie=key+"=" +escape(value) + ";expires=" + expiredays;
}
	
function getCookie(key){
	var cookieStr = document.cookie;
	var ret = ""
	//console.log("all cookie" + cookieStr);
	if(cookieStr.length>0){
		var keyIndex = cookieStr.indexOf(key);
		if(keyIndex!=-1){
			var endIndex = cookieStr.indexOf(";", keyIndex);
			if(endIndex==-1){
				endIndex = cookieStr.length;
			}
			ret = cookieStr.substring(keyIndex+key.length + 1, endIndex);
		}
	}
	return ret;
}