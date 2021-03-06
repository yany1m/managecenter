<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina"> 

    <title>权限</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" class="">
      <!--header start-->
      <#include "head.ftl"/>
      <!--header end-->
      <!--sidebar start-->
      <#include "left.ftl"/>
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!-- page start-->
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                      	
                          <header class="panel-heading">
                           权限
                          <a href="/managecenter/addPermission"><button type="button" class="btn btn-info" style="float:right;">添加</button></a>
                          </header>
                                                                        	 
                          <table class="table table-striped border-top" id="sample_1">
                          <thead>
                          <tr>                              
                              <th class="hidden-phone">名称</th> 
                              <th class="hidden-phone">权限</th>                             
                              <th class="hidden-phone">父级名称</th>
                              <th>父级</th>                                                      
                              <th class="hidden-phone"></th>
                          </tr>
                          </thead>
                          <tbody>
                          <#list list as permission>
                         	<tr class="odd gradeX">                                                         
                              <td class="center hidden-phone">${permission.permission_name}</td>
                              <td class="hidden-phone">${permission.permission}</td>                             
                              <td class="hidden-phone">${permission.parent_name}</td>
                              <td>${permission.parent}</td>
                              <td class="hidden-phone">
								<a href="/managecenter/updatePermission?id=${permission.id}&permissionName=${permission.permission_name}&permission=${permission.permission}&parentName=${permission.parent_name}&parent=${permission.parent}"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
								<button onclick='if(confirm("确认删除")){deletePermission(this)}' id="id=${permission.id}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>
							  </td>
                          </tr>
                          </#list>
                          </tbody>
                          </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

    <!--script for this page only-->
    <script src="js/dynamic-table.js"></script>
	<script type="text/javascript">
	function deletePermission(which){
			
			$.post("/managecenter/deletePermission",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/getPermission";
    			}
 		 });
	}
	</script>


  </body>
</html>
