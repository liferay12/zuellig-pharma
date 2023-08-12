<%@page import="com.zpharma.commons.web.constants.MVCCommandName"%>
<%@page import="com.zpharma.model.SiteConfig"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ include file="/init.jsp" %>

<%
	final  Log LOGGER = LogFactoryUtil.getLog("SiteConfig jsp");
	SiteConfig siteConfig = (SiteConfig)request.getAttribute("siteConfig");
	
	boolean showCustomUserRegistration = false;
	String siteEmailAddress="";
	long sitePhoneNumber=0;
	String openinghours="";
	String copyright="";
	Long siteConfigId = null;
	long groupId= themeDisplay.getSiteGroupId();
	
	if(siteConfig!=null){
		siteConfigId = siteConfig.getSiteConfigId();
		showCustomUserRegistration = siteConfig.getShowCustomUserRegistration();
		siteEmailAddress=siteConfig.getSiteEmailAddress();
		sitePhoneNumber=siteConfig.getSitePhoneNumber();
		openinghours=siteConfig.getOpeninghours();
		copyright=  siteConfig.getCopyright();
	}
	
%>
<portlet:actionURL name="<%=MVCCommandName.SAVE_SITECONFIG%>"
	var="saveSiteConfig">
</portlet:actionURL>

<div class="form-card px-8 p-5">
	<div class="card-body bg-white">
		<aui:form action="<%=saveSiteConfig %>">
			<aui:input type="hidden" name="siteConfigId" value="<%=siteConfigId%>"></aui:input>
			<div class="row">
				<div class="col-md-12">
					<aui:input type="checkbox" name="showCustomUserRegistration" label="Show Custom User Registration Page" value="<%=showCustomUserRegistration%>" />
				</div>
				<div class="col-md-12">
					<aui:input type="text" name="siteEmailAddress" label="Email" value="<%=siteEmailAddress%>" />
				</div>
				<div class="col-md-12">
					<aui:input type="text" name="sitePhoneNumber" label="Phone" value="<%=sitePhoneNumber%>" />
				</div>
				<div class="col-md-12">
					<aui:input type="text" name="openinghours" label="Opening Hours" value="<%=openinghours%>" />
				</div>
				<div class="col-md-12">
					<aui:input type="text" name="copyright" label="Copy Right" value="<%=copyright%>" />
				</div>
			</div>
			
			</div>
			<aui:button-row>
				<aui:button type="submit" name="submit" id="submit"></aui:button>
			</aui:button-row>
		</aui:form>
	</div>
</div>