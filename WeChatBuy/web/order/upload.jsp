<%--
  Created by IntelliJ IDEA.
  User: tassa
  Date: 2018/4/26
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/ssi-uploader.js"></script>
    <script src="${pageContext.request.contextPath}/js/ssi-modal.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ssi-modal.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ssi-uploader.css"/>
</head>
<body>
    <%--Basic:--%>
    <%--<form id="myForm" action="${pageContext.request.contextPath}/postorder" method="post">--%>
        <input type="file" name="ssi-upload" multiple id="ssi-upload"/>
        <%--<button id="upBtn">Up</button>--%>
    <%--</form>--%>
</body>
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

    $('#ssi-upload').ssi_uploader({
        url: 'http://localhost:8080/${pageContext.request.contextPath}/postorder',
        onUpload: function () {
            ssi_modal.notify('info', $.extend({}, options, {
                title: 'onUpload',
                icon: false,
                position: 'top center'
            }));
        },
        onEachUpload: function (fileInfo) {
            console.log(fileInfo);
            ssi_modal.notify('error', $.extend({}, options, {
                classSize: 'auto',
                title: 'onEachUpload',
                position: 'bottom center',
                content: 'Status: ' + fileInfo.uploadStatus +
                '<br>Response: ' + fileInfo.responseMsg +
                '<br>name: ' + fileInfo.name +
                '<br>size: ' + fileInfo.size +
                '<br>type: ' + fileInfo.type
            }));
        },
        beforeUpload: function () {
            ssi_modal.notify('warning', $.extend({}, options, {
                title: 'onUpload',
                icon: false,
                position: 'top left'
            }));
        },
        beforeEachUpload: function (fileInfo, xhr) {
            ssi_modal.notify('success', $.extend({}, options, {
                icon: false,
                sizeClass: 'small',
                title: 'beforeEachUpload',
                content: 'name:' + fileInfo.name +
                '<br>size: ' + fileInfo.size +
                '<br>type: ' + fileInfo.type
            }));
        }
    });
</script>
</html>
