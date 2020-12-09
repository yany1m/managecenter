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
    <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
    
    <link href="css/app.css" rel="stylesheet" type="text/css">
  	<link href="css/jsoneditor.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">


    code {
      background-color: #f5f5f5;
    }
	
	#codeEditor {
      width: 600px;
      height: 530px;
      padding: 15px 0 15px 15px;
    }
	
	#treeEditor {
      width: 600px;
      height: 530px;    
      padding: 15px 0 15px 15px;   
    }
  </style>
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
          <section class="wrapper" >
          	<section class="panel">
          	<header class="panel-heading">
                              添加企业评分配置模板
            </header>
             
             <div class="panel-body">  
                             
               <div class="form-group">
               <label for="exampleInputEmail1">名称</label>
			   <input type="text" class="name form-control"  placeholder="输入名称">
			   </div>                                
               <div class="form-group">
               <label for="exampleInputEmail1">描述</label>
			   <input id="describe" class="form-control" type="textarea" placeholder="输入本次版本改变">
			   </div>                                
			                                                                                              
             </div>
             <div id="auto">
				  <div id="contents">
				    <div id="codeEditor"></div>
					
					<div id="splitter">
				      <div id="buttons">
				        <div>
				          <button id="toTree" class="convert" title="Copy code to tree editor (Ctrl + &gt;)" onclick="toTree();">
				            <div class="convert-right"></div>
				          </button>
				        </div>
				        <div>
				          <button id="toJSON" class="convert" title="Copy tree to code editor (Ctrl + &lt;)" onclick="toJson()">
				            <div class="convert-left"></div>
				          </button>
				        </div>
				      </div>
				      <div style="height: 382px; line-height: 382px;" title="Drag left or right to change the width of the panels" id="drag">⋮</div>
				    </div>
					
					<div id="treeEditor"></div>
					<div class="col-lg-offset-2 col-lg-10">
                     <button type="button" class="btn btn-info" id="submit">提交</button>
                	</div>
			</div>
		</div>
				<div id="google_ads" style="display:none"></div>									
      </section>
      <!--main content end-->
      </section>
  </section>

     <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
  	<script src="js/jsoneditor.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>
	<script>
	  var codeEditor = null;
	  var treeEditor = null;
	  var json = ${content};
	
	  function initJsonEditorTreeMode(container,defaultModel,jsonObj){
		  //var container = document.getElementById('jsoneditor_code');
	
		  var options = {
			mode: defaultModel,
			modes: ['code', 'form', 'text', 'tree', 'view'], // allowed modes
			onError: function (err) {
			  alert(err.toString());
			},
			onModeChange: function (newMode, oldMode) {
			  console.log('Mode switched from', oldMode, 'to', newMode);
			}
		  };
	
		  
	
		  var editor = new JSONEditor(container, options, jsonObj);
		  return editor;
	  }
	  codeEditor = initJsonEditorTreeMode(document.getElementById('codeEditor'),"code",json);
	  treeEditor = initJsonEditorTreeMode(document.getElementById('treeEditor'),"tree",json);
	  
	  function toTree(){
		codeEditor.set(codeEditor.get());
		treeEditor.set(codeEditor.get());	
	  }
	  function toJson(){
		codeEditor.set(treeEditor.get());
	  }
	
	 $("#submit").click(function(){
	 	try{
			console.log(codeEditor.get());
		}catch(error){
			alert(error);
			return;
		}
		
		var template=JSON.stringify(codeEditor.get()).replace(/\+/g, "%2B");

		$.ajax({
				type:"post",
				dataType:"json",
				url:"/managecenter/addQyCreditConfig",
				data:"name="+$(".name").val()+"&describe="+$("#describe").val()+"&lastVersion="+"${configTemplate.name}"+"&content="+template,
				error: function(result){
					alert("connect false");
				},
				success: function(data) {	
					alert(data.body)
					if(data.code=="0"){
						window.location.href="/managecenter/getAllQyCreditConfig";
					}else{
						window.location.reload();
					}		
				}
			});
		});
	 
	</script>
	

  </body>
</html>
					