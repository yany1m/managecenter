<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina"> 

    <title>管理组权限</title>

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
                             管理组权限
                          </header>
                         
                         <div class="panel-body">
                        
                         <label class="control-label col-lg-2" for="inputSuccess"></label>
                         	<div class="col-lg-10" style="float:none">
                            	<select id="group" class="form-control m-bot15"> 
               
                                	<#list adminGroupList as list>
                                		<#if Session.admin_group_id=list.id>
                                		<option value="${list.id}" selected="selected">${list.name}</option>
                                		<#else>                                          
                                    	<option value="${list.id}">${list.name}</option>                                             
                                    	</#if>
                                    </#list>                                            
                                </select>
                            </div>
                         <button type="button" class="btn btn-info" onclick="updateAdminGroupPermission()" style="margin-left:15px;">修改</button>
                          </div>
              
              			  <header class="panel-heading">
           
                       
                          </header>
                          
                          <form id="form">    	 
                          <table class="table table-striped border-top" id="sample_1">
                          <thead>
                          <tr>
                              <th style="width:8px;"><input type="checkbox" class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
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
                              <td><input type="checkbox" class="checkboxes" name="checkboxes" value="${permission.id}" id="${permission.id}" /></td>                             
                              <td class="center hidden-phone">${permission.permission_name}</td>
                              <td class="hidden-phone">${permission.permission}</td>                             
                              <td class="hidden-phone">${permission.parent_name}</td>
                              <td>${permission.parent}</td>
                              <td class="hidden-phone">
								
							  </td>
                          </tr>
                          </#list>                                                 
                          </tbody>
                          </table>
                          <input type="hidden" name="id" id="adminGroupId" ">   
                          </form>
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
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

    <!--script for this page only-->
    <script src="js/dynamic-table.js"></script>

	<script type="text/javascript">
	$(function(){
		$("#group").click(function() {			
			$(".checkboxes").removeAttr("checked");
			$("#adminGroupId").val($(this).find("option:checked").attr("value"));
			$.ajax({
				type:"post",
				dataType:"json",
				url:"/managecenter/getAdminGroupPermissionById",
				data:"id="+$(this).find("option:checked").attr("value"),
				error: function(result){
					alert(result);
				},
				success: function(data) {	
					if(data.code=="0"){
						$.each(data.body,function(key,value){
							$("#"+value.permissionsId).prop("checked",'true');
						});
					}
				}
			});
		});
	});
	
	$(document).ready(function(){
		$.ajax({
				type:"post",
				dataType:"json",
				url:"/managecenter/getAdminGroupPermissionById",
				data:"id="+${Session.admin_group_id},
				error: function(result){
					alert(result);
				},
				success: function(data) {	
					if(data.code=="0"){
						$.each(data.body,function(key,value){
							$("#"+value.permissionsId).prop("checked",'true');
						});
					}
				}
			});
	});

	
	function updateAdminGroupPermission(){	
		$.ajax({
				type:"post",
				dataType:"json",
				url:"/managecenter/updateAdminGroupPermission",
				data:$("#form").serialize(),
				error: function(result){
					alert("connect false");
				},
				success: function(data) {	
					alert(data.body);
					window.location.href="/managecenter/adminGroupPermission";
				}
			});
	}
	
	 jQuery('#sample_1 .group-checkable').change(function () {
            var set = jQuery(this).attr("data-set");
            var checked = jQuery(this).is(":checked");
            jQuery(set).each(function () {
                if (checked) {
                    $(this).prop("checked", true);
                } else {
                    $(this).prop("checked", false);
                }
            });
            
        });
	
	</script>
  </body>
</html>
