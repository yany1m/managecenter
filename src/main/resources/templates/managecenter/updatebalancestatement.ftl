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
                          <div class="panel-body">
                          
                              <form class="form-horizontal tasi-form" id="form">
                              	 <div class="form-group">
                                      <label class="control-label col-lg-2" ></label>
                                      <div class="col-lg-10">
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">企业注册号</span>
                                              <input type="text" class="form-control" placeholder="企业注册号" name="enterpriseRegistrationNumber" id="enterpriseRegistrationNumber" value=${EnterpriseFinancialData.enterpriseRegistrationNumber}>                                             
                                          </div>
                                       <#list EnterpriseFinancialData.balanceStatements as balanceStatement>   
                                            <div class="input-group m-bot15">
                                               <div class="input-append date" id="dpYears" data-date="12-02-2012"
                                                       data-date-format="dd-mm-yyyy" data-date-viewmode="years">
                                                      <input class="form-control" size="16" type="text" value=${balanceStatement.date?string("dd-MM-yyyy")} readonly name="year" id="year">
                                                      <span class="add-on"><i class="icon-calendar"></i></span>
                                                  </div>
                                             </div>                                                                                    
                                          </div>
                                       </div>
                                                                                                    
                            
                              
                              
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >流动资产：</label>
                                      <div class="col-lg-10">
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">货币资金</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_HBZJ_QM" value=${balanceStatement.content.资产['流动资产'].货币资金.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_HBZJ_NC" value=${balanceStatement.content.资产.流动资产.货币资金.年初余额}>
                                          </div>

                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">交易性金融</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_JXYJR_QM" value=${balanceStatement.content.资产.流动资产.交易性金融.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_JXYJR_NC" value=${balanceStatement.content.资产.流动资产.交易性金融.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">应收票据</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YSPJ_QM" value=${balanceStatement.content.资产.流动资产.应收票据.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YSPJ_NC" value=${balanceStatement.content.资产.流动资产.应收票据.年初余额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">应收账款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YSZK_QM" value=${balanceStatement.content.资产.流动资产.应收账款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YSZK_NC" value=${balanceStatement.content.资产.流动资产.应收账款.年初余额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">预付款项</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YFKX_QM" value=${balanceStatement.content.资产.流动资产.预付款项.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YFKX_NC" value=${balanceStatement.content.资产.流动资产.预付款项.年初余额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">应收利息</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YSLX_QM" value=${balanceStatement.content.资产.流动资产.应收利息.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YSLX_NC" value=${balanceStatement.content.资产.流动资产.应收利息.年初余额}>
                                          </div>
                                          
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">应收股利</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YSGL_QM" value=${balanceStatement.content.资产.流动资产.预付款项.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YSGL_NC" value=${balanceStatement.content.资产.流动资产.预付款项.期末余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他应收款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_QTYSK_QM" value=${balanceStatement.content.资产.流动资产.其他应收款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_QTYSK_NC" value=${balanceStatement.content.资产.流动资产.其他应收款.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">存货</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_CH_QM" value=${balanceStatement.content.资产.流动资产.存货.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_CH_NC" value=${balanceStatement.content.资产.流动资产.存货.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">一年内到期的非流动资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_YNNDQDFLDZC_QM" value=${balanceStatement.content.资产.流动资产.一年内到期的非流动资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_YNNDQDFLDZC_NC" value=${balanceStatement.content.资产.流动资产.一年内到期的非流动资产.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他流动资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDZC_QTLDZC_QM" value=${balanceStatement.content.资产.流动资产.其他流动资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDZC_QTLDZC_NC" value=${balanceStatement.content.资产.流动资产.其他流动资产.年初余额}>
                                          </div>
                                      </div>
                                  </div>
                                  
                                  
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >非流动资产：</label>
                                      <div class="col-lg-10">
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">可供出售金融资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_KGCSJRZC_QM" value=${balanceStatement.content.资产.非流动资产.可供出售金融资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_KGCSJRZC_NC" value=${balanceStatement.content.资产.非流动资产.可供出售金融资产.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">持有至到期投资</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_CYZDQTZ_QM" value=${balanceStatement.content.资产.非流动资产.持有至到期投资.期末余额}> 
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_CYZDQTZ_NC" value=${balanceStatement.content.资产.非流动资产.持有至到期投资.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">长期应收款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_CQYSK_QM" value=${balanceStatement.content.资产.非流动资产.长期应收款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_CQYSK_NC" value=${balanceStatement.content.资产.非流动资产.长期应收款.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">长期股权投资</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_CQGQTZ_QM" value=${balanceStatement.content.资产.非流动资产.长期股权投资.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_CQGQTZ_NC" value=${balanceStatement.content.资产.非流动资产.长期股权投资.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">资产性房地产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_ZCXFDC_QM" value=${balanceStatement.content.资产.非流动资产.资产性房地产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_ZCXFDC_NC" value=${balanceStatement.content.资产.非流动资产.资产性房地产.年初余额}>
                                          </div>
                                          
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">固定资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_GDZC_QM" value=${balanceStatement.content.资产.非流动资产.固定资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_GDZC_NC" value=${balanceStatement.content.资产.非流动资产.固定资产.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">在建工程</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_ZJGC_QM" value=${balanceStatement.content.资产.非流动资产.在建工程.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_ZJGC_NC" value=${balanceStatement.content.资产.非流动资产.在建工程.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">工程物资</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_GCWZ_QM" value=${balanceStatement.content.资产.非流动资产.工程物资.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_GCWZ_NC" value=${balanceStatement.content.资产.非流动资产.工程物资.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">固定资产清理</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_GDZCQL_QM" value=${balanceStatement.content.资产.非流动资产.固定资产清理.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_GDZCQL_NC" value=${balanceStatement.content.资产.非流动资产.固定资产清理.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">生产性生物资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_SCXSWZC_QM" value=${balanceStatement.content.资产.非流动资产.生产性生物资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_SCXSWZC_NC" value=${balanceStatement.content.资产.非流动资产.生产性生物资产.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">油气资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_YQZC_QM" value=${balanceStatement.content.资产.非流动资产.油气资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_YQZC_NC" value=${balanceStatement.content.资产.非流动资产.油气资产.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">无形资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_WXZC_QM" value=${balanceStatement.content.资产.非流动资产.无形资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_WXZC_NC" value=${balanceStatement.content.资产.非流动资产.无形资产.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">开发支出</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_KFZC_QM" value=${balanceStatement.content.资产.非流动资产.开发支出.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_KFZC_NC" value=${balanceStatement.content.资产.非流动资产.开发支出.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">商誉</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_SY_QM" value=${balanceStatement.content.资产.非流动资产.商誉.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_SY_NC" value=${balanceStatement.content.资产.非流动资产.商誉.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">长期待摊费用</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_CQCTFY_QM" value=${balanceStatement.content.资产.非流动资产.长期待摊费用.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_CQCTFY_NC" value=${balanceStatement.content.资产.非流动资产.长期待摊费用.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">递延所得税资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_DYSDSZC_QM" value=${balanceStatement.content.资产.非流动资产.递延所得税资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_DYSDSZC_NC" value=${balanceStatement.content.资产.非流动资产.递延所得税资产.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他非流动资产</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDZC_QTFLDZC_QM" value=${balanceStatement.content.资产.非流动资产.其他非流动资产.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDZC_QTFLDZC_NC" value=${balanceStatement.content.资产.非流动资产.其他非流动资产.年初余额}>
                                          </div>
                                          
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >流动负债：</label>
                                      <div class="col-lg-10">
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">短期借款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_DQJK_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.短期借款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_DQJK_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.短期借款.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">交易性金融负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_JYXJRFZ_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.交易性金融负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_JYXJRFZ_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.交易性金融负债.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付票据</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_JFPJ_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应付票据.期末余额}> 
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_JFPJ_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应付票据.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付账款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_JFZK_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应付账款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_JFZK_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应付账款.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">预收账款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YSZK_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.预收账款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YSZK_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.预收账款.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付职工薪酬</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YFZGXC_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应付职工薪酬.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YFZGXC_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应付职工薪酬.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应交税费</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YJSF_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应交税费.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YJSF_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应交税费.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付利息</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YFLX_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应付利息.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YFLX_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应付利息.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付股利</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YFGL_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.应付股利.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YFGL_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.应付股利.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他应付款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_QTYFK_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.其他应付款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_QTYFK_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.其他应付款.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">一年内到期的非流动负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_YNNDQDFLDFZ_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.一年内到期的非流动负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_YNNDQDFLDFZ_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.一年内到期的非流动负债.年初余额}>
                                          </div>
                                         <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他流动负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="LDFZ_QTLDFZ_QM" value=${balanceStatement.content.负债及所有者权益.流动负债.其他流动负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="LDFZ_QTLDFZ_NC" value=${balanceStatement.content.负债及所有者权益.流动负债.其他流动负债.年初余额}>
                                          </div>
                                        </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >非流动负债：</label>
                                      <div class="col-lg-10">
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">长期借款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_CQJK_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.长期借款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_CQJK_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.长期借款.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">应付债券</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_YFZJ_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.应付债券.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_YFZJ_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.应付债券.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">长期应付款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_CQYFK_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.长期应付款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_CQYFK_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.长期应付款.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">专项应付款</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_ZXYFK_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.专项应付款.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_ZXYFK_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.专项应付款.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">预计负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_YJFZ_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.预计负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_YJFZ_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.预计负债.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">递延所得税负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_DYSDSFZ_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.递延所得税负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_DYSDSFZ_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.递延所得税负债.年初余额}>
                                          </div>
                                          <div class="input-group m-bot15">
                                              <span class="input-group-addon">其他非流动负债</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="FLDFZ_QTFLDFZ_QM" value=${balanceStatement.content.负债及所有者权益.非流动负债.其他非流动负债.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="FLDFZ_QTFLDFZ_NC" value=${balanceStatement.content.负债及所有者权益.非流动负债.其他非流动负债.年初余额}>
                                          </div>                                      
                                      </div>
                                  </div>

                                  <div class="form-group">
                                      <label class="control-label col-lg-2" >所有者权益或股东权益：</label>
                                      <div class="col-lg-10">
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">实收资本或股本</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_SSZB_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.实收资本或股本.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_SSZB_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.实收资本或股本.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">资本公积</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_ZBGJ_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.资本公积.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_ZBGJ_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.资本公积.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">库存股</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_KCG_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.库存股.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_KCG_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.库存股.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">专项储备</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_ZXCB_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.专项储备.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_ZXCB_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.专项储备.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">盈余公积</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_YYGJ_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.盈余公积.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_YYGJ_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.盈余公积.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">未分配利润</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_WFPLR_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.未分配利润.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_WFPLR_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.未分配利润.年初余额}>
                                          </div>     
                                           <div class="input-group m-bot15">
                                              <span class="input-group-addon">少数股东权益</span>
                                              <input type="text" class="form-control" placeholder="期末余额" name="SYZQY_SSGDQY_QM" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.少数股东权益.期末余额}>
                                              <input type="text" class="form-control" placeholder="年初余额" name="SYZQY_SSGDQY_NC" value=${balanceStatement.content.负债及所有者权益.所有者权益或股东权益.少数股东权益.年初余额}>
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
                url:"/managecenter/updateBalanceStatement",
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
