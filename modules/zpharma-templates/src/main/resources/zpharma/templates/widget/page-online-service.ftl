<#if entries?has_content>
<section id="zp_news_content" class="section " style="background-color:#ffffff;">
    <div class="container"><div class="row">
        <div class="col-sm-12">
            <div class="container" style="padding:20px 8px 0px 48px;">
                <div class="sppb-addon sppb-addon-text-block sppb-text-left  left-news-insights-section-h3
                shadow-none p-3 mb-3 bg-light"><h3 style="margin-top:2px;margin-bottom:2px;font-size:21px;line-height:21px;font-weight:bold;">Page  Online Service</h3><div class="sppb-addon-content"></div></div></div></div></div></div></section>
                <br>
<section class="sppb-section bgwhite" style="background-color:#ffffff;">
    <div class="sppb-row">
        <div class="sppb-col-sm-12">
            <div class="sppb-addon-container lt-intro-sub sppb-wow fadeInDown sppb-animated" style="visibility: visible; animation-duration: 300ms; animation-delay: 300ms; animation-name: fadeInDown;" data-sppb-wow-duration="300ms" data-sppb-wow-delay="300ms">
                <div class="sppb-divider sppb-divider-border" style="margin-top:6px;margin-bottom:6px; border-bottom-color:#f2f2f2;border-bottom-style:solid;border-bottom-width:1px;">
                    
                </div></div></div></div></section>
<div class="container ">
<div class="row">



	

	
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
		  
							<div class="row">
								<div class="col-sm-4">
									<div class="container" style="margin:2px 10px 10px 60px;">
										<div class="sppb-addon sppb-addon-single-image sppb-text-left ">
											<div class="content">
											<img class="sppb-img-responsive" src="${thumbnailUrl}" alt="image">
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-8">
									<div class="container" style="margin:0px 10px 10px 10px;">
										<div class="text-left ">
											<h5 ><b><a href=""class="text-dark">${title}</a></b></h5>
											<p><span style="font-size: 16px; ; font-family: Raleway;">${Description}</span><br>
											
										<#--	<a href="" class="text-dark"><b>READ</b><span class="glyphicon glyphicon-play" style="color:green" /></a>--> </p>
										</div>
									</div>
								</div>
								<hr style="width:100%;text-align:left;margin-left:0">	
							</div>
					<br>
				
		   
           
       
		   
		</#if>
	</#list>
<#--	<a href="" class="text-dark" style="margin:40px 0px 60px 1000px;"><b>MORE</b><span class="glyphicon glyphicon-play" style="color:green" /></a> 	-->
		
		</div>
		</div>
	
		
</#if>