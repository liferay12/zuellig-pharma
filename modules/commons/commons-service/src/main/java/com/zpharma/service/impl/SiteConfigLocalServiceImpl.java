/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.zpharma.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.zpharma.exception.NoSuchSiteConfigException;
import com.zpharma.model.SiteConfig;
import com.zpharma.service.base.SiteConfigLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the site config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.zpharma.service.SiteConfigLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.zpharma.model.SiteConfig", service = AopService.class)
public class SiteConfigLocalServiceImpl extends SiteConfigLocalServiceBaseImpl {
	final static Log LOGGER = LogFactoryUtil.getLog(SiteConfigLocalServiceImpl.class.getName());

	public SiteConfig saveOrUpdateSiteConfiguration(SiteConfig siteConfig) throws PortalException {

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long companyId = user.getCompanyId();

		
		siteConfig.setUserName(user.getFullName());
		siteConfig.setGroupId(groupId);
		siteConfig.setUserId(userId);
		siteConfig.setCompanyId(companyId);

		siteConfigPersistence.update(siteConfig);
		return siteConfig;
	}

	public SiteConfig getSiteConfig(Group group) {
		SiteConfig config = null;
		try {
			config = siteConfigPersistence.findByGroupId(group.getGroupId());
		} catch (PortalException e) {
			LOGGER.info("No Record Found");
		}

		return config;
	}

	public void deleteByGroupId(long groupId) {
		SiteConfig siteConfig = null;
		try {
			siteConfig = siteConfigPersistence.findByGroupId(groupId);
			siteConfigPersistence.remove(siteConfig.getSiteConfigId());
		} catch (NoSuchSiteConfigException e) {
			e.printStackTrace();
		}
	}
}