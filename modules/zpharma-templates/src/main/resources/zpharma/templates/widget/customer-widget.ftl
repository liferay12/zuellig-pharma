<#if entries?has_content>
<ul>

   <#list entries as curEntry>
   <#assign assetRenderer = curEntry.getAssetRenderer() />
   <#if assetRenderer.getClassName()=="com.liferay.journal.model.JournalArticle">
	   <#assign entry=curEntry />
	   <#assign entryTitle = htmlUtil.escape(entry.getTitle(locale)) />
	   <#assign docXml=saxReaderUtil.read(entry.getAssetRenderer().getArticle().getContent()) />
	   <#assign readMoreLink=docXml.valueOf("//dynamic-element[@name='ReadMoreLink']/dynamic-content/text()") />
	   <#assign shortDesc=docXml.valueOf("//dynamic-element[@name='shortDescription']/dynamic-content/text()") />
	   <#assign title=docXml.valueOf("//dynamic-element[@name='title']/dynamic-content/text()") />
           
	   <#assign internalLink=docXml.valueOf("//dynamic-element[@name='internalLink']/dynamic-content/text()") />
	   <#assign layoutLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.LayoutLocalService")>
	   <#assign internalLinkObj = jsonFactoryUtil.createJSONObject(internalLink) />
	   <#if internalLinkObj.groupId?has_content && internalLinkObj.layoutId?has_content>
	   <#assign internalLinkGroupId=internalLinkObj.groupId />
	   <#assign internalLinkLayoutId=internalLinkObj.layoutId />
	   <#assign internalLinkLayout = layoutLocalService.getLayout(internalLinkGroupId?number, true, internalLinkLayoutId?number) />
	   <#assign internalLinkURL = internalLinkLayout.getFriendlyURL() />
	   </#if>
	   <#assign externalLink=docXml.valueOf("//dynamic-element[@name='externalLink']/dynamic-content/text()") />
	   <#assign thumbnail=docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
	   <#assign thumbnailObj = jsonFactoryUtil.createJSONObject(thumbnail) />
	   <#if thumbnailObj.groupId?has_content && thumbnailObj.uuid?has_content>
	   <#assign thumbnailUrl="/documents/"+thumbnailObj.groupId+"/"+thumbnailObj.uuid />
	   </#if>
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
		  
		  
			   <#if externalLink !="" || internalLink !="">
			   <#assign count =count+1>

				   <#if (count==4)>
				   <#break>
				   </#if>
				   <li>
					  <img src="${thumbnailUrl}" alt="image">
                                          
					  <#if externalLink !="">
                                     
					  <a href="${externalLink}" style="color: black;"  target="_blank">
						 <p class="break-word mb-0">${title}</p>
					  </a>
                                           
					  <#else >
					  <a href="${themeDisplay.getPortalURL()}${"${themeDisplay.getURLCurrent()}"?keep_before("${themeDisplay.getLayout().getFriendlyURL()}")}${internalLinkURL}" style="color: black;"> 
					  <p class="break-word mb-0">${title}</p>
					  </a>
					  </#if>   
				   </li>
			   </#if>      
		   </#if>
	   
	   </#if>
   </#list>
</ul>
</#if>