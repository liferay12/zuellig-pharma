<#if !themeDisplay.isSignedIn()>
<div class="login_tabs">
	<ul class="nav nav-tabs">
	  <#assign sign_in_url = htmlUtil.escape(themeDisplay.getURLSignIn())/>
	  <#-- li class="nav-item">
	     <a class="nav-link" id="vendor" href="${sign_in_url}"><img src="${themeDisplay.getPathThemeImages()}/vendor_login.png"> Vendor Login</a>
	  </li -->
	  <li class="nav-item">
	     <a class="nav-link" id="customer" href="${sign_in_url}"><img src="${themeDisplay.getPathThemeImages()}/customer_login.png">Login</a>
	  </li>
	</ul>
</div>

<#else>
    <#assign sign_out_url = htmlUtil.escape(themeDisplay.getURLSignOut())/>
    <#assign profile_pic_url = htmlUtil.escape(user.getPortraitURL(themeDisplay))/>
    <ul class="navbar-nav ml-auto">
    <li class="nav-item dropdown user-info">
        <a class="nav-link dropdown-toggle" href="javascript:void(0)" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> <img src="${profile_pic_url}" width="40px" height="40px"> <span> Welcome ${user.getFirstName()} ${user.getLastName()} </span></a>
        <ul class="dropdown-menu list-unstyled dropdown-menu-right">
           <li><a class="dropdown-item" href="${sign_out_url}"><svg class="svg-inline--fa fa-lock fa-w-14 mr-2" aria-hidden="true" focusable="false" data-prefix="fa" data-icon="lock" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M400 224h-24v-72C376 68.2 307.8 0 224 0S72 68.2 72 152v72H48c-26.5 0-48 21.5-48 48v192c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48V272c0-26.5-21.5-48-48-48zm-104 0H152v-72c0-39.7 32.3-72 72-72s72 32.3 72 72v72z"></path></svg>Logout</a></li>
        </ul>
     </li>
</ul>
</#if>