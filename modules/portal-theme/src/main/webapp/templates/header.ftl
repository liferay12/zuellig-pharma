<nav class="navbar navbar-expand-xl navbar-light">
	<div class="container-fluid">
		<#-- <div class="col-md-2"> -->
			<a class="${logo_css_class} navbar-brand logo-width" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<img alt="${logo_description}" src="${site_logo}" />
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#responsiveHumbergerMenu">
    <span class="navbar-toggler-icon"></span>
  </button>
			
	
			<#if show_site_name>
				<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
					${site_name}
				</span>
			</#if>
			<#-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#responsiveNab" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button> -->
		<#--</div>-->
		<div class="collapse navbar-collapse" id="responsiveHumbergerMenu">
		<#if has_navigation && is_setup_complete>
			<#--  <div class="col-md-8">-->
				<@liferay.navigation_menu instance_id="top_navigation_menu"/>
			<#--</div>-->
			<#-- <div class="col-md-2">-->
			<div class="login_menu">
				<#--<@liferay.navigation_menu instance_id="login_navigation_menu"/>-->
				<@liferay.user_personal_bar /> 
				<#if themeDisplay.isSignedIn()>
					<span> Welcome ${user.getFirstName()} ${user.getLastName()} </span>
				</#if>
			</div>
			<#--</div>
			<@liferay.user_personal_bar />-->
		</#if>
		</div>
	</div> 
</nav>

<#-- <script>
function openMenu(){
	$(".sticker-img").click();
}
</script> -->