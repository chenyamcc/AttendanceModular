    //校验新密码和旧密码
    function validation(){
    	var oldpwd = $("#oldpwd").val();
        var newpwd = $("#newpwd").val();
        var confim = $("#confim").val();
        var oldPassword=$("#oldPassword").val();
        //原始密码不能为空
        if(oldpwd==' '||oldpwd==null||oldpwd==''){
            alert("请输入原始密码");
            return false;
        }
        //新密码不能为空
        if(newpwd==' '||newpwd==null||newpwd==''){
            alert("请输入新密码");
            return false;
        }
        //新密码与确认密码必须一致
        if(newpwd != confim){
            alert("新密码不一致");
            return false;
        }
        //原始密码与登录密码不一致
        if(oldPassword!=oldpwd){
        	alert("请输入正确的原始密码");
        	return false;
        }
        //新旧密码一致，是否修改
        if(oldpwd==newpwd){
        	if(confirm("新旧密码一致确认修改？")){
        		 $(".form-horizontal").submit();
        	}else{
        		return false;
        	}
        }
        //提交修改
        $(".form-horizontal").submit();
    }
