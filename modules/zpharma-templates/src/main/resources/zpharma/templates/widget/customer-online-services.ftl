<#if entries?has_content>
<div class="container py-3 news">
   <h4 class="h4 border-bottom mb-4 bg-secondary text-white p-2"> <strong>Online Services</strong></h4>
   	<div class="row onlineServices">
       
		
	<#list entries as curEntry>
	
	<#assign assetRenderer = curEntry.getAssetRenderer() />
		<#if assetRenderer.getClassName()=="com.liferay.journal.model.JournalArticle">
			<#assign entry=curEntry />
			<#assign entryTitle = htmlUtil.escape(entry.getTitle(locale)) />
			<#assign docXml=saxReaderUtil.read(entry.getAssetRenderer().getArticle().getContent()) />
			<#assign readMoreLink=docXml.valueOf("//dynamic-element[@name='ReadMoreLink']/dynamic-content/text()") />
			<#assign shortDesc=docXml.valueOf("//dynamic-element[@name='shortDescription']/dynamic-content/text()") />
			<#assign Description=docXml.valueOf("//dynamic-element[@name='description']/dynamic-content/text()") />
			<#assign bodyContent=docXml.valueOf("//dynamic-element[@name='bodyContent']/dynamic-content/text()") />
		<#assign title=docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()") />
		
		   <#assign thumbnail=docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
			<#assign thumbnailObj = jsonFactoryUtil.createJSONObject(thumbnail) />
			 <#if thumbnailObj.groupId?has_content && thumbnailObj.uuid?has_content>
			  <#assign thumbnailUrl="/documents/"+thumbnailObj.groupId+"/"+thumbnailObj.uuid />
		   </#if>
		   <#assign externalLink=docXml.valueOf("//dynamic-element[@name='externalLink']/dynamic-content/text()") />
		    
		  <#assign assetCategoryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryLocalService")>
	   <#assign assetCategories = assetCategoryLocalService.getAssetEntryAssetCategories(curEntry.getEntryId()) />
	   <#assign isAdmin=false/>
	   <#assign roles=themeDisplay.getUser().getRoles()/>
	   <#list roles as role >
	   <#if role.name="Administrator" >
       <#assign isAdmin=true/>
       </#if>
       </#list>

	   
	   <#assign assetCategory =""/>
	  
	       <#if assetCategories?has_content >
	         <#assign assetCategory =assetCategories[0].name/>
	         </#if>
		   <#if assetCategory==themeDisplay.getUser().screenName || isAdmin==true>
		  

	    
	    <div class="col-md-3">
	<div class="card">
	    <div class="card-header p-0 text-center">
	 <figure class="mb-0"><img src="${thumbnailUrl}" alt="image"></figure>							 </div>
	<div class="card-body p-3">
	 <#if externalLink !="" >
	<h5><b><a href="${externalLink}" target="_blank" class="text-dark">${title}</a></b></h5>
	<#else > 
	<h5><b><a href="${themeDisplay.getPortalURL()}${"${themeDisplay.getURLCurrent()}"?keep_before("${themeDisplay.getLayout().getFriendlyURL()}")}/page-under-construction"  class="text-dark">${title}</a></b></h5>
	</#if> <p>${Description}</p>
	</div>
	</div>  
	
	</div>
	

       </#if>
		   </#if>
	
	</#list>
<style>
   .onlineServices .card-header img{width:100%; height:150px;}
   .onlineServices .card-body h5{font-size:15px;}
   .onlineServices .card-body p{font-size:13px;}
</style>
		</div>

		</div>
		
		
</#if>