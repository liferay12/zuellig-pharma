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

package com.zpharma.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.zpharma.exception.NoSuchSiteConfigException;
import com.zpharma.model.SiteConfig;
import com.zpharma.model.impl.SiteConfigImpl;
import com.zpharma.model.impl.SiteConfigModelImpl;
import com.zpharma.service.persistence.SiteConfigPersistence;
import com.zpharma.service.persistence.impl.constants.ZUELLIGPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the site config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SiteConfigPersistence.class)
public class SiteConfigPersistenceImpl
	extends BasePersistenceImpl<SiteConfig> implements SiteConfigPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SiteConfigUtil</code> to access the site config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SiteConfigImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns the site config where groupId = &#63; or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @return the matching site config
	 * @throws NoSuchSiteConfigException if a matching site config could not be found
	 */
	@Override
	public SiteConfig findByGroupId(long groupId)
		throws NoSuchSiteConfigException {

		SiteConfig siteConfig = fetchByGroupId(groupId);

		if (siteConfig == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSiteConfigException(sb.toString());
		}

		return siteConfig;
	}

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	@Override
	public SiteConfig fetchByGroupId(long groupId) {
		return fetchByGroupId(groupId, true);
	}

	/**
	 * Returns the site config where groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site config, or <code>null</code> if a matching site config could not be found
	 */
	@Override
	public SiteConfig fetchByGroupId(long groupId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupId, finderArgs, this);
		}

		if (result instanceof SiteConfig) {
			SiteConfig siteConfig = (SiteConfig)result;

			if (groupId != siteConfig.getGroupId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SITECONFIG_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				List<SiteConfig> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {groupId};
							}

							_log.warn(
								"SiteConfigPersistenceImpl.fetchByGroupId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SiteConfig siteConfig = list.get(0);

					result = siteConfig;

					cacheResult(siteConfig);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SiteConfig)result;
		}
	}

	/**
	 * Removes the site config where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @return the site config that was removed
	 */
	@Override
	public SiteConfig removeByGroupId(long groupId)
		throws NoSuchSiteConfigException {

		SiteConfig siteConfig = findByGroupId(groupId);

		return remove(siteConfig);
	}

	/**
	 * Returns the number of site configs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching site configs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SITECONFIG_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"siteConfig.groupId = ?";

	public SiteConfigPersistenceImpl() {
		setModelClass(SiteConfig.class);

		setModelImplClass(SiteConfigImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the site config in the entity cache if it is enabled.
	 *
	 * @param siteConfig the site config
	 */
	@Override
	public void cacheResult(SiteConfig siteConfig) {
		entityCache.putResult(
			SiteConfigImpl.class, siteConfig.getPrimaryKey(), siteConfig);

		finderCache.putResult(
			_finderPathFetchByGroupId, new Object[] {siteConfig.getGroupId()},
			siteConfig);

		siteConfig.resetOriginalValues();
	}

	/**
	 * Caches the site configs in the entity cache if it is enabled.
	 *
	 * @param siteConfigs the site configs
	 */
	@Override
	public void cacheResult(List<SiteConfig> siteConfigs) {
		for (SiteConfig siteConfig : siteConfigs) {
			if (entityCache.getResult(
					SiteConfigImpl.class, siteConfig.getPrimaryKey()) == null) {

				cacheResult(siteConfig);
			}
			else {
				siteConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all site configs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SiteConfigImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the site config.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SiteConfig siteConfig) {
		entityCache.removeResult(
			SiteConfigImpl.class, siteConfig.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SiteConfigModelImpl)siteConfig, true);
	}

	@Override
	public void clearCache(List<SiteConfig> siteConfigs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SiteConfig siteConfig : siteConfigs) {
			entityCache.removeResult(
				SiteConfigImpl.class, siteConfig.getPrimaryKey());

			clearUniqueFindersCache((SiteConfigModelImpl)siteConfig, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SiteConfigImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SiteConfigModelImpl siteConfigModelImpl) {

		Object[] args = new Object[] {siteConfigModelImpl.getGroupId()};

		finderCache.putResult(
			_finderPathCountByGroupId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByGroupId, args, siteConfigModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SiteConfigModelImpl siteConfigModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {siteConfigModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(_finderPathFetchByGroupId, args);
		}

		if ((siteConfigModelImpl.getColumnBitmask() &
			 _finderPathFetchByGroupId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				siteConfigModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(_finderPathFetchByGroupId, args);
		}
	}

	/**
	 * Creates a new site config with the primary key. Does not add the site config to the database.
	 *
	 * @param siteConfigId the primary key for the new site config
	 * @return the new site config
	 */
	@Override
	public SiteConfig create(long siteConfigId) {
		SiteConfig siteConfig = new SiteConfigImpl();

		siteConfig.setNew(true);
		siteConfig.setPrimaryKey(siteConfigId);

		siteConfig.setCompanyId(CompanyThreadLocal.getCompanyId());

		return siteConfig;
	}

	/**
	 * Removes the site config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config that was removed
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	@Override
	public SiteConfig remove(long siteConfigId)
		throws NoSuchSiteConfigException {

		return remove((Serializable)siteConfigId);
	}

	/**
	 * Removes the site config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site config
	 * @return the site config that was removed
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	@Override
	public SiteConfig remove(Serializable primaryKey)
		throws NoSuchSiteConfigException {

		Session session = null;

		try {
			session = openSession();

			SiteConfig siteConfig = (SiteConfig)session.get(
				SiteConfigImpl.class, primaryKey);

			if (siteConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSiteConfigException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(siteConfig);
		}
		catch (NoSuchSiteConfigException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SiteConfig removeImpl(SiteConfig siteConfig) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(siteConfig)) {
				siteConfig = (SiteConfig)session.get(
					SiteConfigImpl.class, siteConfig.getPrimaryKeyObj());
			}

			if (siteConfig != null) {
				session.delete(siteConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (siteConfig != null) {
			clearCache(siteConfig);
		}

		return siteConfig;
	}

	@Override
	public SiteConfig updateImpl(SiteConfig siteConfig) {
		boolean isNew = siteConfig.isNew();

		if (!(siteConfig instanceof SiteConfigModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(siteConfig.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(siteConfig);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in siteConfig proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SiteConfig implementation " +
					siteConfig.getClass());
		}

		SiteConfigModelImpl siteConfigModelImpl =
			(SiteConfigModelImpl)siteConfig;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (siteConfig.getCreateDate() == null)) {
			if (serviceContext == null) {
				siteConfig.setCreateDate(now);
			}
			else {
				siteConfig.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!siteConfigModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				siteConfig.setModifiedDate(now);
			}
			else {
				siteConfig.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (siteConfig.isNew()) {
				session.save(siteConfig);

				siteConfig.setNew(false);
			}
			else {
				siteConfig = (SiteConfig)session.merge(siteConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			SiteConfigImpl.class, siteConfig.getPrimaryKey(), siteConfig,
			false);

		clearUniqueFindersCache(siteConfigModelImpl, false);
		cacheUniqueFindersCache(siteConfigModelImpl);

		siteConfig.resetOriginalValues();

		return siteConfig;
	}

	/**
	 * Returns the site config with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site config
	 * @return the site config
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	@Override
	public SiteConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSiteConfigException {

		SiteConfig siteConfig = fetchByPrimaryKey(primaryKey);

		if (siteConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSiteConfigException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return siteConfig;
	}

	/**
	 * Returns the site config with the primary key or throws a <code>NoSuchSiteConfigException</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config
	 * @throws NoSuchSiteConfigException if a site config with the primary key could not be found
	 */
	@Override
	public SiteConfig findByPrimaryKey(long siteConfigId)
		throws NoSuchSiteConfigException {

		return findByPrimaryKey((Serializable)siteConfigId);
	}

	/**
	 * Returns the site config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteConfigId the primary key of the site config
	 * @return the site config, or <code>null</code> if a site config with the primary key could not be found
	 */
	@Override
	public SiteConfig fetchByPrimaryKey(long siteConfigId) {
		return fetchByPrimaryKey((Serializable)siteConfigId);
	}

	/**
	 * Returns all the site configs.
	 *
	 * @return the site configs
	 */
	@Override
	public List<SiteConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SiteConfig> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SiteConfig> findAll(
		int start, int end, OrderByComparator<SiteConfig> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SiteConfig> findAll(
		int start, int end, OrderByComparator<SiteConfig> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<SiteConfig> list = null;

		if (useFinderCache) {
			list = (List<SiteConfig>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SITECONFIG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SITECONFIG;

				sql = sql.concat(SiteConfigModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SiteConfig>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the site configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SiteConfig siteConfig : findAll()) {
			remove(siteConfig);
		}
	}

	/**
	 * Returns the number of site configs.
	 *
	 * @return the number of site configs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SITECONFIG);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "siteConfigId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SITECONFIG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SiteConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the site config persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			SiteConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			SiteConfigImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByGroupId = new FinderPath(
			SiteConfigImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByGroupId",
			new String[] {Long.class.getName()},
			SiteConfigModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SiteConfigImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ZUELLIGPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ZUELLIGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ZUELLIGPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SITECONFIG =
		"SELECT siteConfig FROM SiteConfig siteConfig";

	private static final String _SQL_SELECT_SITECONFIG_WHERE =
		"SELECT siteConfig FROM SiteConfig siteConfig WHERE ";

	private static final String _SQL_COUNT_SITECONFIG =
		"SELECT COUNT(siteConfig) FROM SiteConfig siteConfig";

	private static final String _SQL_COUNT_SITECONFIG_WHERE =
		"SELECT COUNT(siteConfig) FROM SiteConfig siteConfig WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "siteConfig.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SiteConfig exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SiteConfig exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SiteConfigPersistenceImpl.class);

	static {
		try {
			Class.forName(ZUELLIGPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}