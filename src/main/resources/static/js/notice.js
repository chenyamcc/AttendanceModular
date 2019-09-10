/**
 * 检验通知公告数据
 */
/*function noticeCheck() {
	var title = $("#title").val();
	var content = $("#content").val();
	var recipinets = $("#noticeForm").find("input[type='checkbox']:checked");
	if (title == '') {
		alert("标题不允许为空");
		return false;
	}
	if (content == '') {
		alert("内容不允许为空！");
		return false;
	}
	if (recipinets.length == 0) {
		alert("请选择接收人");
		return false;
	}
	
	return true;
}*/

function getMySendNotifys(pageNum){
	var content = "";
	var content1 = "";
	var content2 = "";
	$.ajax({
		url:"/getMySendNotifys/"+pageNum,
		type:"POST",
		dataType:"JSON",
		success:function(data){
			var s = "";
			for(var i=0;i<data.page.list.length;i++){
				if(data.page.list[i].asid==1){
					s = "未审批";
				}else if(data.page.list[i].asid==2){
					s = "审批中";
				}else if(data.page.list[i].asid==3){
					s = "已审批";
				}else if(data.page.list[i].asid==4){
					s = "未通过";
				}
				content+='<tr>'
					+'<td>'+(i+1)+'</td>'
					+'<td><a href="/noticeDetailReadOnly/'+data.page.list[i].id+'">'+data.page.list[i].ntitle+'</a></td>'
					+'<td>'+data.page.list[i].ncontent+'</td>'
					+'<td>'+s+'</td>'
					+'<td>'+data.unames[i]+'</td>'
					+'<td id=updateBtn'+i+'>'
					+'</td>'
					+'</tr>';
			}
			$("#publishTable").html(content);
			
			for(var i=0;i<data.page.list.length;i++){
				if(data.page.list[i].asid==1){
					content1='<a href="/noticeDetail/'+data.page.list[i].id+'" class="btn btn-primary btn">修改</a><a href="/noticeRecall/'+data.page.list[i].id+'" class="btn btn-primary btn">撤回</a>';
				}else if(data.page.list[i].asid==2){
					content1='<a href="/noticeDetail/'+data.page.list[i].id+'" class="btn btn-primary disabled">修改</a><a href="/noticeRecall/'+data.page.list[i].id+'" class="btn btn-primary disabled">撤回</a>';
				}else if(data.page.list[i].asid==3){
					content1='<a href="/noticeDetail/'+data.page.list[i].id+'" class="btn btn-primary disabled">修改</a><a href="/noticeRecall/'+data.page.list[i].id+'" class="btn btn-primary disabled">撤回</a>';
				}else if(data.page.list[i].asid==4){
					content1='<a href="/noticeDetail/'+data.page.list[i].id+'" class="btn btn-primary disabled">修改</a><a href="/noticeRecall/'+data.page.list[i].id+'" class="btn btn-primary disabled">撤回</a>';
				}
				$("#updateBtn"+i).html(content1);
			}
			
			content2+='<p>当前第：'+data.page.pageNum+'页，共'+data.page.pages+'页，共'+data.page.total+'条数据</p>'
				+'<a onclick="javascript:getMySendNotifys('+data.page.navigateFirstPage+')"><首页></a>'
				+'<a onclick="javascript:getMySendNotifys('+data.page.prePage+')"><上一页></a>';
			for(var i=0;i<data.page.navigatepageNums.length;i++){
				content2+='<a onclick="javascript:getMySendNotifys('+data.page.navigatepageNums[i]+')">['+(i+1)+']</a>'
			}
			content2+='<a onclick="javascript:getMySendNotifys('+data.page.nextPage+')"><下一页></a>'
				+'<a onclick="javascript:getMySendNotifys('+data.page.navigateLastPage+')"><尾页></a>';
			
			$("#publishPage").html(content2);
		}
	});
}

