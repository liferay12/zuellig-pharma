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

package com.zpharma.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.zpharma.model.SiteConfig;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the site config service. This utility wraps <code>com.zpharma.service.persistence.impl.SiteConfigPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigPersistence
 * @generated
 */
public class SiteConfigUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SiteConfig siteConfig) {
		getPersistence().clearCache(siteConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, SiteConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SiteConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SiteConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SiteConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SiteConfig> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SiteConfig update(SiteConfig siteConfig) {
		return getPersistence().update(siteConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SiteConfig update(
		SiteConfig siteConfig, ServiceContext serviceContext) {

		return getPersistence().update(siteConfig, serviceContext);
	}

	/**
	 * Returns the site config where groupId = &#63; or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching site config
	 * @throws NoSuchSiteConfigException if a matching site config could not be found
	 */
	public static SiteConfig findByGroupId(long groupId)
		throws com.zpharma.exception.NoSuchSiteConfigException {

		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	public static SiteConfig fetchByGroupId(long groupId) {
		return getPersistence().fetchByGroupId(groupId);
	}

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	public static SiteConfig fetchByGroupId(
		long groupId, boolean useFinderCache) {

		return getPersistence().fetchByGroupId(groupId, useFinderCache);
	}

	/**
	 * Removes the site config where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the site config that was removed
	 */
	public static SiteConfig removeByGroupId(long groupId)
		throws com.zpharma.exception.NoSuchSiteConfigException {

		return getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of site configs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching site configs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the site config in the entity cache if it is enabled.
	 *
	 * @param siteConfig the site config
	 */
	public static void cacheResult(SiteConfig siteConfig) {
		getPersistence().cacheResult(siteConfig);
	}

	/**
	 * Caches the site configs in the entity cache if it is enabled.
	 *
	 * @param siteConfigs the site configs
	 */
	public static void cacheResult(List<SiteConfig> siteConfigs) {
		getPersistence().cacheResult(siteConfigs);
	}

	/**
	 * Creates a new site config with the primary key. Does not add the site config to the database.
	 *
	 * @param siteConfigId the primary key for the new site config
	 * @return the new site config
	 */
	public static SiteConfig create(long siteConfigId) {
		return getPersistence().create(siteConfigId);
	}

	/**
	 * Removes the site config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config that was removed
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	public static SiteConfig remove(long siteConfigId)
		throws com.zpharma.exception.NoSuchSiteConfigException {

		return getPersistence().remove(siteConfigId);
	}

	public static SiteConfig updateImpl(SiteConfig siteConfig) {
		return getPersistence().updateImpl(siteConfig);
	}

	/**
	 * Returns the site config with the primary key or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	public static SiteConfig findByPrimaryKey(long siteConfigId)
		throws com.zpharma.exception.NoSuchSiteConfigException {

		return getPersistence().findByPrimaryKey(siteConfigId);
	}

	/**
	 * Returns the site config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config, or <code>null</code> if a site config with the primary key could not be found
	 */
	public static SiteConfig fetchByPrimaryKey(long siteConfigId) {
		return getPersistence().fetchByPrimaryKey(siteConfigId);
	}

	/**
	 * Returns all the site configs.
	 *
	 * @return the site configs
	 */
	public static List<SiteConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the site configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site configs
	 * @param end the upper bound of the range of site configs (not inclusive)
	 * @return the range of site configs
	 */
	public static List<SiteConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the site configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site configs
	 * @param end the upper bound of the range of site configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of site configs
	 */
	public static List<SiteConfig> findAll(
		int start, int end, OrderByComparator<SiteConfig> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the site configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site configs
	 * @param end the upper bound of the range of site configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of site configs
	 */
	public static List<SiteConfig> findAll(
		int start, int end, OrderByComparator<SiteConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the site configs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of site configs.
	 *
	 * @return the number of site configs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SiteConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SiteConfigPersistence, SiteConfigPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SiteConfigPersistence.class);

		ServiceTracker<SiteConfigPersistence, SiteConfigPersistence>
			serviceTracker =
				new ServiceTracker
					<SiteConfigPersistence, SiteConfigPersistence>(
						bundle.getBundleContext(), SiteConfigPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}