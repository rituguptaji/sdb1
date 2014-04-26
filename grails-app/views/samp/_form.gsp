<%@ page import="sdb1.Samp" %>



<div class="fieldcontain ${hasErrors(bean: sampInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="samp.name.label" default="Name" />
		
	</label>
	<g:select name="name" from="${sampInstance.constraints.name.inList}" value="${sampInstance?.name}" valueMessagePrefix="samp.name" noSelection="['': '']"/>
</div>

