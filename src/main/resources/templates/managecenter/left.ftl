 <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">
                 
                 
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-th"></i>
                          <span>管理用户</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="/managecenter/admin">管理员</a></li>
                          <li><a class="" href="/managecenter/user">用户</a></li>
                      </ul>
                  </li>
                 
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-tasks"></i>
                          <span>财务数据</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                      	  <li><a class="" href="/managecenter/findstatement">报表查询</a></li>
                      	  <li><a class="" href="/managecenter/statementTemplate">报表模板</a></li>
                          <li><a class="" href="/managecenter/balancestatement">资产负债表</a></li>
                          <li><a class="" href="/managecenter/cashflowstatement">现金流量表</a></li>
                          <li><a class="" href="/managecenter/profitstatement">利润表</a></li>
                      </ul>
                  </li>
                   <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-tasks"></i>
                          <span>权限管理</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                      	  <li class=""><a class="" href="/managecenter/getPermission">权限</a></li>
                      	  <li class=""><a class="" href="/managecenter/getAdminGroup">管理组</a></li>
                      	  <li class=""><a class="" href="/managecenter/adminGroupPermission">管理组权限</a></li>
                      </ul>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <i class="icon-tasks"></i>
                          <span>企业评分模板</span>
                          <span class="arrow"></span>
                      </a>
                      <ul class="sub">
                      	  <li class=""><a class="" href="/managecenter/getAllQyCreditConfig">配置模板</a></li>
                      </ul>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <script src="js/jquery-1.8.3.min.js"></script>
      <script src="js/cookie/jquery_cookie.js" ></script>
      <script>
  $(document).ready(function(){
	  var tDiv = $(".sub"),
          links = tDiv.find("a"),
          index = -1,//默认全不选 
	      url = window.location.href.split('?')[0].split('/').pop();
	  
	      for (var i=links.length; i--;) {//遍历 menu 的中连接地址
            if(links[i].href.split('/').pop() == url){
                index = i;
                break;
            }
          }
          if(index!=-1){  
          	links[index].parentNode.className='active';
          	links[index].parentNode.parentNode.parentNode.className='active';
          }
  });
  </script>