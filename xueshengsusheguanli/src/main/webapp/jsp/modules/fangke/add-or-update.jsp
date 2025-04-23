<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">编辑访客</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">访客管理</li>
                        <li class="breadcrumb-item active">编辑访客</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">访客信息</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                            <!-- 级联表的字段 -->
                                    <div class="form-group col-md-6 aaaaaa sushe">
                                        <label>宿舍</label>
                                        <div>
                                            <select style="width: 450px" id="susheSelect" name="susheSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 sushe">
                                        <label>宿舍号</label>
                                        <input style="width: 450px" id="susheName" name="susheName" class="form-control"
                                               placeholder="宿舍号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 aaaaaa suguan">
                                        <label>宿管</label>
                                        <div>
                                            <select style="width: 450px" id="suguanSelect" name="suguanSelect"
                                                    class="selectpicker form-control"  data-live-search="true"
                                                    title="请选择" data-header="请选择" data-size="5" data-width="650px">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-6 suguan">
                                        <label>宿管姓名</label>
                                        <input style="width: 450px" id="suguanName" name="suguanName" class="form-control"
                                               placeholder="宿管姓名" readonly>
                                    </div>
                                    <div class="form-group col-md-6 suguan">
                                        <label>宿管手机号</label>
                                        <input style="width: 450px" id="suguanPhone" name="suguanPhone" class="form-control"
                                               placeholder="宿管手机号" readonly>
                                    </div>
                                    <div class="form-group col-md-6 suguan">
                                        <label>宿管头像</label>
                                        <img id="suguanPhotoImg" src="" width="100" height="100">
                                    </div>
                            <!-- 当前表的字段 -->
                                    <input id="updateId" name="id" type="hidden">
                                <input id="susheId" name="susheId" type="hidden">
                                <input id="suguanId" name="suguanId" type="hidden">
                                    <div class="form-group col-md-6 fangkeNameDiv">
                                        <label>访客姓名</label>
                                        <input style="width: 450px" id="fangkeName" name="fangkeName" class="form-control"
                                               placeholder="访客姓名">
                                    </div>
                                    <div class="form-group col-md-6 fangkePhoneDiv">
                                        <label>访客手机号</label>
                                        <input style="width: 450px" id="fangkePhone" name="fangkePhone" class="form-control"
                                               onchange="fangkePhoneChickValue(this)"  placeholder="访客手机号">
                                    </div>
                                    <div class="form-group col-md-6 fangkeIdNumberDiv">
                                        <label>访客身份证号</label>
                                        <input style="width: 450px" id="fangkeIdNumber" name="fangkeIdNumber" class="form-control"
                                               onchange="fangkeIdNumberChickValue(this)"  placeholder="访客身份证号">
                                    </div>
                                    <div class="form-group col-md-6 sexTypesDiv">
                                        <label>性别</label>
                                        <select style="width: 450px" id="sexTypesSelect" name="sexTypes" class="form-control">
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6 fangkePhotoDiv">
                                        <label>健康码</label>
                                        <img id="fangkePhotoImg" src="" width="100" height="100">
                                        <input name="file" type="file" id="fangkePhotoupload"
                                               class="form-control-file">
                                        <input name="fangkePhoto" id="fangkePhoto-input" type="hidden">
                                    </div>
                                    <div class="form-group  col-md-6 fangkeContentDiv">
                                        <label>来访事由</label>
                                        <input id="fangkeContentupload" name="file" type="file">
                                        <script id="fangkeContentEditor" type="text/plain"
                                                style="width:100%;height:230px;"></script>
                                        <script type = "text/javascript" >
                                        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
                                        //相见文档配置属于你自己的编译器
                                        var fangkeContentUe = UE.getEditor('fangkeContentEditor', {
                                            toolbars: [
                                                [
                                                    'undo', //撤销
                                                    'bold', //加粗
                                                    'redo', //重做
                                                    'underline', //下划线
                                                    'horizontal', //分隔线
                                                    'inserttitle', //插入标题
                                                    'cleardoc', //清空文档
                                                    'fontfamily', //字体
                                                    'fontsize', //字号
                                                    'paragraph', //段落格式
                                                    'inserttable', //插入表格
                                                    'justifyleft', //居左对齐
                                                    'justifyright', //居右对齐
                                                    'justifycenter', //居中对
                                                    'justifyjustify', //两端对齐
                                                    'forecolor', //字体颜色
                                                    'fullscreen', //全屏
                                                    'edittip ', //编辑提示
                                                    'customstyle', //自定义标题
                                                ]
                                            ]
                                        });
                                        </script>
                                        <input type="hidden" name="fangkeContent" id="fangkeContent-input">
                                    </div>
                                    <div class="form-group col-md-12 mb-3">
                                        <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                        <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" charset="utf-8"
                 src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/laydate.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "fangke";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};


    // 下拉框数组
        <!-- 当前表的下拉框数组 -->
    var sexTypesOptions = [];
        <!-- 级联表的下拉框数组 -->
    var susheOptions = [];
    var suguanOptions = [];

    var ruleForm = {};


    // 文件上传
    function upload() {

        <!-- 当前表的文件上传 -->
        $('#fangkePhotoupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                var photoUrl= baseUrl + 'file/download?fileName=' + data.result.file;
                document.getElementById('fangkePhotoImg').setAttribute('src',photoUrl);
                document.getElementById('fangkePhoto-input').setAttribute('value',photoUrl);
            }
        });


        $('#fangkeContentupload').fileupload({
            url: baseUrl + 'file/upload',
            headers: {token: window.sessionStorage.getItem("token")},
            dataType: 'json',
            done: function (e, data) {
                UE.getEditor('fangkeContentEditor').execCommand('insertHtml', '<img src=\"' + baseUrl + 'upload/' + data.result.file + '\" width=900 height=560>');
            }
        });


    }

    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            getContent();
            if(window.sessionStorage.getItem('role') != '宿舍'){//当前登录用户不为这个
                if($("#susheId") !=null){
                    var susheId = $("#susheId").val();
                    if(susheId == null || susheId =='' || susheId == 'null'){
                        alert("宿舍不能为空");
                        return;
                    }
                }
            }
            if(window.sessionStorage.getItem('role') != '宿管'){//当前登录用户不为这个
                if($("#suguanId") !=null){
                    var suguanId = $("#suguanId").val();
                    if(suguanId == null || suguanId =='' || suguanId == 'null'){
                        alert("宿管不能为空");
                        return;
                    }
                }
            }
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            let json = JSON.stringify(data);
            var urlParam;
            var successMes = '';
            if (updateId != null && updateId != "null" && updateId != '') {
                urlParam = 'update';
                successMes = '修改成功';
            } else {
                urlParam = 'save';
                    successMes = '添加成功';

            }
            httpJson("fangke/" + urlParam, "POST", data, (res) => {
                if(res.code == 0){
                    window.sessionStorage.removeItem('addfangke');
                    window.sessionStorage.removeItem('updateId');
                    let flag = true;
                    if (flag) {
                        alert(successMes);
                    }
                    if (window.sessionStorage.getItem('onlyme') != null && window.sessionStorage.getItem('onlyme') == "true") {
                        window.sessionStorage.removeItem('onlyme');
                        window.sessionStorage.setItem("reload","reload");
                        window.parent.location.href = "${pageContext.request.contextPath}/index.jsp";
                    } else {
                        window.location.href = "list.jsp";
                    }
                }
            });
        } else {
            alert("表单未填完整或有错误");
        }
    }

    // 查询列表
        <!-- 查询当前表的所有列表 -->
        function sexTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types", "GET", {}, (res) => {
                if(res.code == 0){
                    sexTypesOptions = res.data.list;
                }
            });
        }
        <!-- 查询级联表的所有列表 -->
        function susheSelect() {
            //填充下拉框选项
            http("sushe/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    susheOptions = res.data.list;
                }
            });
        }

        function susheSelectOne(id) {
            http("sushe/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                susheShowImg();
                susheShowVideo();
                susheDataBind();
            }
        });
        }
        function suguanSelect() {
            //填充下拉框选项
            http("suguan/page?page=1&limit=100&sort=&order=", "GET", {}, (res) => {
                if(res.code == 0){
                    suguanOptions = res.data.list;
                }
            });
        }

        function suguanSelectOne(id) {
            http("suguan/info/"+id, "GET", {}, (res) => {
                if(res.code == 0){
                ruleForm = res.data;
                suguanShowImg();
                suguanShowVideo();
                suguanDataBind();
            }
        });
        }



    // 初始化下拉框
    <!-- 初始化当前表的下拉框 -->
        function initializationSextypesSelect(){
            var sexTypesSelect = document.getElementById('sexTypesSelect');
            if(sexTypesSelect != null && sexTypesOptions != null  && sexTypesOptions.length > 0 ){
                for (var i = 0; i < sexTypesOptions.length; i++) {
                    sexTypesSelect.add(new Option(sexTypesOptions[i].indexName,sexTypesOptions[i].codeIndex));
                }
            }
        }

        function initializationsusheSelect() {
            var susheSelect = document.getElementById('susheSelect');
            if(susheSelect != null && susheOptions != null  && susheOptions.length > 0 ) {
                for (var i = 0; i < susheOptions.length; i++) {
                        susheSelect.add(new Option(susheOptions[i].susheName, susheOptions[i].id));
                }

                $("#susheSelect").change(function(e) {
                        susheSelectOne(e.target.value);
                });
            }

        }

        function initializationsuguanSelect() {
            var suguanSelect = document.getElementById('suguanSelect');
            if(suguanSelect != null && suguanOptions != null  && suguanOptions.length > 0 ) {
                for (var i = 0; i < suguanOptions.length; i++) {
                        suguanSelect.add(new Option(suguanOptions[i].suguanName, suguanOptions[i].id));
                }

                $("#suguanSelect").change(function(e) {
                        suguanSelectOne(e.target.value);
                });
            }

        }



    // 下拉框选项回显
    function setSelectOption() {

        <!-- 当前表的下拉框回显 -->

        var sexTypesSelect = document.getElementById("sexTypesSelect");
        if(sexTypesSelect != null && sexTypesOptions != null  && sexTypesOptions.length > 0 ) {
            for (var i = 0; i < sexTypesOptions.length; i++) {
                if (sexTypesOptions[i].codeIndex == ruleForm.sexTypes) {//下拉框value对比,如果一致就赋值汉字
                        sexTypesSelect.options[i].selected = true;
                }
            }
        }
        <!--  级联表的下拉框回显  -->
            var susheSelect = document.getElementById("susheSelect");
            if(susheSelect != null && susheOptions != null  && susheOptions.length > 0 ) {
                for (var i = 0; i < susheOptions.length; i++) {
                    if (susheOptions[i].id == ruleForm.susheId) {//下拉框value对比,如果一致就赋值汉字
                        susheSelect.options[i+1].selected = true;
                        $("#susheSelect" ).selectpicker('refresh');
                    }
                }
            }
            var suguanSelect = document.getElementById("suguanSelect");
            if(suguanSelect != null && suguanOptions != null  && suguanOptions.length > 0 ) {
                for (var i = 0; i < suguanOptions.length; i++) {
                    if (suguanOptions[i].id == ruleForm.suguanId) {//下拉框value对比,如果一致就赋值汉字
                        suguanSelect.options[i+1].selected = true;
                        $("#suguanSelect" ).selectpicker('refresh');
                    }
                }
            }
    }


    // 填充富文本框
    function setContent() {

        <!-- 当前表的填充富文本框 -->
        if (ruleForm.fangkeContent != null && ruleForm.fangkeContent != 'null' && ruleForm.fangkeContent != '' && $("#fangkeContentupload").length>0) {

            var fangkeContentUeditor = UE.getEditor('fangkeContentEditor');
            fangkeContentUeditor.ready(function () {
                var mes = '';
                if(ruleForm.fangkeContent != null){
                    mes = ''+ ruleForm.fangkeContent;
                    // mes = mes.replace(/\n/g, "<br>");
                }
                fangkeContentUeditor.setContent(mes);
            });
        }
    }
    // 获取富文本框内容
    function getContent() {

        <!-- 获取当前表的富文本框内容 -->
        if($("#fangkeContentupload").length>0) {
            var fangkeContentEditor = UE.getEditor('fangkeContentEditor');
            if (fangkeContentEditor.hasContents()) {
                $('#fangkeContent-input').attr('value', fangkeContentEditor.getContent());
            }
        }
    }
    //数字检查
        <!-- 当前表的数字检查 -->
        function fangkePhoneChickValue(e){
            var this_val = e.value || 0;
            var reg=/^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("手机号不正确");
                return false;
            }
        }
        function fangkeIdNumberChickValue(e){
            var this_val = e.value || 0;
            var reg=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
            if(!reg.test(this_val)){
                e.value = "";
                alert("身份证号不正确");
                return false;
            }
        }



    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.sessionStorage.removeItem('addfangke');
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                susheId: "required",
                suguanId: "required",
                fangkeName: "required",
                fangkePhone: "required",
                fangkeIdNumber: "required",
                sexTypes: "required",
                fangkePhoto: "required",
                fangkeContent: "required",
            },
            messages: {
                susheId: "宿舍不能为空",
                suguanId: "宿管不能为空",
                fangkeName: "访客姓名不能为空",
                fangkePhone: "访客手机号不能为空",
                fangkeIdNumber: "访客身份证号不能为空",
                sexTypes: "性别不能为空",
                fangkePhoto: "健康码不能为空",
                fangkeContent: "来访事由不能为空",
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var addfangke = window.sessionStorage.getItem("addfangke");
        if (addfangke != null && addfangke != "" && addfangke != "null") {
            //注册表单验证
            $(validform());

            $('#submitBtn').text('新增');

        } else {
            $('#submitBtn').text('修改');
            var userId = window.sessionStorage.getItem('userId');
            updateId = userId;//先赋值登录用户id
            var uId  = window.sessionStorage.getItem('updateId');//获取修改传过来的id
            if (uId != null && uId != "" && uId != "null") {
                //如果修改id不为空就赋值修改id
                updateId = uId;
            }
            window.sessionStorage.removeItem('updateId');
            http("fangke/info/" + updateId, "GET", {}, (res) => {
                if(res.code == 0)
                {
                    ruleForm = res.data
                    // 是/否下拉框回显
                    setSelectOption();
                    // 设置图片src
                    showImg();
                    // 设置视频src
                    showVideo();
                    // 数据填充
                    dataBind();
                    // 富文本框回显
                    setContent();
                    //注册表单验证
                    $(validform());
                }

            });
        }
    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    function dateTimePick() {
        var insertTime = laydate.render({
            elem: '#insertTime-input'
            ,type: 'datetime'
        });
    }


    function dataBind() {


    <!--  级联表的数据回显  -->
        susheDataBind();
        suguanDataBind();


    <!--  当前表的数据回显  -->
        $("#updateId").val(ruleForm.id);
        $("#susheId").val(ruleForm.susheId);
        $("#suguanId").val(ruleForm.suguanId);
        $("#fangkeName").val(ruleForm.fangkeName);
        $("#fangkePhone").val(ruleForm.fangkePhone);
        $("#fangkeIdNumber").val(ruleForm.fangkeIdNumber);
        $("#fangkeContent").val(ruleForm.fangkeContent);

    }
    <!--  级联表的数据回显  -->
    function susheDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#susheId").val(ruleForm.id);

        $("#susheNumberUuid").val(ruleForm.susheNumberUuid);
        $("#louyuValue").val(ruleForm.louyuValue);
        $("#susheName").val(ruleForm.susheName);
        $("#susheLouceng").val(ruleForm.susheLouceng);
        $("#susheAddress").val(ruleForm.susheAddress);
        $("#kezhuNumber").val(ruleForm.kezhuNumber);
        $("#yizhuNumber").val(ruleForm.yizhuNumber);
    }

    function suguanDataBind(){

                    <!-- 把id赋值给当前表的id-->
        $("#suguanId").val(ruleForm.id);

        $("#suguanName").val(ruleForm.suguanName);
        $("#suguanPhone").val(ruleForm.suguanPhone);
        $("#suguanEmail").val(ruleForm.suguanEmail);
    }


    //图片显示
    function showImg() {
        <!--  当前表的图片  -->
        $("#fangkePhotoImg").attr("src",ruleForm.fangkePhoto);

        <!--  级联表的图片  -->
        susheShowImg();
        suguanShowImg();
    }


    <!--  级联表的图片  -->

    function susheShowImg() {
    }


    function suguanShowImg() {
        $("#suguanPhotoImg").attr("src",ruleForm.suguanPhoto);
    }



    //视频回显
    function showVideo() {
    <!--  当前表的视频  -->

    <!--  级联表的视频  -->
        susheShowVideo();
        suguanShowVideo();
    }


    <!--  级联表的视频  -->

    function susheShowVideo() {
    }

    function suguanShowVideo() {
        $("#suguanPhotoV").attr("src",ruleForm.suguanPhoto);
    }



    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //查询所有下拉框
            <!--  当前表的下拉框  -->
            sexTypesSelect();
            <!-- 查询级联表的下拉框(用id做option,用名字及其他参数做名字级联修改) -->
            susheSelect();
            suguanSelect();



        // 初始化下拉框
            <!--  初始化当前表的下拉框  -->
            initializationSextypesSelect();
            <!--  初始化级联表的下拉框  -->
            initializationsusheSelect();
            initializationsuguanSelect();

        $(".selectpicker" ).selectpicker('refresh');
        getDetails();
        //初始化上传按钮
        upload();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
        window.sessionStorage.removeItem('addfangke');
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') == '管理员') {
            //$('#jifen').attr('readonly', 'readonly');
            //$('#role').attr('style', 'pointer-events:none;width:450px;');
        }
		else if (window.sessionStorage.getItem('role') == '学生') {
            // $(".aaaaaa").remove();
            $(".xuesheng").remove();//删除当前用户的信息
        }
		else if (window.sessionStorage.getItem('role') == '宿管') {
            // $(".aaaaaa").remove();
            $(".suguan").remove();//删除当前用户的信息
        }
        else{
            // alert("未知情况.......");
            // var replyTextUeditor = UE.getEditor('replyTextEditor');
            // replyTextUeditor.ready(function () {
            //     replyTextUeditor.setDisabled('fullscreen');
            // });
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>
