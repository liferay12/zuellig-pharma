<div class="container">
   <div class="row">
      <div class="col-md-4">
         <div class="footer_box_1">
            <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
            <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
            </a>
            <#if show_site_name>
            <span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
            ${site_name}
            </span>
            </#if>
            <#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />

			<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
			  instance_id="social_navigation_menu"/>
         </div>
      </div>
	  <div class="col-md-8">
		<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />

		<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
		  instance_id="footer_navigation_menu"/>
	 </div>  	  	
   </div>
   <div class="row footer_copy">
      <div class="col-md-6"><#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
		  instance_id="copy_right"/></div>

      <div class="col-md-6 text-sm-right">
<#assign preferencesMap = {"displayDepth": "1", "portletSetupPortletDecoratorId": "barebone"} />
<@liferay.navigation_menu default_preferences=freeMarkerPortletPreferences.getPreferences(preferencesMap)
		  instance_id="disclaimer_navigation_menu"/>
</div>
   </div>
</div>