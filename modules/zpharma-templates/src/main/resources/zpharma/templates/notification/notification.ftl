<div class="notifications">
<#if Title.getSiblings()?has_content>
<div class="container">
<label><i class="fas fa-bullhorn mr-2"></i><span class="d-none d-sm-block">Notifications</span></label>
<marquee>
	<#list Title.getSiblings() as cur_Title>
	<#if cur_Title.getData()?has_content>
        <a href="${Title.link.getData()}" default="_blank"> ${cur_Title.getData()}</a>  |  
    </#if>
    </#list>
</marquee></div>
</div>
</#if>