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

package com.zpharma.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SiteConfig. This utility wraps
 * <code>com.zpharma.service.impl.SiteConfigLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigLocalService
 * @generated
 */
public class SiteConfigLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.zpharma.service.impl.SiteConfigLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the site config to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteConfig the site config
	 * @return the site config that was added
	 */
	public static com.zpharma.model.SiteConfig addSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return getService().addSiteConfig(siteConfig);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new site config with the primary key. Does not add the site config to the database.
	 *
	 * @param siteConfigId the primary key for the new site config
	 * @return the new site config
	 */
	public static com.zpharma.model.SiteConfig createSiteConfig(
		long siteConfigId) {

		return getService().createSiteConfig(siteConfigId);
	}

	public static void deleteByGroupId(long groupId) {
		getService().deleteByGroupId(groupId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the site config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config that was removed
	 * @throws PortalException if a site config with the primary key could not be found
	 */
	public static com.zpharma.model.SiteConfig deleteSiteConfig(
			long siteConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSiteConfig(siteConfigId);
	}

	/**
	 * Deletes the site config from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteConfig the site config
	 * @return the site config that was removed
	 */
	public static com.zpharma.model.SiteConfig deleteSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return getService().deleteSiteConfig(siteConfig);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.zpharma.model.impl.SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.zpharma.model.impl.SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.zpharma.model.SiteConfig fetchSiteConfig(
		long siteConfigId) {

		return getService().fetchSiteConfig(siteConfigId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.zpharma.model.SiteConfig getSiteConfig(
		com.liferay.portal.kernel.model.Group group) {

		return getService().getSiteConfig(group);
	}

	/**
	 * Returns the site config with the primary key.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config
	 * @throws PortalException if a site config with the primary key could not be found
	 */
	public static com.zpharma.model.SiteConfig getSiteConfig(long siteConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSiteConfig(siteConfigId);
	}

	/**
	 * Returns a range of all the site configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.zpharma.model.impl.SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site configs
	 * @param end the upper bound of the range of site configs (not inclusive)
	 * @return the range of site configs
	 */
	public static java.util.List<com.zpharma.model.SiteConfig> getSiteConfigs(
		int start, int end) {

		return getService().getSiteConfigs(start, end);
	}

	/**
	 * Returns the number of site configs.
	 *
	 * @return the number of site configs
	 */
	public static int getSiteConfigsCount() {
		return getService().getSiteConfigsCount();
	}

	public static com.zpharma.model.SiteConfig saveOrUpdateSiteConfiguration(
			com.zpharma.model.SiteConfig siteConfig)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveOrUpdateSiteConfiguration(siteConfig);
	}

	/**
	 * Updates the site config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SiteConfigLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param siteConfig the site config
	 * @return the site config that was updated
	 */
	public static com.zpharma.model.SiteConfig updateSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return getService().updateSiteConfig(siteConfig);
	}

	public static SiteConfigLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SiteConfigLocalService, SiteConfigLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SiteConfigLocalService.class);

		ServiceTracker<SiteConfigLocalService, SiteConfigLocalService>
			serviceTracker =
				new ServiceTracker
					<SiteConfigLocalService, SiteConfigLocalService>(
						bundle.getBundleContext(), SiteConfigLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}