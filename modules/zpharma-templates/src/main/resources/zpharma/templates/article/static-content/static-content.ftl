<div class="product_info">
  
        
            <div class="box">
                <h5>${title.getData()}</h5>
                <div class="small_box"><span class="price">${price.getData()}</span><#if (image.getData())?? && image.getData() != "">
	<img alt="${image.getAttribute("alt")}" data-fileentryid="${image.getAttribute("fileEntryId")}" src="${image.getData()}" />
</#if></div>
                <span class="date">${date.getData()}</span>
            </div>
      
       
        
   
</div>