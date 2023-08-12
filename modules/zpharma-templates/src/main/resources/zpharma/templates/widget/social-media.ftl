<div class="mt-4">
    <#if entries?has_content>
        <#list entries as appEntry>
            <a href="${appEntry.getURL()}" target="_blank"><img src="${appEntry.iconURL()}" alt="${appEntry.getName()}" style="width:54px; height:auto;" title="${appEntry.getName()}"/>
            </a>
        </#list>
    </#if>
</div>



