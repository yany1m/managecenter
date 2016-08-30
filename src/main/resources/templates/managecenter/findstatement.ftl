<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>查找财务数据</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <link rel="stylesheet" type="text/css" href="assets/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="assets/bootstrap-colorpicker/css/colorpicker.css" />
    <link rel="stylesheet" type="text/css" href="assets/bootstrap-daterangepicker/daterangepicker.css" />

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
            
             
                      <section class="panel">
                          <header class="panel-heading">
                              查找财务表
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal tasi-form" action="/managecenter/findByEnterpriseFinancialData" method="post">
                              	 <div class="form-group">
                              
                                      <label class="control-label col-lg-2" for="inputSuccess"></label>
                                      <div class="col-lg-10">
                                          <select name="statement" class="form-control m-bot15">
                                          	  <option>全部</option>
                                              <option>资产负债表</option>
                                              <option>现金流量表</option>
                                              <option>利润表</option>                                             
                                          </select>
                              	 	  </div>
                                      <label class="control-label col-lg-2" ></label>
                                      <div class="col-lg-10">
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">企业注册号</span>
                                              <input type="text" class="form-control" placeholder="企业注册号" name="enterpriseRegistrationNumber">                                             
                                          </div>
                                                                                      
                                       </div>
                                        <div class="col-lg-offset-2 col-lg-10">
                                       <button type="submit" class="btn btn-info">查询</button>
                                  		</div>
                                                                                                    
                            </div>                                                                                                                                              								
                              </form>
                          </div>
              
                          <header class="panel-heading">
           
                       
                          </header>
                         <table class="table table-striped border-top" id="sample_1">
                          <thead>
                          <tr>                                                       
                              <th class="hidden-phone">表名</th>                                                     
                              <th class="hidden-phone">时间</th>
                              <th class="hidden-phone">企业注册号</th>                    
                              <th></th>
                          </tr>
                          </thead>
                          <tbody>
                          <#if EnterpriseFinancialData??>
                          <#if (EnterpriseFinancialData.balanceStatements??) >
                          <#list EnterpriseFinancialData.balanceStatements as bs>
                          <tr class="odd gradeX">                          
                              <td>资产负债表</td>                                                        
                              <td class="center hidden-phone">${bs.date?string("dd-MM-yyyy")}</td> 
                              <td>${EnterpriseFinancialData.enterpriseRegistrationNumber}</td>                 
                               <td>                                     
                                       <a href="/managecenter/findFinancialStatement?enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${bs.date?string("dd-MM-yyyy")}&statement=资产负债表"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
                                       <button onclick='if(confirm("确认删除")){deleteBalanceStatement(this)}' id="enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${bs.date?string("dd-MM-yyyy")}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>                    
                               </td>
                          </tr>  
                          </#list>
                          </#if>
                          
                          <#if EnterpriseFinancialData.cashFlowStatements??>
                          <#list EnterpriseFinancialData.cashFlowStatements as cs>
                          <tr class="odd gradeX">                          
                              <td>现金流量表</td>                                                        
                              <td class="center hidden-phone">${cs.date?string("dd-MM-yyyy")}</td> 
                              <td>${EnterpriseFinancialData.enterpriseRegistrationNumber}</td>                 
                               <td>                                     
                                       <a href="/managecenter/findFinancialStatement?enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${cs.date?string("dd-MM-yyyy")}&statement=现金流量表"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
									   <button onclick='if(confirm("确认删除")){deleteCashFlowStatement(this)}' id="enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${cs.date?string("dd-MM-yyyy")}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>                               
							   </td>
                          </tr>  
                          </#list>
                          </#if>       
                          
                          <#if EnterpriseFinancialData.profitStatements??>
                          <#list EnterpriseFinancialData.profitStatements as ps>
                          <tr class="odd gradeX">                          
                              <td>利润表</td>                                                        
                              <td class="center hidden-phone">${ps.date?string("dd-MM-yyyy")}</td> 
                              <td>${EnterpriseFinancialData.enterpriseRegistrationNumber}</td>                 
                               <td>                                     
                                       <a href="/managecenter/findFinancialStatement?enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${ps.date?string("dd-MM-yyyy")}&statement=利润表"><button class="btn btn-primary btn-xs"><i class="icon-pencil"></i></button></a>
                                       <button onclick='if(confirm("确认删除")){deleteProfitStatement(this)}' id="enterpriseRegistrationNumber=${EnterpriseFinancialData.enterpriseRegistrationNumber}&year=${ps.date?string("dd-MM-yyyy")}" class="btn btn-danger btn-xs"><i class="icon-trash "></i></button>
                               </td>
                          </tr>  
                          </#list>
                          </#if>       
                          </#if>                                      
                          </tbody>
                          </table>
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
	
    <script src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<script type="text/javascript" src="assets/data-tables/jquery.dataTables.js"></script>
    <script type="text/javascript" src="assets/data-tables/DT_bootstrap.js"></script>
    
    <!--custom switch-->
    <script src="js/bootstrap-switch.js"></script>
    <!--custom tagsinput-->
    <script src="js/jquery.tagsinput.js"></script>
    <!--custom checkbox & radio-->
    <script type="text/javascript" src="js/ga.js"></script>

    <script type="text/javascript" src="assets/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="assets/bootstrap-daterangepicker/date.js"></script>
    <script type="text/javascript" src="assets/bootstrap-daterangepicker/daterangepicker.js"></script>
    <script type="text/javascript" src="assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
    <script type="text/javascript" src="assets/ckeditor/ckeditor.js"></script>


  <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

  <!--script for this page-->
  <script src="js/form-component.js"></script>
  <script src="js/dynamic-table.js"></script>
	
  <script type="text/javascript">
	 function deleteBalanceStatement(which){
			
			$.post("/managecenter/deleteBalanceStatement",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/findstatement";
    			}
 		 });
	}
	
	function deleteCashFlowStatement(which){
			
			$.post("/managecenter/deleteCashFlowStatement",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/findstatement";
    			}
 		 });
	}
	
	function deleteProfitStatement(which){
			$.post("/managecenter/deleteProfitStatement",$(which).attr("id"),function(result){
    			alert(result.body);
    			if(result.code=="0"){	
    				window.location.href="/managecenter/findstatement";
    			}
 		 });
	}
  </script>
  </body>
</html>
