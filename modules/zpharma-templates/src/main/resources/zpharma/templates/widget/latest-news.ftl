<section class="latest_news">
   <div class="container ctrlbgImage">
      <div class="row">
         <div class="col-md-4">
            <div class="news_heading">
               <h5>Latest</h5>
               <h3>NEWS & announcements</h3>
               <p>Get the very latest news on Zuellig Pharma and the Asian healthcare market from our experts across the region.</p>
               <div class="d-flex">
                   <a href="${themeDisplay.getPortalURL()}${"${themeDisplay.getURLCurrent()}"?keep_before("${themeDisplay.getLayout().getFriendlyURL()}")}/news-announcements"><button class="btn btn-primary">View All News <img src="${themeDisplay.getPathThemeImages()}/discover_arrow.png"></button></a></div>
            </div>
         </div>
         <div class="col-md-8">
            <div class="row">
				<#if entries?has_content>
					<#list entries as curEntry>
					<#if (curEntry?index &gt; 3)>
						<#break>
					</#if>
					<#assign assetRenderer = curEntry.getAssetRenderer() />
						<#if assetRenderer.getClassName()=="com.liferay.journal.model.JournalArticle">
							<#assign entry=curEntry />
							<#assign entryTitle = htmlUtil.escape(entry.getTitle(locale)) />
							<#assign docXml=saxReaderUtil.read(entry.getAssetRenderer().getArticle().getContent()) />
							<#assign readMoreLink=docXml.valueOf("//dynamic-element[@name='ReadMoreLink']/dynamic-content/text()") />
							<#assign shortDesc=docXml.valueOf("//dynamic-element[@name='shortDescription']/dynamic-content/text()") />
							<#assign imagePath=docXml.valueOf("//dynamic-element[@name='thumbnail']/dynamic-content/text()") />
							<#assign imagePathObj = jsonFactoryUtil.createJSONObject(imagePath) />
							 <#if imagePathObj.groupId?has_content && imagePathObj.uuid?has_content>
							  <#assign imageUrl="/documents/"+imagePathObj.groupId+"/"+imagePathObj.uuid />
						   </#if>
						   <div class="col-md-6">
						   		<#if curEntry?index%2==0>
									<div class="box">
								<#else>
									<div class="box mt-5 ctrlResponsive">
								</#if>
								<#if imageUrl??>
									<img class="w-100" src="${imageUrl}" alt="Image">
								</#if>
								 <p><a href="${readMoreLink}">${shortDesc}</b></p>
								 <span>${curEntry.publishDate?date}</span>
								</div>
						  </div>
						</#if>
					</#list>
				</#if>
               
            </div>
         </div>
      </div>
   </div>
   <style>.ctrlbgImage{position:relative; z-index:1}</style>
</section>