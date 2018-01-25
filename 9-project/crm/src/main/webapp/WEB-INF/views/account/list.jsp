<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>凯盛软件CRM-首页</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 	<%@ include file="../include/css.jsp"%> 
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

 <%@ include file="../include/header.jsp"%> 
 <%@ include file="../include/sider.jsp"%> 
  <!-- =============================================== -->

  <!-- 右侧内容部分 -->
  <div class="content-wrapper">

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-md-2">
            <div class="box">
              <div class="box-body">
                <button class="btn btn-default">添加部门</button>
                <ul id="ztree" class="ztree"></ul>
              </div>
            </div>
        </div>
        <div class="col-md-10">
            <!-- Default box -->
            <div class="box">
              <div class="box-header with-border">
                <h3 class="box-title">员工管理</h3>
                <div class="box-tools pull-right">
                  <button type="button" class="btn btn-box-tool"  title="Collapse">
                    <i class="fa fa-plus"></i> 添加员工</button>
                </div>
              </div>
              <div class="box-body">
                <table class="table">
                  <thead>
                    <tr>
                      <th>姓名</th>
                      <th>部门</th>
                      <th>手机</th>
                      <th>#</th>
                    </tr>
                  </thead>
				  <tbody>
            <tr>
              <td>tom</td>
              <td>开发部</td>
              <td>153223234522</td>
              <td>
                <a href="">禁用</a>
                <a href="">删除</a>
                <a href="">编辑</a>
              </td>
            </tr>
				  </tbody>
                </table>
              </div>
            </div>
            <!-- /.box -->
        </div>
      </div>

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- 底部 -->
  <%@ include file="../include/footer.jsp"%> 

</div>
<!-- ./wrapper -->

<%@ include file="../include/css.jsp"%> 
<script src="/static/plugins/tree/js/jquery.ztree.all.min.js"></script>
<script>
  $(function(){
    var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			  callback:{
				onClick:function(event,treeId,treeNode,clickFlag){
					alert(treeNode.id + treeNode.name + treeNode.pId);
				}
			  }
		};

		var zNodes =[
			{ id:1, pId:0, name:"凯盛软件", open:true},
			{ id:11, pId:1, name:"开发部"},
			{ id:111111, pId:11, name:"华北开发部"},
			{ id:111, pId:1, name:"销售部"},
			{ id:112, pId:1, name:"经理办公室"}
		];
    $.fn.zTree.init($("#ztree"), setting, zNodes);
  });
</script>
</body>
</html>
    