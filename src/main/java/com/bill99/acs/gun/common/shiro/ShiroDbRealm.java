package com.bill99.acs.gun.common.shiro;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bill99.acs.gun.entity.User;
import com.bill99.acs.gun.entity.vo.UserVo;
import com.bill99.acs.gun.service.IRoleService;
import com.bill99.acs.gun.service.IUserService;

/**
 * 
* @ClassName: ShiroDbRealm
* @Description: (shiro权限认证)
* @author junlin.hua
* @date 2017年9月6日 下午4:59:32
*
 */
public class ShiroDbRealm extends AuthorizingRealm {

   @Autowired 
   private IUserService userService;
   @Autowired
   private IRoleService roleService;
    
    public ShiroDbRealm(CacheManager cacheManager) {
        super(cacheManager);
    }
    
    /**
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- 
     * shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserVo uservo = new UserVo();
        uservo.setUsername(token.getUsername());
        List<User> list = userService.selectByLoginName(uservo);
        // 账号不存在
        if (list == null || list.isEmpty()) {
            return null;
        }
        User user = list.get(0);
        // 账号未启用
        if (user.getStatus() == "1") {
            return null;
        }
        // 读取用户的url和角色
        //Map<String, Set<String>> resourceMap = roleService.selectResourceMapByUserId(user.getId());
       /* Set<String> urls = resourceMap.get("urls");
        Set<String> roles = resourceMap.get("roles");*/
        Set<String> urls = new TreeSet<String>();
        ShiroUser shiroUser = new ShiroUser(user.getId(), user.getUsername(), user.getRealName(), urls);
        //shiroUser.setRoles(roles);
        ByteSource credentialsSalt = new Md5Hash("test");
        // 认证缓存信息
        return new SimpleAuthenticationInfo(shiroUser, user.getPassword().toCharArray(), credentialsSalt, getName());
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        
        return info;

    }
}
