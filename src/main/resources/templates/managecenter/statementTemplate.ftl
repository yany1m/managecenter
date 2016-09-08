<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>报表模板</title>

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
                              报表模板
                          </header>
                                                 
                          <table class="table table-striped border-top">
                        
                          <tbody>
                         
                          <tr class="odd gradeX">                           	                          
                              <td>资产负债表</td>
                                                     
                               <td>                                    
                               		  <a href="/managecenter/addStatementTemplate?type=资产负债表"><button class="btn btn-success btn-xs"><i class="icon-plus"></i></button></a>                                     
                               </td>
                          </tr>  
                          <tr class="odd gradeX">                           	                          
                              <td>现金流量表</td>
                                                     
                               <td>                                    
                               		  <a href="/managecenter/addStatementTemplate?type=现金流量表"><button class="btn btn-success btn-xs"><i class="icon-plus"></i></button></a>                                     
                               </td>
                          </tr>  
                          <tr class="odd gradeX" >                           	                          
                              <td>利润表</td>
                                                     
                               <td>                                    
                               		  <a href="/managecenter/addStatementTemplate?type=利润表"><button class="btn btn-success btn-xs"><i class="icon-plus"></i></button></a>                                     
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
                              <th>名称</th>
                              <th class="hidden-phone">类型</th>                                                                                                   
                              <th></th>
                          </tr>
                          </thead>
                          <tbody>
                          <#list list as st>  
                          <tr class="odd gradeX">                           	                          
                              <td>${st.name}</td>
                              <td class="hidden-phone">${st.type}</td>                                                                                                         
                               <td>                                    
                                      <a href="/managecenter/updateStatementTemplate?id=${st.id}"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
                                      <button onclick='if(confirm("确认删除")){deleteStatementTemplate(this)}' id="id=${st.id}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>
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
	function deleteStatementTemplate(which){
			
			$.post("/managecenter/deleteStatementTemplate",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/statementTemplate";
    			}
 		 });
	}
	</script>
  </body>
</html>
