<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>修改-资产负债表</title>

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
                              资产负债表
                          </header>                          
                          <#include "updateStatementHead.ftl"/>
                                       <#list EnterpriseFinancialData.balanceStatements as balanceStatement>   
                                            <div class="col-sm-6 m-bot15" style="padding-left:0px">
                                               <div class="input-append date" id="dpYears" data-date="12-02-2012"
                                                       data-date-format="dd-mm-yyyy" data-date-viewmode="years">
                                                      <input class="form-control" size="16" type="text" value=${balanceStatement.date?string("dd-MM-yyyy")} readonly name="year" id="year">
                                                      <span class="add-on"><i class="icon-calendar"></i></span>
                                                  </div>
                                             </div>                                                                                    
                                          </div>
                                       </div>                                                                                                                                                                                                           
                                 	 </#list>
                              <table class="table" id="table">
                              <thead>
                              <tr >                             
                                  <th id=${head[3]} pid=${head[4]}>${head[0]}</th>
                                  <th><input type="text" class="form-control"  style="display:none">${head[1]}</th>
                                  <th><input type="text" class="form-control"  style="display:none">${head[2]}</th>
                                  <th id=${head[8]} pid=${head[9]}>${head[5]}</th>
                                  <th><input type="text" class="form-control"  style="display:none">${head[6]}</th>
                                  <th><input type="text" class="form-control"  style="display:none">${head[7]}</th>
                              </tr>
                              </thead>
                              <#list balancestatementList as list>
                            
                              <tbody>
                              <tr>           
                              	  <#if list.data[5]=="title" || list.data[5]=="titleitem" || list.data[5]=="item" || list.data[11]=="title" || list.data[5]=="titleitem" || list.data[11]=="item">        
                                  <#if list.data[5]=="title" >
                                  <td id=${list.data[3]} pid=${list.data[4]} style="font-weight: bold;">${list.data[0]}</td>
                                  <td><input type="text" class="form-control"  style="display:none"></td>
                                  <td><input type="text" class="form-control"  style="display:none"></td>
                                  <#elseif list.data[5]=="item" || list.data[5]=="titleitem">
                                  <td id=${list.data[3]} pid=${list.data[4]} >${list.data[0]}</td>
                                  <td><input type="text" class="form-control"  value=${list.data[1]}></td>
                                  <td><input type="text" class="form-control"  value=${list.data[2]}></td>
                                  <#else>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  </#if>

                                  <#if list.data[11]=="title" >
                                  <td id=${list.data[9]} pid=${list.data[10]} style="font-weight: bold;">${list.data[6]}</td>
                                  <td><input type="text" class="form-control"  style="display:none"></td>
                                  <td><input type="text" class="form-control"  style="display:none"></td>
                                  <#elseif list.data[11]=="item" || list.data[5]=="titleitem">
                                  <td id=${list.data[9]} pid=${list.data[10]}>${list.data[6]}</td>
                                  <td><input type="text" class="form-control"  value=${list.data[7]}></td>
                                  <td><input type="text" class="form-control"  value=${list.data[8]}></td>
                                  <#else>
                                  <td></td>
                                  <td></td>
                                  <td></td>
                                  </#if>
                                  </#if>
                              </tr>
                              </tbody>                            
                              </#list>
                          </table>
                                  
                                  
                                  <div class="col-lg-offset-2 col-lg-10">
                                       <button type="button" class="btn btn-info" id="update">修改</button>
                                        <button type="button" class="btn btn-info" id="submit">提交</button>
                                       <span class="help-block">需要修改注册号或者时间，请选择提交.</span>
                                  </div>                                 
                              </form>
                             
                          </div>
                      </section>

                      
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
  <script src="js/json2.js"></script>
  <script src="js/json.tree.js"></script>
	<script type="text/javascript">
	
	$("#update").click(function(){
		var jsondata=balanceStatementToJson();
		jsondata=JSON.stringify(jsondata) ;
		$.ajax({             
                type: "POST",
                url:"/managecenter/updateBalanceStatement",
                data:"enterpriseRegistrationNumber="+$("#enterpriseRegistrationNumber").val()+"&year="+$("#year").val()+"&json="+jsondata,// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {                   
   					alert(data.body);  
   					window.location.reload();  					   		
                }
            });
	});
	
	$("#submit").click(function(){
		var jsondata=balanceStatementToJson();
		jsondata=JSON.stringify(jsondata) ;
		$.ajax({             
                type: "POST",
                url:"/managecenter/saveBalanceStatement",
                data:"enterpriseRegistrationNumber="+$("#enterpriseRegistrationNumber").val()+"&year="+$("#year").val()+"&json="+jsondata+"&templateId="+${id},// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {               
    				alert(data.body);
    				window.location.href="/managecenter/BalanceStatement";    			
                }
            });
	});
	</script>
  </body>
</html>
