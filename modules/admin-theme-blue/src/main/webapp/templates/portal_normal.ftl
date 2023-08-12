<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
		<@liferay.css file_name="${css_folder}/custom/bootstrap.min.css" />
		<@liferay.css file_name="${css_folder}/custom/font-awesome.min.css" />
		<@liferay.css file_name="${css_folder}/custom/line-awesome.min.css" />
		<@liferay.css file_name="${css_folder}/custom/style.css" />
		
		<@liferay.js file_name = "${javascript_folder}/custom/jquery-3.6.0.min.js" />
		<@liferay.js file_name = "${javascript_folder}/custom/bootstrap.bundle.min.js" />
		<@liferay.js file_name = "${javascript_folder}/custom/jquery.slimscroll.min.js" />
		<@liferay.js file_name = "${javascript_folder}/custom/app.js" />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />



<div class="container-fluid main-wrapper" id="wrapper">

	<#include "${full_templates_path}/header.ftl" />

	<section id="content">
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

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay</a>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>

</html>