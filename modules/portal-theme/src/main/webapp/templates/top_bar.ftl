<div class="d-flex justify-content-end d-block d-sm-none pr-2" data-toggle="collapse" data-target="#togglebar"><i class="fas fa-ellipsis-v cp"></i></div>
<div class="container-fluid collapse show" id="togglebar">

   <div class="d-flex customFlex">
      <div class="topbar_left">
		<@liferay_portlet["runtime"]
                defaultPreferences=default_preferences
                portletProviderAction=portletProviderAction.VIEW
               instanceId="c0nT5cTu2"                           
               portletName="com_zpharma_topbar_TopBarPortlet" />
      </div>
      <div class="topbar_right">
         <div class="topbar-text d-none d-sm-block"><span onload="currentDate();" class="mr-2" id="currentDate"></span><span onload="currentTime()" id = "currentClock"></span></div>
         <div class="topbar-text d-none d-sm-block">Language :</div>
         <div class="dropdown">
            <@liferay_portlet["runtime"]
					defaultPreferences=default_preferences
					portletProviderAction=portletProviderAction.VIEW
					portletProviderClassName="com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry"
					/>
         </div>
      </div>
   </div>
</div>

<script>
var request = new XMLHttpRequest();

request.open('GET', 'https://api.ipdata.co/?api-key=test');

request.setRequestHeader('Accept', 'application/json');

request.onreadystatechange = function () {
  if (this.readyState === 4) {
    console.log(this.responseText);
  }
};

request.send();
</script>