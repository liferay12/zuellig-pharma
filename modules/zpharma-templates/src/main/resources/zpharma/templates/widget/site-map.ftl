<div class="container py-3">
<#if entries?has_content>

	<h4 class="h4 border-bottom mb-4 bg-secondary text-white p-2"> <strong>Sitemap</strong></h4>
	<ul class="list-unstyled rounded-lg pl-3">
	<#list entries as curPage>
	
	
	   <#if curPage.getName(locale)!="Site Map" && curPage.getName(locale)!="Router" && curPage.getName(locale)!="Guest-Home">
	<li class="mb-1"><a class="" href="${themeDisplay.getPortalURL()}${"${themeDisplay.getURLCurrent()}"?keep_before("${themeDisplay.getLayout().getFriendlyURL()}")}${curPage.getFriendlyURL()}" style="color: black;">${curPage.getName(locale)}</a>
	
	</li>
</#if>
	
	
	</#list>
	</ul>
</#if>
<style>
    .list-unstyled{list-style:disc;}
</style>
</div>