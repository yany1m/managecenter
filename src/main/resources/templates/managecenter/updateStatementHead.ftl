 <div class="panel-body">
                              <form class="form-horizontal tasi-form" id="form">
                              	 <div class="form-group" >                                   
                                      <div class="col-lg-10" style="float:none">
                                      	 <div class="input-group m-bot15" >
                                              <span class="input-group-addon">选择模板</span>
                                              <select id="group" class="form-control m-bot15"> 
                            						<option value="0">默认</option>
                                					<#list statementTemplate as list>
                                					<#if list.selected==1>                                        
                                    				<option selected = "selected" value="${list.id}" templateType=${list.type}>${list.name}</option>  
                                    				<#else>                                           
                                    				<option value="${list.id}">${list.name}</option>                                             
                                    				</#if>
                                    				</#list>                                            
                                </select>                                             
                                          </div>
                                          <div class="input-group m-bot15" >
                                              <span class="input-group-addon">企业注册号</span>
                                              <input type="text" class="form-control" placeholder="企业注册号" name="enterpriseRegistrationNumber" id="enterpriseRegistrationNumber" value=${EnterpriseFinancialData.enterpriseRegistrationNumber}>                                             
                                          </div>
                                                                                                                       
                                          	
                            <script src="js/jquery.js"></script>
                            <script type="text/javascript">
                            $(function(){
								$("#group").change(function() {
									var id=$(this).find("option:checked").attr("value");																		
 		 							$.ajax({
										type:"post",
										dataType:"json",
										url:"/managecenter/updateStatementTemplateSelected",
										data:"id="+id+"&type="+"${type}",
										error: function(result){
											alert(result);
										},
										success: function(data) {	
											window.location.reload();
										}
									});
								});
							});
							</script>