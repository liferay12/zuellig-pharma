<div class="row">
<#if entries?has_content>
	<#list entries as navigationEntry>
<div class="col-md-4">
<ul class="parent-ul">
  <li class="parent-li"><h3 data-toggle="collapse" data-target="#${navigationEntry.getName()}">${navigationEntry.getName()}  <span class="d-block d-sm-none"><i class="fas fa-angle-down"></i></span></h3>
  <ul id="${navigationEntry.getName()}" class="collapse" >
      <#if  navigationEntry.hasChildren()>
	<#list  navigationEntry.getChildren() as child_nav>
        <li><a href="${child_nav.getURL()}" target="_blank">${child_nav.getName()}</a></li>
    </#list>
    </#if>
  </ul>
  </li>
</ul>
</div>
  	</#list>
</#if>
</div>