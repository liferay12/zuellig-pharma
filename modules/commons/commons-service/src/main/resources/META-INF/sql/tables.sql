create table ZUELLIG_SiteConfig (
	siteConfigId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	showCustomUserRegistration BOOLEAN,
	siteEmailAddress VARCHAR(75) null,
	sitePhoneNumber LONG,
	openinghours VARCHAR(75) null,
	copyright VARCHAR(75) null
);