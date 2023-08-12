<#if entries?has_content>
<ul class="navbar-nav main_navigation">
	<#list entries as navigationEntry>
		<li id="${navigationEntry?index}"><a class="nav-link" href="${navigationEntry.getURL()}">${navigationEntry.getName()}</a></li>
	</#list>
	</ul>  
</#if>
<script>
    $(document).ready(function(){
        $("#0").addClass("active");
    })
    
</script>