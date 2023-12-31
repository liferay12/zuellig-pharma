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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SiteConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigLocalService
 * @generated
 */
public class SiteConfigLocalServiceWrapper
	implements ServiceWrapper<SiteConfigLocalService>, SiteConfigLocalService {

	public SiteConfigLocalServiceWrapper(
		SiteConfigLocalService siteConfigLocalService) {

		_siteConfigLocalService = siteConfigLocalService;
	}

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
	@Override
	public com.zpharma.model.SiteConfig addSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return _siteConfigLocalService.addSiteConfig(siteConfig);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new site config with the primary key. Does not add the site config to the database.
	 *
	 * @param siteConfigId the primary key for the new site config
	 * @return the new site config
	 */
	@Override
	public com.zpharma.model.SiteConfig createSiteConfig(long siteConfigId) {
		return _siteConfigLocalService.createSiteConfig(siteConfigId);
	}

	@Override
	public void deleteByGroupId(long groupId) {
		_siteConfigLocalService.deleteByGroupId(groupId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.zpharma.model.SiteConfig deleteSiteConfig(long siteConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.deleteSiteConfig(siteConfigId);
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
	@Override
	public com.zpharma.model.SiteConfig deleteSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return _siteConfigLocalService.deleteSiteConfig(siteConfig);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _siteConfigLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _siteConfigLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _siteConfigLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _siteConfigLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _siteConfigLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _siteConfigLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.zpharma.model.SiteConfig fetchSiteConfig(long siteConfigId) {
		return _siteConfigLocalService.fetchSiteConfig(siteConfigId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _siteConfigLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _siteConfigLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _siteConfigLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.zpharma.model.SiteConfig getSiteConfig(
		com.liferay.portal.kernel.model.Group group) {

		return _siteConfigLocalService.getSiteConfig(group);
	}

	/**
	 * Returns the site config with the primary key.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config
	 * @throws PortalException if a site config with the primary key could not be found
	 */
	@Override
	public com.zpharma.model.SiteConfig getSiteConfig(long siteConfigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.getSiteConfig(siteConfigId);
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
	@Override
	public java.util.List<com.zpharma.model.SiteConfig> getSiteConfigs(
		int start, int end) {

		return _siteConfigLocalService.getSiteConfigs(start, end);
	}

	/**
	 * Returns the number of site configs.
	 *
	 * @return the number of site configs
	 */
	@Override
	public int getSiteConfigsCount() {
		return _siteConfigLocalService.getSiteConfigsCount();
	}

	@Override
	public com.zpharma.model.SiteConfig saveOrUpdateSiteConfiguration(
			com.zpharma.model.SiteConfig siteConfig)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _siteConfigLocalService.saveOrUpdateSiteConfiguration(
			siteConfig);
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
	@Override
	public com.zpharma.model.SiteConfig updateSiteConfig(
		com.zpharma.model.SiteConfig siteConfig) {

		return _siteConfigLocalService.updateSiteConfig(siteConfig);
	}

	@Override
	public SiteConfigLocalService getWrappedService() {
		return _siteConfigLocalService;
	}

	@Override
	public void setWrappedService(
		SiteConfigLocalService siteConfigLocalService) {

		_siteConfigLocalService = siteConfigLocalService;
	}

	private SiteConfigLocalService _siteConfigLocalService;

}