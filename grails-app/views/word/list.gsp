
<%@ page import="sdb1.Word" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'word.label', default: 'Word')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-word" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		<div id="list-word" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
<fieldset class="form">
    <g:form action="list" method="GET">
        <div class="fieldcontain">
            <label for="query">Search for </label>
            <g:textField name="query" value="${params.query}"/>
          <g:radioGroup name="category"
              labels="['root','rootMeaning']"
              values="['root', 'rootMeaning']"
              value="${params.category}"
              >
<p>${it.label} ${it.radio}</p>
</g:radioGroup>
        </div>
    </g:form>
</fieldset>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="root" title="${message(code: 'word.root.label', default: 'Root')}" params="[query:params.query, category:params.category]" />
					
						<g:sortableColumn property="rootSanskrit" title="${message(code: 'word.rootSanskrit.label', default: 'Root Sanskrit')}"  params="[query:params.query, category:params.category ]" />
					
						<g:sortableColumn property="rootMeaning" title="${message(code: 'word.rootMeaning.label', default: 'Root Meaning')}"  params="[query:params.query, category:params.category]" />
					
				
						<g:sortableColumn property="vibhakti" title="${message(code: 'word.vibhakti.label', default: 'Vibhakti')}" params="[query:params.query, category:params.category]" />
							<g:sortableColumn property="ekVachanSanskrit" title="${message(code: 'word.ekVachanSanskrit.label', default: 'ekVachanSanskrit')}"  params="[query:params.query, category:params.category]" />
						<g:sortableColumn property="dweVachanSanskrit" title="${message(code: 'word.dweVachanSanskrit.label', default: 'dweVachanSanskrit')}"  params="[query:params.query, category:params.category]" />
						<g:sortableColumn property="bahuVachanSanskrit" title="${message(code: 'word.bahuVachanSanskrit.label', default: 'bahuVachanSanskrit')}"  params="[query:params.query, category:params.category]" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${wordInstanceList}" status="i" var="wordInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${wordInstance.id}">${fieldValue(bean: wordInstance, field: "root")}</g:link></td>
					
						<td>${fieldValue(bean: wordInstance, field: "rootSanskrit")}</td>
					
						<td>${fieldValue(bean: wordInstance, field: "rootMeaning")}</td>
					
					
					
						<td>${fieldValue(bean: wordInstance, field: "vibhakti")}</td>
					<td>${fieldValue(bean: wordInstance, field: "ekVachanSanskrit")}</td>
						<td>${fieldValue(bean: wordInstance, field: "dweVachanSanskrit")}</td>
						<td>${fieldValue(bean: wordInstance, field: "bahuVachanSanskrit")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			
			
<div class="pagination">
<g:if test="${!params.query}">
<g:paginate total="${wordInstanceTotal}"/>
</g:if>
<g:else>
<g:paginate total="${wordInstanceTotal}" 
        params="[query:params.query, category:params.category]" />
</g:else>
</div>
			
		</div>
	</body>
</html>