function getMyReciveNotifys(pageNum){
	var content = "";
	var content2 = "";
	$.ajax({
		url:"/getMyReciveNotifys/"+pageNum,
		type:"POST",
		dataType:"JSON",
		success:function(data){
			for(var i=0;i<data.page.list.length;i++){
				content+='<tr>'
					+'<td>'+(i+1)+'</td>'
					+'<td><a href="/noticeDetailReadOnly/'+data.page.list[i].id+'">'+data.page.list[i].ntitle+'</a></td>'
					+'<td>'+data.page.list[i].ncontent+'</td>'
					+'<td>'+data.unames[i]+'</td>'
					+'</tr>';
			}
			$("#receiveTable").html(content);
			
			content2+='<p>当前第：'+data.page.pageNum+'页，共'+data.page.pages+'页，共'+data.page.total+'条数据</p>'
				+'<a onclick="javascript:getMyReciveNotifys('+data.page.navigateFirstPage+')"><首页></a>'
				+'<a onclick="javascript:getMyReciveNotifys('+data.page.prePage+')"><上一页></a>';
			for(var i=0;i<data.page.navigatepageNums.length;i++){
				content2+='<a onclick="javascript:getMyReciveNotifys('+data.page.navigatepageNums[i]+')">['+(i+1)+']</a>'
			}
			content2+='<a onclick="javascript:getMyReciveNotifys('+data.page.nextPage+')"><下一页></a>'
				+'<a onclick="javascript:getMyReciveNotifys('+data.page.navigateLastPage+')"><尾页></a>';
		
			$("#receivePage").html(content2);
		}
	});
}

function getUncheckedNotifys(pageNum){
	var content = "";
	var content2 = "";
	$.ajax({
		url:"/getUncheckedNotifys/"+pageNum,
		type:"POST",
		dataType:"JSON",
		success:function(data){
			for(var i=0;i<data.page.list.length;i++){
				content+='<tr class="primary">'
					+'<td>'+(i+1)+'</td>'
					+'<td><a href="/noticeDetailReadOnly/'+data.page.list[i].id+'">'+data.page.list[i].ntitle+'</a></td>'
					+'<td>'+data.page.list[i].ncontent+'</td>'
					+'<td>'+data.page.list[i].edescribe+'</td>'
					+'<td>'+data.unames[i]+'</td>'
					+'<td>'+data.runames[i]+'</td>'
					+'<td>'
					+'<a href="/updateNotifyState/'+data.page.list[i].id+'/'+3+'" onclick="javascript:location.href=\'+#+\'" class="btn btn-primary btn">同意</a>'
					+'<a href="/updateNotifyState/'+data.page.list[i].id+'/'+4+'" onclick="javascript:location.href=\'+#+\'" class="btn btn-primary btn">驳回</a>'
					+'</td>'
					+'</tr>';
			}
			$("#unCheckedNotifys").html(content);
			
			content2+='<p>当前第：'+data.page.pageNum+'页，共'+data.page.pages+'页，共'+data.page.total+'条数据</p>'
				+'<a onclick="javascript:getUncheckedNotifys('+data.page.navigateFirstPage+')"><首页></a>'
				+'<a onclick="javascript:getUncheckedNotifys('+data.page.prePage+')"><上一页></a>';
			for(var i=0;i<data.page.navigatepageNums.length;i++){
				content2+='<a onclick="javascript:getUncheckedNotifys('+data.page.navigatepageNums[i]+')">['+(i+1)+']</a>'
			}
			content2+='<a onclick="javascript:getUncheckedNotifys('+data.page.nextPage+')"><下一页></a>'
				+'<a onclick="javascript:getUncheckedNotifys('+data.page.navigateLastPage+')"><尾页></a>';
	
			$("#unCheckedPage").html(content2);
		}
	});
}

/**
 * 我发布的通知公告
 * @param path
 * @param offset
 */
