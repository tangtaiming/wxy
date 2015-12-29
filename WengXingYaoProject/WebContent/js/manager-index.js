// JavaScript Document
//祝福-编辑页面保存数据
var editRowSave = function (formId) {
	
	var _from = "#" + formId;
	//改变的页面
	function changeHtml(response) {
		var _changeDiv = $("#li010");
		_changeDiv.html(response);
	}
	
	//验证内容是否为空 长度
	function validateContext() {
		var $content = $("#blessing-content");
		var content = $content.val();
		$content.removeClass("err");
		content = $.trim(content);
		if (content == "") {
			$content.addClass("err");
			alert("祝福内容不能为空!");
			return false;
		}
		if (content.length > 400) {
			$content.addClass("err");
			alert("祝福内容字符不能超过 400.");
			return false;
		}
		return true;
	}
	
	function init() {
		var option = {
			type : 'post',
			success : function(transport) {
				changeHtml(transport);
			} ,
			error : function() {
				alert("edit blessing error!");
			}
		};
		if (validateContext()) {
			$(_from).ajaxSubmit(option);
		};
	}
	init();
};

var editRow = function (url, id) {
	var requestUrl = url + "/" + id;
	managerAjax(requestUrl);
};

var deleteRow = function(curElement) {
	var elementId = curElement.id;
	
	//初始化删除需要 数据
	function init() {
		var id = elementId.split("-")[2];
		deleteData(id);
	}
	
	//删除数据
	function deleteData (id) {
		if (confirm("Are you sure ?")) {
			alert("yes delete！");
			return;
		} 
		alert("no delete");
		return;
	}
	
	init();
};

//管理页面 ajax请求数据
var managerAjax = function(url, params, tempData) {
	
	//发送ajax请求
	function ajax(url, params) {
		$.ajax({
			url : url,
			data : params,
			success : function(response, textStatus) {
				changeHtml(response);
			},
			error : function() {
				alert("error!");
			}
		});
	}
	
	//改变的页面
	function changeHtml(response) {
		var _changeDiv = $("#li010");
		_changeDiv.html(response);
	}
	ajax(url, params);
	
};

var managerPageAjax = function(url, params, curPage) {

	//发送ajax请求
	function ajax(url, params) {
		$.ajax({
			url : url,
			data : "curPage=" + params,
			success : function(response, textStatus) {
				removeHtml();
				changeHtml(response);
			},
			error : function() {
				alert("error!");
			}
		});
	}
	
	//删除页面html
	function removeHtml() {
		$("#xt-table-001").detach();
		$("#xt-fenye-001").detach();
	}
	
	//改变的页面
	function changeHtml(response) {
		var _changeDiv = $("#xt-input-001");
		_changeDiv.after(response);
	}
	ajax(url, params);
	
};