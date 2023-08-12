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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.zpharma.exception.NoSuchSiteConfigException;
import com.zpharma.model.SiteConfig;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the site config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigUtil
 * @generated
 */
@ProviderType
public interface SiteConfigPersistence extends BasePersistence<SiteConfig> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SiteConfigUtil} to access the site config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the site config where groupId = &#63; or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching site config
	 * @throws NoSuchSiteConfigException if a matching site config could not be found
	 */
	public SiteConfig findByGroupId(long groupId)
		throws NoSuchSiteConfigException;

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	public SiteConfig fetchByGroupId(long groupId);

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	public SiteConfig fetchByGroupId(long groupId, boolean useFinderCache);

	/**
	 * Removes the site config where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the site config that was removed
	 */
	public SiteConfig removeByGroupId(long groupId)
		throws NoSuchSiteConfigException;

	/**
	 * Returns the number of site configs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching site configs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the site config in the entity cache if it is enabled.
	 *
	 * @param siteConfig the site config
	 */
	public void cacheResult(SiteConfig siteConfig);

	/**
	 * Caches the site configs in the entity cache if it is enabled.
	 *
	 * @param siteConfigs the site configs
	 */
	public void cacheResult(java.util.List<SiteConfig> siteConfigs);

	/**
	 * Creates a new site config with the primary key. Does not add the site config to the database.
	 *
	 * @param siteConfigId the primary key for the new site config
	 * @return the new site config
	 */
	public SiteConfig create(long siteConfigId);

	/**
	 * Removes the site config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config that was removed
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	public SiteConfig remove(long siteConfigId)
		throws NoSuchSiteConfigException;

	public SiteConfig updateImpl(SiteConfig siteConfig);

	/**
	 * Returns the site config with the primary key or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	public SiteConfig findByPrimaryKey(long siteConfigId)
		throws NoSuchSiteConfigException;

	/**
	 * Returns the site config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config, or <code>null</code> if a site config with the primary key could not be found
	 */
	public SiteConfig fetchByPrimaryKey(long siteConfigId);

	/**
	 * Returns all the site configs.
	 *
	 * @return the site configs
	 */
	public java.util.List<SiteConfig> findAll();

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
	public java.util.List<SiteConfig> findAll(int start, int end);

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
	public java.util.List<SiteConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteConfig>
			orderByComparator);

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
	public java.util.List<SiteConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SiteConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the site configs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of site configs.
	 *
	 * @return the number of site configs
	 */
	public int countAll();

}