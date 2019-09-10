$(function(){
	paging(1);
})


function paging(pagenum){
	$.ajax({
		url:"/queryAttendanceSettingAll",
		data:{
			pageindex:pagenum
		},
		type:"GET",
		success:function(data){
			var tcontent="";
			var list=data.list;
			for(var i=0;i<list.length;i++){
				var as=list[i];
				
				tcontent+='<tr class="success">'
					+'<td style="display:none"></td>'
					+'<td>'+as.settime+'</td>'
					+'<td>'+as.begintime+'</td>'
					+'<td>'+as.afternoonbegintime+'</td>'
					+'<td>'+as.afternoonendtime+'</td>'
					+'<td>'+as.resttime+'</td>'
					+'<td>'
					+'<a href="/startone?asid='+as.asid+'" class="btn btn-primary btn">启用</a>'
					+'<a href="/deleteone?asid='+as.asid+'" class="btn btn-primary btn">删除</a>'
                    +'</td>'
					+'</tr>';
			}
			$("#tbody").html(tcontent);
			var ucontent='<li><a href="javascript:paging(1)" >首页</a></li>';
			
			if(data.pageNum>1){
				ucontent+='<li><a href="javascript:paging('+data.prePage+')">上一页</a></li>';
			}
			
			var pagenumlist=data.navigatepageNums;
			for(var i=0;i<pagenumlist.length;i++){
				if(pagenumlist[i]==i){
					ucontent+='<li ><a style="color:red">'+i+'</a></li>';
				}else{
					ucontent+='<li><a href="javascript:paging('+pagenumlist[i]+')">'+pagenumlist[i]+'</a></li>';
				}
			}
			
			if(data.pageNum<data.pages){
				ucontent+='<li><a href="javascript:paging('+data.nextPage+')" >下一页</a></li>';
			}
			
			ucontent+='<li><a href="javascript:paging('+data.pages+'))">尾页</a></li>'
			          +'<li><a>一共'+data.pages+'页</a></li>';
			
			$("#ul").html(ucontent);
			
		}
	})
	
}




function addAttendanceSetting(){
	var begintime = $("#begintime").val();	
	var afternoonbegintime = $("#afternoonbegintime").val();
	var afternoonendtime = $("#afternoonendtime").val();
	var resttime = $("#resttime").val();

	$.ajax({
		url:"/insertAttendanceSetting",
		data:{
			"begintime":begintime,
	        "afternoonbegintime":afternoonbegintime,
	        "afternoonendtime":afternoonendtime,
	        "resttime":resttime
		},
		type:"GET",
		success:function(data){
			if(data==1){
			$('#overtimeDivModel').remove();
			location.href = "/queryAttendanceSettingOne";
			}
		}
		
	})
}



function updateAttendanceSetting(){
	var begintime = $("#begintime").val();	
	var afternoonbegintime = $("#afternoonbegintime").val();
	var afternoonendtime = $("#afternoonendtime").val();
	var resttime = $("#resttime").val();

	$.ajax({
		url:"/updateAttendanceSetting",
		data:{
			"begintime":begintime,
	        "afternoonbegintime":afternoonbegintime,
	        "afternoonendtime":afternoonendtime,
	        "resttime":resttime
		},
		type:"GET",
		success:function(data){
			if(data==1){
			$('#overtimeDivModel').remove();
			location.href = "/queryAttendanceSettingOne";
			}
		}
		
	})
}


function overtimeHTML(method,asid) {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 600px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	overtimeHtml += '<input type="hidden" id="overtimeId" value="'+asid+'"/>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="startTime" class="col-sm-2 control-label">上班时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" id="begintime" placeholder="如：2017-04-19 08:00:00">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="endTime" class="col-sm-2 control-label">午休开始时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" id="afternoonbegintime" placeholder="如：2017-04-19 18:00:00">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="endTime" class="col-sm-2 control-label">午休结束时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" id="afternoonendtime" placeholder="如：2017-04-19 18:00:00">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-2 control-label">下班时间</label>';
	overtimeHtml += '<div class="col-sm-10">';
	overtimeHtml += '<input type="text" class="form-control" id="resttime">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
	if (method =='add') {
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="添加" onclick="addAttendanceSetting()"/>';
	} else {
		overtimeHtml += '<input type="button" class="btn btn-primary btn" value="修改" onclick="updateAttendanceSetting()"/>';
	}
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="取消" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';
	$("body").append(overtimeHtml);
}