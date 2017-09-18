package com.bill99.acs.gun.common.shiro;

import javax.naming.AuthenticationNotSupportedException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.ldap.UnsupportedAuthenticationMechanismException;
import org.apache.shiro.realm.ldap.DefaultLdapRealm;
import org.apache.shiro.realm.ldap.LdapContextFactory;
import org.apache.shiro.realm.ldap.LdapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * 基于Ldap进行身份认证,二次绑定方式.
 * 
 */
public class LdapAuthenticator extends DefaultLdapRealm  {

	private static final Logger log = LoggerFactory.getLogger(LdapAuthenticator.class);
	private String rootDN;

	public LdapAuthenticator() {
		super();
	}

	public String getRootDN() {
		return rootDN;
	}

	public void setRootDN(String rootDN) {
		this.rootDN = rootDN;
	}

	@Override
	/***
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo info;
		try {
			info = queryForAuthenticationInfo(token, getContextFactory());
		} catch (AuthenticationNotSupportedException e) {
			String msg = "Unsupported configured authentication mechanism";
			throw new UnsupportedAuthenticationMechanismException(msg, e);
		} catch (javax.naming.AuthenticationException e) {
			String msg = "LDAP authentication failed.";
			throw new AuthenticationException(msg, e);
		} catch (NamingException e) {
			String msg = "LDAP naming error while attempting to authenticate user.";
			throw new AuthenticationException(msg, e);
		} catch (UnknownAccountException e) {
			String msg = "UnknownAccountException";
			throw new UnknownAccountException(msg, e);
		} catch (IncorrectCredentialsException e) {
			String msg = "IncorrectCredentialsException";
			throw new IncorrectCredentialsException(msg, e);
		}

		return info;
	}

	@Override
	protected AuthenticationInfo queryForAuthenticationInfo(AuthenticationToken token,
			LdapContextFactory ldapContextFactory) throws NamingException {

		Object principal = token.getPrincipal();
		Object credentials = token.getCredentials();

		LdapContext systemCtx = null;
		LdapContext ctx = null;
		try {
			systemCtx = ldapContextFactory.getSystemLdapContext();

			SearchControls constraints = new SearchControls();
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = systemCtx.search(rootDN, "cn=" + principal, constraints);
			if (results == null && !results.hasMoreElements()) {
				throw new UnknownAccountException();
			} else {
				log.info("DN=" + principal);
				try {
					ctx = ldapContextFactory.getLdapContext(principal, credentials);
				} catch (NamingException e) {
					throw new IncorrectCredentialsException();
				}
				return createAuthenticationInfo(token, principal, credentials, ctx);
			}
		} finally {
			LdapUtils.closeContext(systemCtx);
			LdapUtils.closeContext(ctx);
		}
	}
}