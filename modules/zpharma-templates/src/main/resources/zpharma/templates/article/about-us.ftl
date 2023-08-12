<section class="about">
   <div class="container">
      <div class="row">
         <div class="col-md-8">
            <h5>${title.getData()}</h5>
            <h3>${shortDescription.getData()}</h3>
            <p>${description.getData()}</p>
            <ul class="list-unstyled">
                <li>
                    <#if (image.getData())?? && image.getData() != "">
                    	<img alt="${image.getAttribute("alt")}" data-fileentryid="${image.getAttribute("fileEntryId")}" src="${image.getData()}" />
                    </#if>
                    <div class="text">${bodyContent.getData()}</div>
                </li>
            </ul>
         </div>
         <div class="col-md-4">
            <#if (thumbnail.getData())?? && thumbnail.getData() != "">
            	<img alt="${thumbnail.getAttribute("alt")}" data-fileentryid="${thumbnail.getAttribute("fileEntryId")}" src="${thumbnail.getData()}" />
            </#if>
         </div>
      </div>
   </div>
</section>