/*function myPulish(path, offset) {
	// 清空tbody中数据
	$("#publishTable").html('');
	// 清空分页数据
	$("#publishPage").html('');
	$.ajax({
		url: path + "/notice/my/publish.action",
		type: "POST",
		data: {offset: offset},
		dataType: "JSON",
		success: function(data){
			var tbody = $("#publishTable");
			if (data.msg != ''){
				var $tr = $('<tr><td colspan="5" style="text-align: center;">' + data.msg + '</td></tr>');
				$tr.appendTo(tbody);
				return;
			}
			var page = data.page;
			$.each(data.notices, function(k ,v){
				var $tr = $('<tr></tr>');
				if (k % 2 == 0)
					$tr.addClass('success');
				var index = Number((page.pageNo - 1) * page.pageSize)+ Number(1) + Number(k);
				var $numTd = $('<td>' + index + '</td>');
				var $titleTd = $('<td><a href = "' + path + '/notice/notice/detail.action?id=' + v.id + '&type=0">' + v.title + '</a></td>');
				var $contenTd = $('<td>' + v.content + '</td>');
				var statu_ = v.status == 0 ? '待审核' : v.status == 1 ? '审核通过' : '审核失败';
				var $statusTd = $('<td>' + statu_  + '</td>');
				var $btnTd = $('<td></td>');
				var $btn = $('<input type="button" class="btn btn-primary btn" value="修改" onclick="javascript:location.href=\'' + path + '/notice/notice/detail.action?id=' + v.id + '&type=1\'"/>');
				// 只有未审核的才能修改
				if (v.status == 0)
					$btn.appendTo($btnTd);
				
				$numTd.appendTo($tr);
				$titleTd.appendTo($tr);
				$contenTd.appendTo($tr);
				$statusTd.appendTo($tr);
				$btnTd.appendTo($tr);
				$tr.appendTo(tbody);
			});
			var pageDiv = $("#publishPage");
			var spanStr = '<span>共' + page.totalRecords + '条记录 共' + page.totalPages + '页 当前第' + page.pageNo + '页</span>';
			var ulStr = '<ul class="pagination" style="float: right;margin: 0;">';
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', 1)">首页</a></li>';
				if (page.pageNo != 1) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo-1 })">上一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">上一页</a></li>';
				}
				if (page.pageNo != page.totalPages) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo + 1 })">下一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">下一页</a></li>';
				}
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.totalPages })">尾页</a></li>';
			
			pageDiv.append(spanStr);
			pageDiv.append(ulStr);
		},error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}*/

/**
 * 我接收的公告
 * @param path
 * @param offset
 */
/*function myReceive(path, offset) {
	// 清空tbody中数据
	$("#receiveTable").html('');
	// 清空分页数据
	$("#receivePage").html('');
	$.ajax({
		url: path + "/notice/notice/list.action",
		type: "POST",
		data: {offset: offset},
		dataType: "JSON",
		success: function(data){
			var tbody = $("#receiveTable");
			if (data.msg != ''){
				var $tr = $('<tr><td colspan="4" style="text-align: center;">' + data.msg + '</td></tr>');
				$tr.appendTo(tbody);
				return;
			}
			var page = data.page;
			$.each(data.notices, function(k ,v){
				var $tr = $('<tr></tr>');
				if (k % 2 == 0)
					$tr.addClass('success');
				var index = Number((page.pageNo - 1) * page.pageSize)+ Number(1) + Number(k);
				var $numTd = $('<td>' + index + '</td>');
				var $titleTd = $('<td><a href = "' + path + '/notice/notice/detail.action?id=' + v.id + '&type=0">' + v.title + '</a></td>');
				var $contenTd = $('<td>' + v.content + '</td>');
				var $realNameTd = $('<td>' + v.reanlName + '</td>');
				
				$numTd.appendTo($tr);
				$titleTd.appendTo($tr);
				$contenTd.appendTo($tr);
				$realNameTd.appendTo($tr);
				$tr.appendTo(tbody);
			});
			var pageDiv = $("#receivePage");
			var spanStr = '<span>共' + page.totalRecords + '条记录 共' + page.totalPages + '页 当前第' + page.pageNo + '页</span>';
			var ulStr = '<ul class="pagination" style="float: right;margin: 0;">';
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', 1)">首页</a></li>';
				if (page.pageNo != 1) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo-1 })">上一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">上一页</a></li>';
				}
				if (page.pageNo != page.totalPages) {
					ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.pageNo + 1 })">下一页</a></li>';
				} else {
					ulStr += '<li class="disabled"><a href="javascript:void(0)">下一页</a></li>';
				}
				ulStr += '<li><a href="javascript:void(0)" onclick="myPulish(\'' + path + '\', ${page.totalPages })">尾页</a></li>';
			
			pageDiv.append(spanStr);
			pageDiv.append(ulStr);
		},error: function(data) {
			alert("系统错误，请联系管理员！");
		}
	});
}*/
