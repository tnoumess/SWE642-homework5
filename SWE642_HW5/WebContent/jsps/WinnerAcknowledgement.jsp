<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">







<div >
<div >
<h4>List of Students Ids</h4>
<ul>
<c:forEach var="option" items="${idList}" >

<li><a href="retrieveform?act=${option}">
<c:out value="${option}"/></a>
</li>
</c:forEach>
</ul>
</div>
<div >
<div >
<div >
<fieldset>
<h1 >Congratulations! Mrs ${name}</h1>
<h2>You Are A Winner Of Two Movie Tickets .</h2>
<h3 >Thank you for filling out this survey form!</h3>
<p>- The information has been successfully stored</p>
<table border="2">
<tr>
<th colspan="4">data Statistics</th>
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
<a href="Survey.jsp"><button>Return to Home</button></a>
</fieldset>
</div>

</div> 
</div> 
</div> 

