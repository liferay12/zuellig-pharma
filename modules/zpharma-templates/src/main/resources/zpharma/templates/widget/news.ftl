<#if entries?has_content>
<div class="container py-3 news">
   <h4 class="h4 border-bottom mb-4 bg-secondary text-white p-2"> <strong>News</strong></h4>
   
       
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
		
		   <#assign thumbnail=docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
			<#assign thumbnailObj = jsonFactoryUtil.createJSONObject(thumbnail) />
			 <#if thumbnailObj.groupId?has_content && thumbnailObj.uuid?has_content>
			  <#assign thumbnailUrl="/documents/"+thumbnailObj.groupId+"/"+thumbnailObj.uuid />
		   </#if>
		  
							  <div class="row">
								<div class="col-sm-4 mb-3 pr-sm-0">
								 <img class="img-thumbnail w-100" src="${thumbnailUrl}" alt="image">
								 </div>
								<div class="col-sm-8">
											<h5><b><a href="" class="text-dark"> ${shortDesc}</a></b></h5>
											<p>${Description}</p>
								</div>
								</div>
									
		</#if>
	</#list>
	
		</div>

		
		
		
</#if>