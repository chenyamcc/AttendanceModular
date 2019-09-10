
/**
 * 审批详情(办公用品审批)
 *
 * @param asid
 */

$(function(){
	$(".details").click(function(){

		overtimeHTML();
		var id=$(this).attr("smid")
		var rid=$(this).attr("rid")
		$("#overtimeDivModel #rid").val(rid);
		$.ajax({
			url: "/getsubscribExamine",
			type: "POST",
			data:{id :id},
			dataType: "JSON",
			success: function(data) {
				//虽然后台获取的时间已经是date类型，但是由于通过json后，需要再一次转为date类型
				var subscribtime = new Date(data.subscribtime);
				var rid
				$("#overtimeDivModel #examine").val(data.smid);
				$("#overtimeDivModel #subscribtime").val(subscribtime.format('yyyy-MM-dd h:mm:ss'));
				$("#overtimeDivModel #goods").val(data.goods);
				$("#overtimeDivModel #des").val(data.edescribe);
			}, error: function(data) {
				
			}
		});
	})
	
	
})




/**
 * 验证日期格式
 */
function validate(){
	
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	var st = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (startTime != '' && !st.test(startTime)){
		alert("请输入正确的开始日期格式");
		return false;
	}
	var et = /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01]) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	if (endTime != '' && !et.test(endTime)){
		alert("请输入正确的结束日期格式");
		return false;
	}
	var d1 = Date.parse(startTime);
	var d2 = Date.parse(endTime);
	var date = d2 - d1;
	var time = 60*60*1000;
	if(date<0||date<time){
		alert("开始时间应小于结束时间并且间隔小于一小时,请检查!");
		return false;
	}
	return true;
}

/**
 * 申购审批
 * @param path
 */
function examineStatus(choice) {
	var smid = $("#examine").val();
	var rid=$("#rid").val();
	
	if(choice==0){
		if(rid==1){var asid=3}
		if(rid==2){var asid =2}	
	}
	if(choice==1){
		var asid=4
	}
	
	$.ajax({
		url: "/modifysubscribExamine",
		type: "POST",
		data:{smid:smid,asid:asid,rid:rid},
		success: function(data) {
			location.href='/subscribExamine?rid='+data
		}, error: function(data) {
		}
	});
}
	
/**
 * 加班HTML
 * @param path
 */
function overtimeHTML() {
	// 检查当前页面是否弹层，如果有则删除
	if($('#overtimeDivModel') != null && $('#overtimeDivModel') != undefined)
		$('#overtimeDivModel').remove();
	
	var style_ = 'width: 500px; height: 300px; z-index: 1000; position: fixed; top: 50%;margin-top:-150px; left: 50%;margin-left: -300px;background: #fff;border: 1px solid rgba(39, 38, 38, 0.31);border-radius: 10px;padding: 15px;';
	var overtimeHtml = '<div id="overtimeDivModel" style="' + style_ + '">';
	overtimeHtml += '<div class="form-horizontal" role="form">';
	overtimeHtml += '<input type="hidden" id="overtimeId" value=""/>';
	overtimeHtml += '<input type="hidden" id="examine" value=""/>';
	overtimeHtml += '<input type="hidden" id="status" value=""/>';
	overtimeHtml += '<input type="hidden" id="rid" value=""/>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="subscribTime" class="col-sm-3 control-label">申购时间</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="subscribtime"  readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="goods" class="col-sm-3 control-label">申购物品</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="goods" readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<label for="des" class="col-sm-3 control-label">申购描述</label>';
	overtimeHtml += '<div class="col-sm-9">';
	overtimeHtml += '<input type="text" class="form-control" id="des" value="工作未完成" readonly="readonly">';
	overtimeHtml += '</div></div>';
	overtimeHtml += '<div class="form-group">';
	overtimeHtml += '<div class="col-sm-12" style="text-align: center;">';
	/*已审批=3，未通过=4，审批中=2，未审批=1（默认）*/
	overtimeHtml += '<input type="button" class="btn btn-primary btn" id="a" value="同意" onclick="examineStatus(0);" style="margin-left: 30px;"></input>';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" id="b" value="拒绝" onclick="examineStatus(1);" style="margin-left: 30px;"/>';
	overtimeHtml += '<input type="button" class="btn btn-primary btn" value="关闭" onclick="javascript:$(\'#overtimeDivModel\').remove();" style="margin-left: 30px;"/>';
	overtimeHtml += '</div></div>';
	overtimeHtml += '</div></div>';
	$("body").append(overtimeHtml);
}
/**
 * 
 * 日期格式转换
 */
Date.prototype.format = function(format) {
    var date = {
           "M+": this.getMonth() + 1,
           "d+": this.getDate(),
           "h+": this.getHours(),
           "m+": this.getMinutes(),
           "s+": this.getSeconds(),
           "q+": Math.floor((this.getMonth() + 3) / 3),
           "S+": this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
           format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    for (var k in date) {
           if (new RegExp("(" + k + ")").test(format)) {
                  format = format.replace(RegExp.$1, RegExp.$1.length == 1
                         ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
           }
    }
    return format;
}