<%@page import="com.zpharma.model.SiteConfig"%>
<%@page import="com.zpharma.service.SiteConfigLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%
	SiteConfig siteConfig = SiteConfigLocalServiceUtil.getSiteConfig(themeDisplay.getScopeGroup());
	boolean showCustomUserRegistration = false;
	if(siteConfig!=null){
		showCustomUserRegistration = siteConfig.getShowCustomUserRegistration();
	}
	if (showCustomUserRegistration) {
%>
<%@ include file="/create_account.custom.jsp" %>

<%}else { %>
<liferay-util:include
    page="/create_account.original.jsp"
    servletContext="<%= application %>"
/>
<%
	}
%>
