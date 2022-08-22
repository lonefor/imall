<%--
  Created by IntelliJ IDEA.
  User: Gao
  Date: 2022/8/1
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="header.jsp"%>
</head>
<body>
    <table class="layui-hide" id="test" lay-filter="layFilter"></table>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container">
            <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
            <button class="layui-btn layui-btn-sm" lay-event="deleteAll">批量删除</button>
        </div>
    </script>

    <script type="text/html" id="statusTpl">
        {{#    if(d.status==1) {         }}
                    在售
        {{#    } else if(status==2) {    }}
                    下架
        {{#    } else if(status==3) {    }}
                    删除
        {{#    } else{                   }}
                    未知
        {{#    }                         }}
    </script>

    <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test'
                ,url:'/product/selectByPage'
                ,toolbar: '#toolbarDemo'
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [[
                    {type:'checkbox', fixed: 'left'}
                    ,{field:'id', title: 'ID', sort: true}
                    ,{field:'name',  title: '用户名'}
                    ,{field:'main_image', title: '主图'}
                    ,{field:'price', title: '价格'}
                    ,{field:'stock', title: '库存'}
                    ,{field:'status', title: '状态', templet:"#statusTpl"}
                    ,{field:'createTime', title: '创建时间',templet:"<div>{{d.createTime?layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss'):'未知'}}</div>"}
                    ,{field:'updateTime', title: '更新创建',templet:"<div>{{d.createTime?layui.util.toDateString(d.createTime, 'yyyy-MM-dd'):'未知'}}</div>"}
                    ,{title:'操作', toolbar: '#barDemo'}
                ]]
                ,page: true
                ,id: 'tableId'
            });

            //监听工具条
            table.on('tool(layFilter)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        $.post(
                            '/product?method=deleteById',
                            {'id' : data.id},
                            function(jsonObj) {
                                console.log(jsonObj);
                                if (jsonObj.code == 0) {
                                    mylayer.okMsg(jsonObj.msg);
                                    // 删除之后重新刷新table表格
                                    table.reload('tableId');
                                } else {
                                    mylayer.errorMsg(jsonObj.msg);
                                }
                            },
                            'json'
                        );

                    });
                } else if(obj.event === 'edit'){
                    layer.open({
                        type : 2,
                        area : ['550px', '350px'],
                        // content: '${pageContext.request.contextPath}/user?method=getUserUpdatePage&id=' + data.id
                        content : '/product_update2.jsp?id='+ data.id
                    });
                }
            });

            //头工具栏事件
            table.on('toolbar(layFilter)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                switch(obj.event){
                    case 'add':
                        layer.open({
                            type : 2,
                            area : ['550px', '350px'],
                            content: '/product_add.jsp'
                        });
                        break;
                    case 'deleteAll':
                        var data = checkStatus.data;
                        // layer.alert(JSON.stringify(data));
                        // [{"id":5,"name":"23","password":"sd","age":0,"address":null},{"id":6,"name":"s","password":"sd","age":0,"address":null}]
                        var ids = [];
                        $(data).each(function() {
                            ids.push(this.id);
                        });
                        // [5,6]
                        // ids = ids.join(','); // "5,6"
                        layer.confirm('真的删除行么', function(index){
                            $.post(
                                '/product?method=deleteAll',
                                {'ids' : ids},
                                function(jsonObj) {
                                    console.log(jsonObj);
                                    if (jsonObj.code == 0) {
                                        mylayer.okMsg(jsonObj.msg);
                                        // 删除之后重新刷新table表格
                                        table.reload('tableId');
                                    } else {
                                        mylayer.errorMsg(jsonObj.msg);
                                    }
                                },
                                'json'
                            );

                        });
                        break;
                    //自定义头工具栏右侧图标 - 提示
                    case 'LAYTABLE_TIPS':
                        layer.alert('这是工具栏右侧自定义的一个图标按钮');
                        break;
                };
            });
        });
    </script>
</body>
</html>
