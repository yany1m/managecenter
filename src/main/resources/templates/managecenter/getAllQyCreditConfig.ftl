<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>企业评分配置</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  </head>
<style>
	 .inbox-started{
	 	color: #f78a09;
	 }
</style>
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
                              配置模板
                          </header>
                                                 
                          <table class="table table-striped border-top">
                        
                          <tbody>
                         
                          <tr class="odd gradeX">                           	                          
                              <td>版本1.0</td>
                                                     
                               <td>                                    
                               		  <a href="/managecenter/addQyCreditConfig"><button class="btn btn-success btn-xs"><i class="icon-plus"></i></button></a>                                     
                               </td>
                          </tr>                                      
                          </tbody>
                          </table>
                          </section>
                          </div>
                          </div>
                          
               <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                           <table class="table table-striped border-top" id="sample_1">
                          <thead>
                          <tr> 
                          	  <th></th>                                            
                              <th>名称</th>
                              <th class="hidden-phone">创建时间</th>                                                                                                   
                              <th class="hidden-phone">创建人</th>                                                                                                   
                              <th class="hidden-phone">前置版本</th>                                                                                                   
                              <th class="hidden-phone">描述</th>                                                                                                   
                              <th></th>
                          </tr>
                          </thead>
                          <tbody>
                          <#if list??>
                          <#list list as configTemplate>  
                          <tr class="odd gradeX">
                          	  <#if configTemplate.selected==1>
                          	  <td class="inbox-small-cells"><i class="icon-star inbox-started"></i></td>                           	                          
                          	  <#else>
                          	  <td class="inbox-small-cells"><i class="icon-star"></i></td>   
                          	  </#if>
                              <td>${configTemplate.name}</td>
                              <td class="hidden-phone">${configTemplate.timeStamp?string("yyyy-MM-dd HH:mm:ss")}</td>                                                                                                         
                              <td class="hidden-phone">${configTemplate.admin}</td>                                                                                                         
                              <td class="hidden-phone">${configTemplate.lastVersion}</td>                                                                                                         
                              <td class="hidden-phone">${configTemplate.describe}</td>                                                                                                         
                               <td>                           
                               		  <button onclick='if(confirm("确认选中")){selectQyCreditConfig(this)}' id="uuid=${configTemplate.uuid}" class="btn btn-warning btn-xs"><i class="icon-ok"></i></button>    
                                      <a href="/managecenter/addQyCreditConfig?uuid=${configTemplate.uuid}"><button class="btn btn-success btn-xs"><i class="icon-plus"></i></button></a>
                                      <button onclick='if(confirm("确认删除")){deleteQyCreditConfigById(this)}' id="uuid=${configTemplate.uuid}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>
                               </td>
                          </tr>  
                          </#list>  
                          </#if>                                       
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
	function deleteQyCreditConfigById(which){
			
			$.post("/managecenter/deleteQyCreditConfigById",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/getAllQyCreditConfig";
    			}
 		 });
	}
	function selectQyCreditConfig(which){
			
			$.post("/managecenter/selectQyCreditConfig",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/getAllQyCreditConfig";
    			}
 		 });
	}
	</script>
  </body>
</html>
