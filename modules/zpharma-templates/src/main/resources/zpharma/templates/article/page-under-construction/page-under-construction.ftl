<#if (image.getData())?? && image.getData() != "">
	<img alt="${image.getAttribute("alt")}" data-fileentryid="${image.getAttribute("fileEntryId")}" src="${image.getData()}" style="width:4000px;height:700px;"/>
</#if>