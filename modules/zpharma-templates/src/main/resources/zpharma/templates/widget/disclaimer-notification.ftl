<#if entries?has_content>
	<#list entries as navigationEntry>
	<a href="${navigationEntry.getURL()}" target="_blank">${navigationEntry.getName()} |</a>
	</#list>
</#if>