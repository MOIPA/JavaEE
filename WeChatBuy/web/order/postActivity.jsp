<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/25
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta http-equiv="pragma" content="no-cache"  />
    <meta http-equiv="content-type" content="no-cache, must-revalidate" />
    <meta http-equiv="expires" content="Wed, 26 Feb 1997 08:21:57 GMT"/>

    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/ssi-uploaderV1.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/ssi-modal.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ssi-modal.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ssi-uploader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigator.css"/>
</head>

<body>
<jsp:include page="../head.jsp"/>

<div class="container" style="padding-top: 7%">
    <div class="jumbotron">
        <h2>发布活动</h2>
        <form role="form" id="postActivityForm" action="${pageContext.request.contextPath}/postactivity" method="post">
            <div class="form-group">
                <label for="theme">主题</label>
                <input type="text" class="form-control" name="theme" id="theme" placeholder="请输入主题">
            </div>
            <div class="form-group">
                <label for="endtime">截至日期</label>
                <input type="text" class="form-control" name="endtime" id="endtime" placeholder="请输入日期">
            </div>
            <div class="form-group">
                <label for="endtime">人数上限</label>
                <input type="text" class="form-control" name="peoplelimit" id="peoplelimit" placeholder="请输入人数上限">
            </div>
            <div class="form-group">
                <label for="desc">描述</label>
                <input type="text" class="form-control" name="desc" id="desc" placeholder="请输入描述">
            </div>
            <div class="form-group">
                <label for="ssi-upload">上传图片</label>
                <%--<input type="file" id="inputfile">--%>
                <input type="file" name="ssi-upload" multiple id="ssi-upload"/>
                <p class="help-block" >请选择产品描述图片</p>
                <input type="text" name="savedPicSrc" id="savedPicSrc" value="PicUrls:" style="display: none;">
            </div>

            <input type="button" id="fake_submit" class="btn btn-primary btn-lg" value="提交">
            <button type="submit" id="true_submit" class="btn btn-primary btn-lg" style="display: none">提交</button>
        </form>

        <script>
            $(function () {
                $("#postActivityForm").validate({
                    rules:{
                        "theme":{
                            "required":true
                        },
                        "endtime":{
                            "required":true
                        },
                        "desc":{
                            "required":true
                        },
                        "savedPicSrc":{
                            "required":true,
                            "minlength":9
                        },
                        "peoplelimit":{
                            "required":true
                        }
                    },
                    messages:{
                        "theme":{
                            "required":"请输入主题"
                        },
                        "endtime":{
                            "required":"请输入截至时间"
                        },
                        "desc":{
                            "required":"请输入描述"
                        },
                        "savedPicSrc":{
                            "required":"请上传图片",
                            "minlength":"请上传图片"
                        },
                        "peoplelimit":{
                            "required":"请输入人数限制"
                        }
                    }
                });
            });
        </script>

        <script>
            var options;
            var currentStep=0;
            ssi_modal.slideShow=function(opts,steps){
                var defaults={
                    nextBtnClassName:'',
                    prevBtnClassName:''
                };
                options=$.extend({},defaults,opts);
                var stepDefaults={
                    title:options.title,
                    content:'',
                    backdropClassName:'',
                    modalClassName:''
                };
                steps[0]=$.extend({},stepDefaults,steps[0]);
                options.buttons=[{
                    label:'Next',
                    side:'right',
                    className:options.nextBtnClassName,
                    method:function(event,modal){
                        if (currentStep < steps.length-1) {
                            currentStep++;
                            setModal(modal);
                        }
                    }
                },{
                    label:'Prev',
                    side:'left',
                    className:options.prevBtnClassName,
                    method:function(event,modal){
                        if (currentStep > 0) {
                            currentStep--;
                            setModal(modal);
                        }
                    }
                }];
                options.title=steps[0].title;
                options.content=steps[0].content;
                options.className=steps[0].modalClassName;
                options.backdropClassName=steps[0].backdropClassName;
                options.onClose = function (modal) {
                    currentStep = 0;
                    if (typeof opts.onClose === 'function') {
                        opts.onClose(modal);
                    }
                };
                var setModal=function(modal){
                    var thisStep=$.extend({},stepDefaults,steps[currentStep]);
                    modal.setTitle(thisStep.title);
                    modal.setContent(thisStep.content);
                    modal.get$modal().addClass(thisStep.modalClassName);
                    modal.get$backdrop().addClass(thisStep.backdropClassName);
                    if (typeof modal.options.onShow === 'function') {
                        modal.options.onShow();
                    }
                };
                ssi_modal.createObject(options).setPluginName('slideShow').init().show();
            };

            <%--$('#ssi-upload').ssi_uploader({--%>
            <%--url: 'http://localhost:8080/${pageContext.request.contextPath}/postorder'--%>
            <%--});--%>

            var submitAllInfo = function () {
                //回调成功点击提交按钮  1500ms后提交 优化用户体验
                setTimeout($("#true_submit").click(),1500);
                // alert($("#savedPicSrc").val());

            };

            $('#ssi-upload').ssi_uploader({
                url: 'http://localhost:8080/${pageContext.request.contextPath}/savepic',locale: "zh_CN",
                data:{
                    "name":"1"
                }
                ,
                onUpload: function () {
                    // submitAllInfo();
                    // alert("succeed");
                }
                // ,
                // onEachUpload: function (fileInfo) {
                //     console.log(fileInfo);
                //     ssi_modal.notify('error', $.extend({}, options, {
                //         classSize: 'auto',
                //         title: 'onEachUpload',
                //         position: 'bottom center',
                //         content: 'Status: ' + fileInfo.uploadStatus +
                //         '<br>Response: ' + fileInfo.responseMsg +
                //         '<br>name: ' + fileInfo.name +
                //         '<br>size: ' + fileInfo.size +
                //         '<br>type: ' + fileInfo.type
                //     }));
                // },
                // beforeUpload: function () {
                //     ssi_modal.notify('warning', $.extend({}, options, {
                //         title: 'onUpload',
                //         icon: false,
                //         position: 'top left'
                //     }));
                // }
                // ,
                // beforeEachUpload: function (fileInfo, xhr) {
                //     ssi_modal.notify('success', $.extend({}, options, {
                //         icon: false,
                //         sizeClass: 'small',
                //         title: 'beforeEachUpload',
                //         content: 'name:' + fileInfo.name +
                //         '<br>size: ' + fileInfo.size +
                //         '<br>type: ' + fileInfo.type
                //     }));
                // }
            });

            $("#ssi-uploadBtn").hide();
            $("#fake_submit").click(function () {
                if(!$("#postActivityForm").valid()){
                    return;
                }
               $("#ssi-uploadBtn").click();
            });
        </script>

    </div>
</div>
</body>

</html>
