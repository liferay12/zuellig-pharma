package com.zpharma.router.portlet;

import com.zpharma.router.constants.RouterPortletKeys;

import java.io.IOException;
import java.util.List;

import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.liferay.portal.kernel.util.PortalUtil;


import javax.portlet.Portlet;
import javax.portlet.PortletException;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Router",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RouterPortletKeys.ROUTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RouterPortlet extends MVCPortlet {
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
		 
			User currentUser = PortalUtil.getUser(renderRequest);
			
			
			if (currentUser != null) {
				List<Role> assignedRoles = currentUser.getRoles();

				for (Role role : assignedRoles) {
					if (role.getName().equalsIgnoreCase("Administrator")) {
						
						((HttpServletResponse)PortalUtil.getHttpServletResponse(renderResponse)).sendRedirect("/web/zuellig-pharma/home");

					} else if (role.getName().equalsIgnoreCase("customer")) {
						
						((HttpServletResponse)PortalUtil.getHttpServletResponse(renderResponse)).sendRedirect("/group/zuellig-pharma/customer-home");

					} else if (role.getName().equalsIgnoreCase("client")) {
						
						((HttpServletResponse)PortalUtil.getHttpServletResponse(renderResponse)).sendRedirect("/group/zuellig-pharma/client-home");
					}
				}
			} else {
				((HttpServletResponse)PortalUtil.getHttpServletResponse(renderResponse)).sendRedirect("/web/zuellig-pharma/home");
			}
			
			
		} catch (PortalException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}