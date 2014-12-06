<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 

<div >
<div>
<h4>List Of All Students Ids</h4>
<ul>
      <c:forEach var="option" items="${idList}" >
      <li>
      <a href="retrieveform?act=${option}">
      <c:out value="${option}"/></a>
      </li>
</c:forEach>
</ul>
</div>
<div>
<div>
<div >
<fieldset>
<h1 >Mrs ${name}</h1>
<h2 >Thank you for filling out this survey form!</h2>
<p>The information has been successfully stored</p>
<table border="2">
<tr>
<th colspan="4">Data Statistics</th>
</tr>
<tr>
<th>Mean</th>
<td class="result">${compMean}</td>
</tr>
<tr>
<th>Standard Deviation</th>
<td class="result">${compStdv}</td>
</tr>
</table>
<a href="Survey.jsp"><button  class="sub">Home</button></a>
</fieldset>
</div>

</div> 
</div> 
</div> 
