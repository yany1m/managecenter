<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.html">

    <title>修改-现金流量表</title>

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
                             现金流量表
                          </header>
                          <div class="panel-body">
                              <form class="form-horizontal tasi-form" id="form">
                              	 <div class="form-group">
                                      <label class="control-label col-lg-2" ></label>                                                                                                             	                                   
                                      <div class="col-lg-10">                                         	                                                                       	 
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">企业注册号</span>
                                              <input type="text" class="form-control" placeholder="企业注册号" name="enterpriseRegistrationNumber" id="enterpriseRegistrationNumber" value=${EnterpriseFinancialData.enterpriseRegistrationNumber}>                                             
                                          </div>
                                          <#list EnterpriseFinancialData.cashFlowStatements as cashFlowStatement>
                                            <div class="input-group m-bot15">
                                              <div class="input-append date" id="dpYears" data-date="12-02-2012"
                                                       data-date-format="dd-mm-yyyy" data-date-viewmode="years">
                                                      <input class="form-control" size="16" type="text" value=${cashFlowStatement.date?string("dd-MM-yyyy")} readonly name="year" id="year">
                                                      <span class="add-on"><i class="icon-calendar"></i></span>
                                                  </div>                                             
                                          </div>
                                       </div>
                                                                                                    
                            </div>
                              
                              
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >经营活动产生的现金流量：</label>
                                      <div class="col-lg-10">
                                       	  <div class="input-group m-bot15">                                            
                                              <label class="control-label">流入：</label>                                            
                                          </div> 
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">销售商品、提供劳务收到的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_SSSPTGLWSDDXJ_LR_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入['销售商品、提供劳务收到的现金'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_SSSPTGLWSDDXJ_LR_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入['销售商品、提供劳务收到的现金'].上年累计金额}>
                                          </div>

                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">收到的税费返还</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_SDDSFFH_LR_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入.收到的税费返还.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_SDDSFFH_LR_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入.收到的税费返还.上年累计金额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">收到其他与经营活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_SDQTYJYHDYGDXJ_LR_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入.收到其他与经营活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_SDQTYJYHDYGDXJ_LR_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流入.收到其他与经营活动有关的现金.上年累计金额}>
                                          </div>
                                          <div class="input-group m-bot15">                                            
                                              <label class="control-label">流出：</label>                                            
                                          </div> 
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">购买商品、接受劳务支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_GMSPJSLWZFDXJ_LC_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出['购买商品、接受劳务支付的现金'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_GMSPJSLWZFDXJ_LC_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出['购买商品、接受劳务支付的现金'].上年累计金额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">支付给职工以及为职工支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_ZFGZGYJWZGZFDXJ_LC_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付给职工以及为职工支付的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_ZFGZGYJWZGZFDXJ_LC_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付给职工以及为职工支付的现金.上年累计金额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">支付的各项税费</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_ZFDGXSF_LC_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付的各项税费.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_ZFDGXSF_LC_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付的各项税费.上年累计金额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">支付其他与经营活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="JYHDCSDXJLL_ZFQTYJYHDYGDXJ_LC_BN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付其他与经营活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="JYHDCSDXJLL_ZFQTYJYHDYGDXJ_LC_SN" value=${cashFlowStatement.content.经营活动产生的现金流量.流出.支付其他与经营活动有关的现金.上年累计金额}>
                                          </div>
                                                                      
                                      </div>
                                  </div>
                                  
                                  
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >投资活动产生的现金流量：</label>
                                      <div class="col-lg-10">
                                        <div class="input-group m-bot15">                                            
                                              <label class="control-label">流入：</label>                                            
                                          </div> 
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">收回投资收到的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_SHTZSDDXJ_LR_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.收回投资收到的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_SHTZSDDXJ_LR_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.收回投资收到的现金.上年累计金额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">取得投资收益收到的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_QDTZSYSDDXJ_LR_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.取得投资收益收到的现金.本年累计金额}> 
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_QDTZSYSDDXJ_LR_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.取得投资收益收到的现金.上年累计金额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">处置固定资产、无形资产和其他长期资产收回的现金净额</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_CZGDZCWXZCHQTCQZCSHDXJJE_LR_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入['处置固定资产、无形资产和其他长期资产收回的现金净额'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_CZGDZCWXZCHQTCQZCSHDXJJE_LR_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入['处置固定资产、无形资产和其他长期资产收回的现金净额'].上年累计金额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">处置子公司及其他营业单位收到的现金净额</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_CZZGSJQTYYDWSDDXJJE_LR_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.处置子公司及其他营业单位收到的现金净额.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_CZZGSJQTYYDWSDDXJJE_LR_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.处置子公司及其他营业单位收到的现金净额.上年累计金额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">收到其他与投资活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_SDQTYTZHDYGDXJ_LR_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.收到其他与投资活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_SDQTYTZHDYGDXJ_LR_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流入.收到其他与投资活动有关的现金.上年累计金额}>
                                          </div>
                                            <div class="input-group m-bot15">                                            
                                              <label class="control-label">流出：</label>                                            
                                          </div> 
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">购建固定资产、无形资产和其他长期资产支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_GJGDZCWXZCHQTCQZCZFDXJ_LC_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出['购建固定资产、无形资产和其他长期资产支付的现金'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_GJGDZCWXZCHQTCQZCZFDXJ_LC_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出['购建固定资产、无形资产和其他长期资产支付的现金'].上年累计金额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">投资支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_TZZFDXJ_LC_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.投资支付的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_TZZFDXJ_LC_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.投资支付的现金.上年累计金额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">取得子公司及其他营业单位支付的现金净额</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_QDZGSJQTYYDWZFDXJJE_LC_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.取得子公司及其他营业单位支付的现金净额.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_QDZGSJQTYYDWZFDXJJE_LC_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.取得子公司及其他营业单位支付的现金净额.上年累计金额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">支付其他与投资活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="TZHDCSDXJLL_ZFQTYTZHDYGDXJ_LC_BN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.支付其他与投资活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="TZHDCSDXJLL_ZFQTYTZHDYGDXJ_LC_SN" value=${cashFlowStatement.content.投资活动产生的现金流量.流出.支付其他与投资活动有关的现金.上年累计金额}>
                                          </div>
                                         
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >筹资活动产生的现金流量：</label>
                                      <div class="col-lg-10">
                                        <div class="input-group m-bot15">                                            
                                              <label class="control-label">流入：</label>                                            
                                          </div> 
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">吸收投资收到的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_XSTZSDDXJ_LR_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.吸收投资收到的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_XSTZSDDXJ_LR_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.吸收投资收到的现金.上年累计金额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">取得借款收到的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_QDJKSDDXJ_LR_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.取得借款收到的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_QDJKSDDXJ_LR_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.取得借款收到的现金.上年累计金额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">收到其他与筹资活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_SDQTYCZHDYGDXJ_LR_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.收到其他与筹资活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_SDQTYCZHDYGDXJ_LR_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流入.收到其他与筹资活动有关的现金.上年累计金额}>
                                          </div>
                                            <div class="input-group m-bot15">                                            
                                              <label class="control-label">流出：</label>                                            
                                          </div> 
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">偿还债务支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_CHZWZFDXJ_LC_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出.偿还债务支付的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_CHZWZFDXJ_LC_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出.偿还债务支付的现金.上年累计金额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">分配股利、利润或偿付利息支付的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_FPGLLRHCHLXZFDXJ_LC_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出['分配股利、利润或偿付利息支付的现金'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_FPGLLRHCHLXZFDXJ_LC_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出['分配股利、利润或偿付利息支付的现金'].上年累计金额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">支付其他与筹资活动有关的现金</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="CZHDCSDXJLL_ZFQTYCZHDYGDXJ_LC_BN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出.支付其他与筹资活动有关的现金.本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="CZHDCSDXJLL_ZFQTYCZHDYGDXJ_LC_SN" value=${cashFlowStatement.content.筹资活动产生的现金流量.流出.支付其他与筹资活动有关的现金.上年累计金额}>
                                          </div>
                                        </div> 
                                  </div>
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >汇率变动对现金及现金等价物的影响：</label>
                                      <div class="col-lg-10">
                                        <div class="input-group m-bot15">                                            
                                              <label class="control-label">流入：</label>                                            
                                          </div> 
                                         
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">加：期初现金及现金等价物余额</span>
                                              <input type="text" class="form-control" placeholder="本年累计金额" name="HLBDDXJJXJDJWDYX_QCXJJXJDJWYE_LR_BN" value=${cashFlowStatement.content.汇率变动对现金及现金等价物的影响.流入['加：期初现金及现金等价物余额'].本年累计金额}>
                                              <input type="text" class="form-control" placeholder="上年累计金额" name="HLBDDXJJXJDJWDYX_QCXJJXJDJWYE_LR_SN" value=${cashFlowStatement.content.汇率变动对现金及现金等价物的影响.流入['加：期初现金及现金等价物余额'].上年累计金额}>
                                          </div>
                                                  
                                      </div>
                                  </div>
                                  </#list>                      
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
	<script type="text/javascript">
	
	$("#update").click(function(){
		$.ajax({             
                type: "POST",
                url:"/managecenter/updateCashFlowStatement",
                data:$('#form').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                   $.each(data, function(key, value) {
    				if(key=="body"){
    					alert(value);    					
    				}
    			});
                }
            });
	});
	
	$("#submit").click(function(){
		$.ajax({             
                type: "POST",
                url:"/managecenter/saveCashFlowStatement",
                data:$('#form').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                   $.each(data, function(key, value) {
    				if(key=="body"){
    					alert(value);
    					window.location.href="/managecenter/cashflowstatement";
    				}
    			});
                }
            });
	});
	</script>
  </body>
</html>
