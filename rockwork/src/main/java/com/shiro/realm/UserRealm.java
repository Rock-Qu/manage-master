package com.shiro.realm;

import com.biqi.constant.BaseConstant;
import com.biqi.dao.*;
import com.biqi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Slf4j
public class UserRealm extends AuthorizingRealm {

     @Autowired
     private PermissionDao permissionDao;
     @Autowired
     private RoleDao roleDao;
     @Autowired
     private RoleToPermissionDao roleToPermissionDao;
     @Autowired
     private UserDao userDao;
     @Autowired
     private UserToRoleDao userToRoleDao;



    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        User userInfo  = (User)principals.getPrimaryPrincipal();
        UserToRole userToRole = new UserToRole();
        userToRole.setUserId(userInfo.getId());
        List<UserToRole> roleList = userToRoleDao.select(userToRole);

        List<Role> roles = new ArrayList<>(roleList.size());

        roleList.forEach(item->{
            roles.add(roleDao.selectByPrimaryKey(item.getRoleId()));
        });

        roles.forEach(item->{
            authorizationInfo.addRole(item.getRoleName());
            RoleToPermission roleToPermission = new RoleToPermission();
            roleToPermission.setStatus(BaseConstant.STATUS.YES);
            roleToPermission.setRoleId(item.getId());
            List<RoleToPermission> select = roleToPermissionDao.select(roleToPermission);
            for (RoleToPermission itemRoleToPermission : select) {
                Permission permission = permissionDao.selectByPrimaryKey(itemRoleToPermission.getPermissionId());
                authorizationInfo.addStringPermission(permission.getPermission());
            }
        });
        System.out.println(authorizationInfo.toString());
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");

        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());

        User user = new User();
        user.setName(username);
        User userInfo = userDao.selectOne(user);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,
                userInfo.getPassword(),
                ByteSource.Util.bytes("123"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
