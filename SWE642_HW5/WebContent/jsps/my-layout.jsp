
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  
<head> 
<link type="text/css" rel="stylesheet" href="css/mystyle.css">
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css"/>
<script src="javascript/jquery.js">  </script>
<script src="javascript/jquery-ui.js">  </script>
<script  src="javascript/myscript.js"></script>
<title><tiles:getAsString name="pagetitle"/></title>
   
  <script>

$( document ).ready(function() {
 $("#zipp").blur(function() {
          
 $.ajax({
                    url: "javascript/data.json",
                    dataType: "text",
                    error:function(){alert();},
                    success: function(data) {                
                        var json = $.parseJSON(data);
                     callback(json);}});    
});
});

function callback(data){
var items=data.zipcodes;
var zip=document.getElementById("zipp").value.trim();  
var list=[];

var found=false;
var i=0;
var city;
var state;
while(found==false&&i!=items.length){
if(zip==items[i].zip){ found=true; city=items[i].city; state=items[i].state;}
i++;
}
if(found==true){document.getElementById("city").value=city;
               document.getElementById("statee").value=state;
               // document.getElementById("idzipp").innerHTML="";
                }else{
                	document.getElementById("city").value="";
                    document.getElementById("statee").value="";
                	alert("bad zip code");
            //   document.getElementById("cityy").value="";
             //  document.getElementById("statee").value="";
             //  document.getElementById("idzipp").innerHTML="invalid zip";
}

}

</script>
</head>
<body>
<tiles:insertAttribute name="header"/>
 
<tiles:insertAttribute name="body"/> 
 
<tiles:insertAttribute name="footer"/> 
</body>
</html>