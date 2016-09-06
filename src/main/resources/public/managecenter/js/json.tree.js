
	function balanceStatementToJson(){
	    var arrTr = $("#table").children;
	    var Context = "";
	    var Jsontext ="[" ;
	    $("#table").find("tr").each(function(){
	    	var arrtd=$(this).children();
	    	var json1;
	    	if(arrtd.eq(0).attr("id")==0){ 
	    		return ;
	    	}
	    	if($.trim(arrtd.eq(0).text())!=""){
	    	json1="{\"id\":"+arrtd.eq(0).attr("id")+",\"pid\":"+arrtd.eq(0).attr("pid")+",\"name\":"+"\""+$.trim(arrtd.eq(0).text())+"\""+",\"body\":"+"{\"期末余额\":"+"\""+arrtd.eq(1).find("input").val()+"\""+",\"年初余额\":"+"\""+arrtd.eq(2).find("input").val()+"\""+"}}";
	    	Jsontext+=json1+",";
	    	}
	    	var json2;
	    	if($.trim(arrtd.eq(3).text())!=""){
	    	json2="{\"id\":"+arrtd.eq(3).attr("id")+",\"pid\":"+arrtd.eq(3).attr("pid")+",\"name\":"+"\""+$.trim(arrtd.eq(3).text())+"\""+",\"body\":"+"{\"期末余额\":"+"\""+arrtd.eq(4).find("input").val()+"\""+",\"年初余额\":"+"\""+arrtd.eq(5).find("input").val()+"\""+"}}";
	    	Jsontext+=json2+",";
	    	}	
	    });
	    Jsontext=Jsontext.substring(0,Jsontext.length-1);
	    Jsontext+="]";
	    var dataset = $.parseJSON(Jsontext);
	    var jsondata=createTree(dataset,0);
	    return jsondata;
	}
	
	function cashflowStatementToJson(){
		var arrTr = $("#table").children;
		var Context = "";
		var Jsontext ="[" ;
		$("#table").find("tr").each(function(){
			var arrtd=$(this).children();
			var json1;
			if(arrtd.eq(0).attr("id")==0){ 
				return ;
			}
			if($.trim(arrtd.eq(0).text())!=""){
				json1="{\"id\":"+arrtd.eq(0).attr("id")+",\"pid\":"+arrtd.eq(0).attr("pid")+",\"name\":"+"\""+$.trim(arrtd.eq(0).text())+"\""+",\"body\":"+"{\"本年累计金额\":"+"\""+arrtd.eq(1).find("input").val()+"\""+",\"上年累计金额\":"+"\""+arrtd.eq(2).find("input").val()+"\""+"}}";
				Jsontext+=json1+",";
			}			
		});
		Jsontext=Jsontext.substring(0,Jsontext.length-1);
		Jsontext+="]";
		var dataset = $.parseJSON(Jsontext);
		var jsondata=createTree(dataset,0);
		return jsondata;
	}
	
	function profitStatementToJson(){
		var arrTr = $("#table").children;
		var Context = "";
		var Jsontext ="[" ;
		$("#table").find("tr").each(function(){
			var arrtd=$(this).children();
			var json1;
			if(arrtd.eq(0).attr("id")==0){ 
				return ;
			}
			if($.trim(arrtd.eq(0).attr("role"))!="titleitem"){
				json1="{\"id\":"+arrtd.eq(0).attr("id")+",\"pid\":"+arrtd.eq(0).attr("pid")+",\"role\":"+"\""+arrtd.eq(0).attr("role")+"\""+",\"name\":"+"\""+$.trim(arrtd.eq(0).text())+"\""+",\"body\":"+"{\"本年累计数\":"+"\""+arrtd.eq(1).find("input").val()+"\""+",\"上年累计数\":"+"\""+arrtd.eq(2).find("input").val()+"\""+"}}";
				Jsontext+=json1+",";
			}else{
				json1="{\"id\":"+arrtd.eq(0).attr("id")+",\"pid\":"+arrtd.eq(0).attr("pid")+",\"role\":"+"\""+arrtd.eq(0).attr("role")+"\""+",\"name\":"+"\""+$.trim(arrtd.eq(0).text())+"\""+",\"本年累计数\":"+"\""+arrtd.eq(1).find("input").val()+"\""+",\"上年累计数\":"+"\""+arrtd.eq(2).find("input").val()+"\""+"}";
				Jsontext+=json1+",";
			}			
		});
		Jsontext=Jsontext.substring(0,Jsontext.length-1);
		Jsontext+="]";
		var dataset = $.parseJSON(Jsontext);
		var jsondata=createTree1(dataset,0,1);
		return jsondata;
	}
	
	//生成map嵌套的json树
	 function createTree(jsons,pid){
    		var obj = {}, temp;
            for(var i=0;i<jsons.length;i++){
                 if(jsons[i].pid == pid){
                 	//var obj = {};                  
                    temp =createTree(jsons,jsons[i].id) ;
                    if (!isEmptyObject(temp)) {                   	
                		obj[jsons[i].name] = temp;
            		}else{
            			obj[jsons[i].name]=jsons[i].body;
            		}
            		//result.push(obj);
                }
             }
           //console.log(result) ; 
           return obj;
            
     }
	 
	 //生成map嵌套的json树
	 function createTree1(jsons,pid,z){
		 var obj = {}, temp;
		 for(var i=0;i<jsons.length;i++){
			 if(jsons[i].pid == pid){
				 //var obj = {};      
				 if(jsons[z].role=='titleitem'){
					 obj['本年累计数']=jsons[z].本年累计数;
					 obj['上年累计数']=jsons[z].上年累计数;
				 }
				 temp =createTree1(jsons,jsons[i].id,i) ;
				 if (!isEmptyObject(temp)) {                   	
					 obj[jsons[i].name] = temp;			
				 }else{
					 obj[jsons[i].name]=jsons[i].body;
				 }
				 //result.push(obj);
			 }
		 }
		 //console.log(result) ; 
		 return obj;
		 
	 }
     
     function isEmptyObject(obj){
   		for(var n in obj){return false} 
   		return true; 
	} 
