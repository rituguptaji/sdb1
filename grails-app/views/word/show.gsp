
<%@ page import="sdb1.Word" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'word.label', default: 'Word')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-word" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-word" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list word">
			
				<g:if test="${wordInstance?.root}">
				<li class="fieldcontain">
					<span id="root-label" class="property-label"><g:message code="word.root.label" default="Root" /></span>
					
						<span class="property-value" aria-labelledby="root-label"><g:fieldValue bean="${wordInstance}" field="root"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.rootSanskrit}">
				<li class="fieldcontain">
					<span id="rootSanskrit-label" class="property-label"><g:message code="word.rootSanskrit.label" default="Root Sanskrit" /></span>
					
						<span class="property-value" aria-labelledby="rootSanskrit-label"><g:fieldValue bean="${wordInstance}" field="rootSanskrit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.rootMeaning}">
				<li class="fieldcontain">
					<span id="rootMeaning-label" class="property-label"><g:message code="word.rootMeaning.label" default="Root Meaning" /></span>
					
						<span class="property-value" aria-labelledby="rootMeaning-label"><g:fieldValue bean="${wordInstance}" field="rootMeaning"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.gender}">
				<li class="fieldcontain">
					<span id="gender-label" class="property-label"><g:message code="word.gender.label" default="Gender" /></span>
					
						<span class="property-value" aria-labelledby="gender-label"><g:fieldValue bean="${wordInstance}" field="gender"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.antak}">
				<li class="fieldcontain">
					<span id="antak-label" class="property-label"><g:message code="word.antak.label" default="Antak" /></span>
					
						<span class="property-value" aria-labelledby="antak-label"><g:fieldValue bean="${wordInstance}" field="antak"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.vibhakti}">
				<li class="fieldcontain">
					<span id="vibhakti-label" class="property-label"><g:message code="word.vibhakti.label" default="Vibhakti" /></span>
					
						<span class="property-value" aria-labelledby="vibhakti-label"><g:fieldValue bean="${wordInstance}" field="vibhakti"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.ekVachan}">
				<li class="fieldcontain">
					<span id="ekVachan-label" class="property-label"><g:message code="word.ekVachan.label" default="Ek Vachan" /></span>
					
						<span class="property-value" aria-labelledby="ekVachan-label"><g:fieldValue bean="${wordInstance}" field="ekVachan"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.ekVachanSanskrit}">
				<li class="fieldcontain">
					<span id="ekVachanSanskrit-label" class="property-label"><g:message code="word.ekVachanSanskrit.label" default="Ek Vachan Sanskrit" /></span>
					
						<span class="property-value" aria-labelledby="ekVachanSanskrit-label"><g:fieldValue bean="${wordInstance}" field="ekVachanSanskrit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.bahuVachan}">
				<li class="fieldcontain">
					<span id="bahuVachan-label" class="property-label"><g:message code="word.bahuVachan.label" default="Bahu Vachan" /></span>
					
						<span class="property-value" aria-labelledby="bahuVachan-label"><g:fieldValue bean="${wordInstance}" field="bahuVachan"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.bahuVachanMeaning}">
				<li class="fieldcontain">
					<span id="bahuVachanMeaning-label" class="property-label"><g:message code="word.bahuVachanMeaning.label" default="Bahu Vachan Meaning" /></span>
					
						<span class="property-value" aria-labelledby="bahuVachanMeaning-label"><g:fieldValue bean="${wordInstance}" field="bahuVachanMeaning"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.bahuVachanSanskrit}">
				<li class="fieldcontain">
					<span id="bahuVachanSanskrit-label" class="property-label"><g:message code="word.bahuVachanSanskrit.label" default="Bahu Vachan Sanskrit" /></span>
					
						<span class="property-value" aria-labelledby="bahuVachanSanskrit-label"><g:fieldValue bean="${wordInstance}" field="bahuVachanSanskrit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.dweVachan}">
				<li class="fieldcontain">
					<span id="dweVachan-label" class="property-label"><g:message code="word.dweVachan.label" default="Dwe Vachan" /></span>
					
						<span class="property-value" aria-labelledby="dweVachan-label"><g:fieldValue bean="${wordInstance}" field="dweVachan"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.dweVachanMeaning}">
				<li class="fieldcontain">
					<span id="dweVachanMeaning-label" class="property-label"><g:message code="word.dweVachanMeaning.label" default="Dwe Vachan Meaning" /></span>
					
						<span class="property-value" aria-labelledby="dweVachanMeaning-label"><g:fieldValue bean="${wordInstance}" field="dweVachanMeaning"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.dweVachanSanskrit}">
				<li class="fieldcontain">
					<span id="dweVachanSanskrit-label" class="property-label"><g:message code="word.dweVachanSanskrit.label" default="Dwe Vachan Sanskrit" /></span>
					
						<span class="property-value" aria-labelledby="dweVachanSanskrit-label"><g:fieldValue bean="${wordInstance}" field="dweVachanSanskrit"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${wordInstance?.ekVachanMeaning}">
				<li class="fieldcontain">
					<span id="ekVachanMeaning-label" class="property-label"><g:message code="word.ekVachanMeaning.label" default="Ek Vachan Meaning" /></span>
					
						<span class="property-value" aria-labelledby="ekVachanMeaning-label"><g:fieldValue bean="${wordInstance}" field="ekVachanMeaning"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${wordInstance?.id}" />
					<g:link class="edit" action="edit" id="${wordInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
