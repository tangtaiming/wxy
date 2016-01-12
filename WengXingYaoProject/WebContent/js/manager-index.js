// JavaScript Document
var loginout = function() {
	
	function initLoginOut() {
		window.location.href = "/user/loginOut";
	}
	initLoginOut();
	
};

var editRowSaveThank = function(formId) {
	var _from = "#" + formId;
	function ajax() {
		var option = {
			type : 'post',
			success : function(transport) {
				changeHtml(transport);
			},
			error : function() {
				alert("save edit error!");
			}
		};
		if (validate()) {
			$(_from).ajaxSubmit(option);
		}
	};
	
	//改变的页面
	function changeHtml(response) {
		var _changeDiv = $("#li010");
		_changeDiv.html(response);
	}
	
	ajax();
};

//目前这个对象值对 textarea对象 input对象进行验证 日后更具需求添加
function validate() {
	//获取表单对象
	var _input = $("input[id*='-entity-']");	//用来获取input 对象集合
	var _textareas = $("textarea[id*='-entity-']"); //用来获取textareas 对象集合
	
	//把获取的对象放入到一个对象中
	var all_dom = _input.add(_textareas);
	var is_zroe = true;
	$.each(all_dom, function(num, dom) {
		//删除对应错误提示
		$(dom).removeClass("err");
		//获取对象是否是必须的
		var _must = $(dom).attr("must");
		if (_must != "") {
			//判断对象值
			if ($(dom).val() == "") {
				var _label = $("label[for='" + dom.id + "']");
				alert(_label.html() + "不能为空!");
				$(dom).addClass("err");
				is_zroe = false;
				return false;
			}
		}
	});
	return is_zroe;
};

//祝福-编辑页面保存数据
var editRowSave = function (formId) {
	
	var _from = "#" + formId;
	//截取获取对应编辑页面的ID
//	var _value = formId.split("-")[2];
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
				removeHtml(url);
				changeHtml(url, response);
			},
			error : function() {
				alert("error!");
			}
		});
	}
	
	//删除页面html
	function removeHtml(url) {
		if (url == "/b/blessingManagerPageByIndex") {
			$("#ttm_con_page_data").empty();
		} 
		if (url == "/b/blessingManagerPage") {
			$("#xt-table-001").detach();
		}
		
	}
	
	//改变的页面
	function changeHtml(url, response) {
		if (url == "/b/blessingManagerPageByIndex") {
			var _changeDiv = $("#ttm_con_page_data");
			_changeDiv.append(response);
		}
		if (url == "/b/blessingManagerPage") {
			var _changeDiv = $("#xt-input-001");
			_changeDiv.after(response);
		}
	}
	ajax(url, params);
	
};