

 <div class="product_options">
    
            <div class="box">
                
                <h3><img src="${themeDisplay.getPathThemeImages()}/favourite_product.png" alt=""> Favorite  Services </h3>
               <#assign count = 0>
               <#include "customer-widget.ftl">
<#if (count>=4)>
<a href="${themeDisplay.getPortalURL()}${"${themeDisplay.getURLCurrent()}"?keep_before("${themeDisplay.getLayout().getFriendlyURL()}")}/customer-online-services" class="view_more">View More</a>
</#if>
	</div>
	</div>
