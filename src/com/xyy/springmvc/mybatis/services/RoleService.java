package com.xyy.springmvc.mybatis.services;

import java.util.List;

import com.xyy.springmvc.mybatis.beans.RoleInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.beans.UserRole;
 


public interface RoleService {

	/**
	* @Title: userRoleConfig 
	* @Description: 配置用户角色
	* @param @param userId
	* @param @param roleid    参数 
	* @return void    返回类型 
	* @throws
	 */
	public void doUserRoleConfig(long userId, List<Long> roleid) ;
	
	 /**
     * 
     * 根据角色ID取得权限树
     * 〈功能详细描述〉
     * @param roleId
     * @return String
     * 如果有违例，请使用@exception/throws [违例类型]   [违例说明：异常的注释必须说明该异常的含义及什么条件下抛出该 
     * @see          [类、类#方法、类#成员]
     */
    public String roleToRightTree(long roleId, long type);
    
	/**
	* @Title: userRoleConfig 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userId
	* @param @param roleid    参数 
	* @return void    返回类型 
	* @throws
	 */
	public void doRoleRightConfig(long roleId, List<Long> ids);
	
	/**
	    * @Title: findRolesByName 
	    * @Description: 根据名字查找角色
	    * @param @param role
	    * @param @return    参数 
	    * @return List<RoleInfo>    返回类型 
	    * @throws
	     */
	    public List<RoleInfo> findRolesByName(RoleInfo role);
	    
	    /**
	     * 根据角色名获取角色信息
	     * 
	     * @param parentId
	     * @return
	     */
	    public List<RoleInfo> findRolesByZHName(RoleInfo role) ;
	    
	    /**
	     * @Title: delRole 
	     * @Description: 删除角色
	     * @param @param roleId    参数 
	     * @return void    返回类型 
	     * @throws
	      */
	     public void delRole(Long roleId);

	     /**
	     * @Title: addRole 
	     * @Description: 新增角色
	     * @param @param roleInfo    参数 
	     * @return void    返回类型 
	     * @throws
	      */
		public void addRole(RoleInfo roleInfo);
		
		 /**
	     * 根据权限ID获取角色信息
	     * 
	     * @param parentId
	     * @return
	     */
	    public List<RoleInfo> selectRightRole(long rid, long type);

	    /**
	    * @Title: doRightRoleConfig 
	    * @Description: 将权限分配给角色
	    * @param @param rightId
	    * @param @param ids    参数 
	    * @return void    返回类型 
	    * @throws
	     */
		public void doRightRoleConfig(long rightId, List<Long> ids);
		
		/**
		 * 返回所有角色
		 */
		public List<RoleInfo> findAllRole();
		public List<RoleInfo> findAllRole(RoleInfo roleinfo);
		
		/**
		 * 
		* @Title: findRoleById 
		* @Description: 根据roleId返回RoleInfo
		* @return    参数 
		* RoleInfo  返回类型 
		* @throws
		 */
		public RoleInfo findRoleById(long roleId);
		
		/**
		 * 修改角色信息
		 */
		public void  updateRole(RoleInfo roleinfo);
		
		/**
		 * 
		* @Title: changeRoleState 
		* @Description: 改变角色状态（可用/停用）
		* @param roleinfo    参数 
		* void  返回类型 
		* @throws
		 */
		public void  changeRoleState(RoleInfo roleinfo);
		
		/**
		 * 
		* @Title: chooseRightTree 
		* @Description: 返回权限树，根据参数roleid,对应的权限打钩
		* @param superId
		* @param sb
		* @param type
		* @param roleid    参数 
		* void  返回类型 
		* @throws
		 */
		public void  chooseRightTree(long superId, StringBuffer sb, long type,long roleid);
		
		/**
		 * 
		* @Title: changeRoleRight 
		* @Description: 传入单一角色的id以及所有权限关系，传入的角色权限关系代替该角色原来的权限关系
		* @param roleRight    参数 
		* void  返回类型 
		* @throws
		 */
		public void  changeRoleRight(List<RoleRight> roleRight,long roleId);
		/**
		 * 
		* @Title: delRoleRightByRId 
		* @Description: 删除角色的所有权限
		* @param roleId    参数 
		* void  返回类型 
		* @throws
		 */
		public void delRoleRightByRId(long roleId);
		/**
		 * 
		* @Title: roleTree 
		* @Description: 拼接角色树
		* @param sb
		* @param parentId    参数 
		* void  返回类型 
		* @throws
		 */
		public void roleTree(StringBuffer sb,long parentId);
		/**
		 * 
		 * @Title: roleTreeToUser 
		 * @Description: 拼接角色树,已经分配的用户的角色选中（打勾）
		 * @param sb
		 * @param parentId
		 * @param userId    参数 
		 * void  返回类型 
		 * @throws
		 */
		public void roleTreeToUser(StringBuffer sb,long parentId,long userId);
		/**
		 * 用新的用户角色关系替代旧的，成功返回true，传入不同用户的关系返回flase
		 */
		public boolean replaceUserRole(List<UserRole> uRolList,long userId);
}
