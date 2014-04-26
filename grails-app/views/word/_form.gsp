<%@ page import="sdb1.Word" %>



<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'root', 'error')} required">
	<label for="root">
		<g:message code="word.root.label" default="Root" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="root" required="" value="${wordInstance?.root}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'rootSanskrit', 'error')} required">
	<label for="rootSanskrit">
		<g:message code="word.rootSanskrit.label" default="Root Sanskrit" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rootSanskrit" required="" value="${wordInstance?.rootSanskrit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'rootMeaning', 'error')} required">
	<label for="rootMeaning">
		<g:message code="word.rootMeaning.label" default="Root Meaning" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rootMeaning" required="" value="${wordInstance?.rootMeaning}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'gender', 'error')} required">
	<label for="gender">
		<g:message code="word.gender.label" default="Gender" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="gender" from="${wordInstance.constraints.gender.inList}" required="" value="${wordInstance?.gender}" valueMessagePrefix="word.gender"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'antak', 'error')} required">
	<label for="antak">
		<g:message code="word.antak.label" default="Antak" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="antak" from="${wordInstance.constraints.antak.inList}" required="" value="${wordInstance?.antak}" valueMessagePrefix="word.antak"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'vibhakti', 'error')} required">
	<label for="vibhakti">
		<g:message code="word.vibhakti.label" default="Vibhakti" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="vibhakti" from="${wordInstance.constraints.vibhakti.inList}" required="" value="${wordInstance?.vibhakti}" valueMessagePrefix="word.vibhakti"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'ekVachan', 'error')} ">
	<label for="ekVachan">
		<g:message code="word.ekVachan.label" default="Ek Vachan" />
		
	</label>
	<g:textField name="ekVachan" value="${wordInstance?.ekVachan}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'ekVachanSanskrit', 'error')} ">
	<label for="ekVachanSanskrit">
		<g:message code="word.ekVachanSanskrit.label" default="Ek Vachan Sanskrit" />
		
	</label>
	<g:textField name="ekVachanSanskrit" value="${wordInstance?.ekVachanSanskrit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'bahuVachan', 'error')} ">
	<label for="bahuVachan">
		<g:message code="word.bahuVachan.label" default="Bahu Vachan" />
		
	</label>
	<g:textField name="bahuVachan" value="${wordInstance?.bahuVachan}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'bahuVachanMeaning', 'error')} ">
	<label for="bahuVachanMeaning">
		<g:message code="word.bahuVachanMeaning.label" default="Bahu Vachan Meaning" />
		
	</label>
	<g:textField name="bahuVachanMeaning" value="${wordInstance?.bahuVachanMeaning}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'bahuVachanSanskrit', 'error')} ">
	<label for="bahuVachanSanskrit">
		<g:message code="word.bahuVachanSanskrit.label" default="Bahu Vachan Sanskrit" />
		
	</label>
	<g:textField name="bahuVachanSanskrit" value="${wordInstance?.bahuVachanSanskrit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'dweVachan', 'error')} ">
	<label for="dweVachan">
		<g:message code="word.dweVachan.label" default="Dwe Vachan" />
		
	</label>
	<g:textField name="dweVachan" value="${wordInstance?.dweVachan}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'dweVachanMeaning', 'error')} ">
	<label for="dweVachanMeaning">
		<g:message code="word.dweVachanMeaning.label" default="Dwe Vachan Meaning" />
		
	</label>
	<g:textField name="dweVachanMeaning" value="${wordInstance?.dweVachanMeaning}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'dweVachanSanskrit', 'error')} ">
	<label for="dweVachanSanskrit">
		<g:message code="word.dweVachanSanskrit.label" default="Dwe Vachan Sanskrit" />
		
	</label>
	<g:textField name="dweVachanSanskrit" value="${wordInstance?.dweVachanSanskrit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: wordInstance, field: 'ekVachanMeaning', 'error')} ">
	<label for="ekVachanMeaning">
		<g:message code="word.ekVachanMeaning.label" default="Ek Vachan Meaning" />
		
	</label>
	<g:textField name="ekVachanMeaning" value="${wordInstance?.ekVachanMeaning}"/>
</div>

