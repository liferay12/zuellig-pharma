<div class="product_options">
            <div class="box">
            <h3><#if (webcontentHeadingImage.getData())?? && webcontentHeadingImage.getData() != "">
            <img alt="${webcontentHeadingImage.getAttribute("alt")}" data-fileentryid="${webcontentHeadingImage.getAttribute("fileEntryId")}" src="${webcontentHeadingImage.getData()}" />
            </#if> ${webcontentHeadingText.getData()}
            </h3>
            <#assign isAdmin=false/>
            <#assign roles=themeDisplay.getUser().getRoles()/>
            <#list roles as role >
		    <#if role.name="Administrator" >
		    
			<#assign isAdmin=true/>
		    </#if>
            </#list>
            <ul>
            <#assign assetCategoryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetCategoryLocalService")>
            <#assign  dLFileEntryLocalService = serviceLocator.findService("com.liferay.document.library.kernel.service.DLFileEntryLocalService")>
            <#assign allDocuments = documentsAndMediaLink.getSiblings() + externalDocumentTitle.getSiblings()>
     
 <#list allDocuments as cur_document>
 <#assign categoryName = "">
   <#if cur_document.getData()?contains("?")>
		   <#assign pathParamsFromLink = cur_document.getData()?split("?")[0]?split("/")>
		   <#assign groupId = pathParamsFromLink[2]?number >
		   <#assign uuId= pathParamsFromLink[5]?string >
           <#assign dlFileEntry= dLFileEntryLocalService.getDLFileEntryByUuidAndGroupId(uuId, groupId)>
           <#assign assetCategories = assetCategoryLocalService.getAssetEntryAssetCategories(dlFileEntry.getFileEntryId()) />
           
           <#if assetCategories?has_content >
           <#assign categoryName = assetCategories[0].name>
	       </#if>
     <#if categoryName==themeDisplay.getUser().screenName || isAdmin==true>
           
           <li>
           <#switch dlFileEntry.getMimeType()>
           <#case "image/jpeg" >
           <i class="far fa-file-image mr-4" style="color:#459fe2; font-size: 1.5rem; "></i>
           <#break>
           <#case "application/zip">
           <i class="far fa-file-archive mr-4" style="color: #f6c75c; font-size: 1.5rem;"></i>
           <#break>
           <#case "application/pdf">
           <i class="far fa-file-pdf mr-4" style="color: #d7221a; font-size: 1.5rem;"></i>
           <#break>
           <#case "application/msword">
           <i class="far fa-file-word mr-4" style="color:#295294; font-size: 1.5rem;"></i>
           <#break>
           <#case "application/vnd.ms-excel">
           <i class="far fa-file-excel mr-4" style="color:#007c3e; font-size: 1.5rem;"></i>
           <#break>
           <#default>
           <i class="far fa-file mr-4" style="font-size: 1.5rem;"></i>
           </#switch>
		 
           <a href="${cur_document.getData()}" target="_blank">
    	   <p class="break-word mb-0">	${dlFileEntry.getFileName()}</p>
             </a>
           </li>
     </#if> 
    
   <#else>
    <#if categoryName==themeDisplay.getUser().screenName || isAdmin==true>
            <li>
    	    <i class="far fa-file mr-4" style="font-size: 1.5rem;"></i>
    		<a href="${cur_document.externalDocumentUrl.getData()}" target="_blank">
    			<p class="break-word mb-0">	${cur_document.getData()}</p>
             </a>
            </li>
            </#if>
   </#if>
       
            <#if cur_document?index &gt; 4>
            <#break>
            </#if>
      
 </#list>

            </ul>
     
	
            <#if allDocuments?size &gt; 6>
            <a href="" class="view_more">View More</a>
            </#if>
   </div>
</div>