<!DOCTYPE html>
<#include init />
<html class="${root_css_class}" dir='<@liferay.language key="lang.dir" />'>
   <head>
      <title>${html_title}</title>
 
      <meta name="viewport" content="width=device-width, initial-scale=1"/>
      <@liferay.js file_name = "${javascript_folder}/jquery-3.6.0.min.js" />
      <@liferay.css file_name="${css_folder}/all.min.css" />
      <@liferay.css file_name="${css_folder}/fonts/google_fonts.scss" />
       
      
      <@liferay_util["include"] page=top_head_include />
      <@liferay.js file_name = "${javascript_folder}/all.min.js" />
      <@liferay.js file_name = "${javascript_folder}/bootstrap.bundle.min.js" />
      <@liferay.css file_name="${css_folder}/bootstrap.min.css" /> 
      <@liferay.css file_name="${css_folder}/stylesheet.css" />
   </head>
   <body class="${css_class}">
      <@liferay_ui["quick-access"] contentId="#main-content" />
      <@liferay_util["include"] page=body_top_include />
      <@liferay.control_menu />
      <div class="topbar">
         <#include "${full_templates_path}/top_bar.ftl" />
      </div>
      <header class="customer container-fluid">
         <#include "${full_templates_path}/header.ftl" />	
      </header>
      <section class="${portal_content_css_class}">
			<h2 class="sr-only" role="heading" aria-level="1">${the_title}</h2>

			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</section>
      <footer class="footer">
         <#include "${full_templates_path}/footer.ftl" />
      </footer>
      <@liferay_util["include"] page=body_bottom_include />
      <@liferay_util["include"] page=bottom_include />
   </body>

</html>