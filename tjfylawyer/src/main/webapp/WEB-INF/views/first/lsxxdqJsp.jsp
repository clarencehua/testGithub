<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>律师一卡通信息读取系统</title>

		<meta name="viewport" content="width=device-width" />
		<meta name="description" content="The Curriculum Vitae of Joe Bloggs." />
		<meta charset="UTF-8">

		<!-- <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet' type='text/css'> -->

		<!--[if lt IE 9]>
<script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
		<script type="text/javascript" src="${basePath}resources/js/jquery.js">
</script>
		<script language="javascript" src="${basePath}resources/js/lawyer-card.js">
</script>
		<script language="javascript" for="LawyerCardReader" event="OnCardIn"
			src="${basePath}resources/js/cardin.js">
</script>
		<script language="javascript" for="LawyerCardReader" event="OnCardOut"
			src="${basePath}resources/js/cardout.js">
</script>

		<script type="text/javascript">
		
var lawyerCardService = new LawyerCardService();
lawyerCardService.incard = function(uid) {
	var lawyer = loadInfo();
}
function loadInfo() {
	//alert("helosss");
	alert("helo");
	var lawyer = lawyerCardService.loadData();
	//var number=lawyer.licenseNumber+"你好";
	//console.log(number);
	if (lawyer != null) {
		alert("helo");
		//console.log("1111"+lawyer.name);
		$('#lawyerName').text(
				lawyer.name + "（" + (lawyer.gender == 1 ? "男" : "女") + "）");
		$('#lawyerLicense').text(lawyer.licenseNumber);
		$('#lawFirmName').text(lawyer.organization);
		$('#practiceStatus').text(lawyer.practiceStatus == 1 ? "正常执业" : "非正常");
		$('#assessmentStatus').text("称职");
		//alert($('#lawyerLicense').text(lawyer.licenseNumber));
		send(lawyer.licenseNumber,lawyer.name);
		showMessage("读取信息完毕");
	} else {
		showMessage("读取信息失败");
	}
	
	//showMessage("读取相片....");
	//setTimeout(loadPhoto,50);
}
function send(id,name){
	//console.log(id);
	var id=id;
	var name=name;
	$.ajax({
		type: "GET", 
		url:'index.aj',
		contentType : "application/json; charset=utf-8",//application/xml
		processData : true,//contentType为xml时，些值为false
		dataType : "html",//json--返回json数据类型；xml--返回xml
		data:{
			id: id,
			name:name,
		},
		success:function(msg){
			//data=$.parseJSON(msg);
			//alert(msg);
			$('#zzh').html(msg);
		}
	});
	
}
function loadPhoto() {
	lawyerCardService.stopListen();
	console.log(1);
	try {
		var photo = lawyerCardService.loadPhoto();
		if (photo == null) {
			showMessage("读取相片失败");
			reset();
			return;
		}
		$('#photoImg').attr('src', "data:image/png;base64," + photo);
		saveFile("photos/"+curUID,photo);
	} catch (e) {

	}
	showMessage("读取信息完毕");
	lawyerCardService.startListen();
}

function start() {
	showMessage('请放置会员卡');
	lawyerCardService.startListen();
}

lawyerCardService.outcard = function() {
	reset();
}
function reset() {
	showMessage('请放置会员卡');

	$('#lawyerName').text("");
	$('#lawyerLicense').text("");
	$('#lawFirmName').text("");
	$('#practiceStatus').text("");
	$('#assessmentStatus').text("");
	$('#photoImg').attr('src', 'img/white_background.jpg');
		 		$('#red').attr('src','./images/grey.png');
		 		$('#green').attr('src','./images/grey.png');
}

function showMessage(msg) {
	document.getElementById('msgTip').innerText = msg;
}
</script>

	<body id="top" style="overflow:hidden;">
		<div style="text-align: center" class="mainDetails">
			<h1 style="font-size: 32px" class="quickFade delayTwo">
				律师一卡通扫描读取
			</h1>
		</div>
		<div id="cv" class="instaFade">
			<div class="mainDetails">
				<!-- <div style="display: inline-block; float: left" class="quickFade">
					<img id="photoImg" width="110" height="110" />
				</div> -->

				<div style="text-align: center">
					<h1 id="msgTip" style="color: red; font-size: 24px"
						class="quickFade delayTwo">
						请放置会员卡
					</h1>
				</div>

				<div class="clear"></div>
			</div>

			<div id="mainArea" class="quickFade delayFive" style="background: gainsboro;">
				<table style="width: 1000px;margin-left: 150px;">
					<tr>
						<td>
							<lable style="font-size: 32px;margin-left:50px;">姓    名:</lable>
							<lable id="lawyerName" style="font-size:30px;">张三</lable>
						</td>
					</tr>
					<tr>
						<td>
							<lable style="font-size: 32px;">一卡通号:</lable>
							<lable id="lawyerLicense" style="font-size:30px;">14403200831507763</lable>
						</td>
						<td>
							<lable style="font-size: 32px;">所属公司:</lable>
							<lable id="lawFirmName" style="font-size:30px;">阿斯古德寺哦啊力度都说的</lable>
						</td>
					</tr>
					<tr>
						<td>
							<lable style="font-size: 32px;">考核结果:</lable>
							<lable id="assessmentStatus" style="font-size:30px;;">asdsad</lable>
						</td>
						<td>
							<lable style="font-size: 32px;">执业资格:</lable>
							<lable id="practiceStatus" style="font-size:30px;">asdsad</lable>
						</td>
					</tr>
				</table>
			</div>
		</div>
		
		<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl."
		: "http://www.");
document
		.write(unescape("%3Cscript src='"
				+ gaJsHost
				+ "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
		<script type="text/javascript">
// var pageTracker = _gat._getTracker("UA-3753241-1");
// pageTracker._initData();
// pageTracker._trackPageview();

setTimeout(start, 100);
</script>
  <!-- <input type="button" onclick="send()" value="牛逼宝贝">   --> 
	<div id = "zzh" style="margin-top:30px;"></div>
	</body>
<link rel="stylesheet" href="${basePath}basePath/css/LawyerStyle.css" type="text/css"></link>

</html>
