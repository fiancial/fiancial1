 package com.xyy.springmvc.mybatis.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyy.springmvc.mybatis.services.RoleService;
import com.xyy.springmvc.mybatis.beans.RightInfo;
import com.xyy.springmvc.mybatis.beans.RoleInfo;
import com.xyy.springmvc.mybatis.beans.RoleRight;
import com.xyy.springmvc.mybatis.beans.UserRole;
import com.xyy.springmvc.mybatis.mapper.*;

@Service("roleservice")
public class RoleServiceImpl implements RoleService{
	private static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

	@Autowired
	private RoleDao RoleDao;// 数据授权、操盘授权dao。
	
	@Autowired
	private RoleRightDao roleRightDao;// 数据授权、操盘授权dao。
	
	@Autowired
	private RightDao rightDao;// 数据授权、操盘授权dao。
	
	@Autowired
	private UserRoleDao userRoleDao;
	/**
	* @Title: userRoleConfig 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userId
	* @param @param roleid    参数 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void doUserRoleConfig(long userId, List<Long> roleids) {
		// TODO Auto-generated method stub
		RoleDao.delUserRole(userId);
		UserRole ur = new UserRole();
		List<UserRole> list = new ArrayList<UserRole>();
		for(long rid : roleids){
			ur = new UserRole();
			ur.setRoleId(rid);
			ur.setUserId(userId);
			ur.setUserType(1);
			list.add(ur);
		}
		userRoleDao.addBatchUserRole(list);
	}
	
	/**
	* @Title: userRoleConfig 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param userId
	* @param @param roleid    参数 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void doRoleRightConfig(long roleId, List<Long> ids) {
		// TODO Auto-generated method stub
		roleRightDao.delRoleRight(roleId);
		RoleRight ur = new RoleRight();
		List<RoleRight> list = new ArrayList<RoleRight>();
		for(long rid : ids){
			ur = new RoleRight();
			ur.setRoleId(roleId);
			ur.setRightId(rid);
			list.add(ur);
		}
	//	roleRightDao.addBatchRoleRight(list);
	}
	
	 /**
     * 
     * 根据角色ID取得权限树
     * 〈功能详细描述〉
     * @param roleId
     * @return String
     * 如果有违例，请使用@exception/throws [违例类型]   [违例说明：异常的注释必须说明该异常的含义及什么条件下抛出该 
     * @see          [类、类#方法、类#成员]
     */
    public String roleToRightTree(long roleId, long type)
    {
    	Map<String, Object> param = new HashMap<>();
    	param.put("roleId", roleId);
    	param.put("roleType", type);
        List<RoleRight> list = roleRightDao.findRightListByRoleId(param);
        Map<Long, Long> aMap = new HashMap<Long, Long>();
		for(RoleRight auth : list){
            if(auth != null)
            aMap.put(auth.getRightId(), auth.getRightId());
        }
        StringBuffer selectTree = new StringBuffer();
        initAuthsTree(0l,  selectTree, aMap, type);
        return selectTree.toString();
        
    }
    
   /**
   * @Title: initAuthsTree 
   * @Description: 初始化角色的权限树
   * @param @param superCode
   * @param @param selectTree
   * @param @param aMap    参数 
   * @return void    返回类型 
   * @throws
    */
    public void initAuthsTree(long superCode, StringBuffer selectTree, Map<Long, Long> aMap, long type){
        // tname="name" tvalue="页面三"
    	Map<String, Object> param = new HashMap<>();
    	param.put("rightId", superCode);
    	param.put("rightType", type);
        List<RightInfo> alist = rightDao.findAllRightByParentId(param);
        for(RightInfo auth : alist){
        	param.put("rightId", auth.getRightId());
        	 List<RightInfo> olist = rightDao.findAllRightByParentId(param);
            if(olist.size()>0){
                selectTree.append("<li>");
                if(aMap.get(auth.getRightId()) != null)
                    selectTree.append("<a checked=\"true\" tname=\"roleToAuthTree\" tvalue=\""+auth.getRightId()+"\">"+auth.getRightName()+"</a>"); 
                else
                    selectTree.append("<a tname=\"roleToAuthTree\" tvalue=\""+auth.getRightId()+"\">"+auth.getRightName()+"</a>"); 
                
                selectTree.append("<ul>");
                initAuthsTree(auth.getRightId(), selectTree, aMap, type);
                selectTree.append("</ul>");
                selectTree.append("</li>");
            } else{
                selectTree.append("<li>");
                if(aMap.get(auth.getRightId()) != null)
                    selectTree.append("<a checked=\"true\" tname=\"roleToAuthTree\" tvalue=\""+auth.getRightId()+"\">"+auth.getRightName()+"</a>"); 
                else
                    selectTree.append("<a tname=\"roleToAuthTree\" tvalue=\""+auth.getRightId()+"\">"+auth.getRightName()+"</a>"); 
                selectTree.append("</li>");
                initAuthsTree(auth.getRightId(), selectTree, aMap, type);
            }
        }
    }
    
    /**
    * @Title: findRolesByName 
    * @Description: 根据名字查找角色
    * @param @param role
    * @param @return    参数 
    * @return List<RoleInfo>    返回类型 
    * @throws
     */
    public List<RoleInfo> findRolesByName(RoleInfo role){
    	return RoleDao.findRolesByName(role);
    }
    
    /**
     * 根据角色名获取角色信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> findRolesByZHName(RoleInfo role) {
    	return RoleDao.findRolesByZHName(role);
    }
    
    /**
    * @Title: delRole 
    * @Description: 删除角色
    * @param @param roleId    参数 
    * @return void    返回类型 
    * @throws
     */
    public void delRole(Long roleId){
    	RoleDao.delRoleById(roleId);
    	roleRightDao.delRoleRight(roleId);
    	userRoleDao.delUserRoleByRId(roleId);
    }

    /**
     * 新增角色
     */
	@Override
	public void addRole(RoleInfo roleInfo) {
		roleInfo.setRoleId(RoleDao.getSqe());
		RoleDao.addRole(roleInfo);
	}
	
	 /**
     * 根据权限ID获取角色信息
     * 
     * @param parentId
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<RoleInfo> selectRightRole(long rid, long type){
    	Map<String, Object> param = new HashMap<>();
    	param.put("rightid", rid);
    	param.put("rightType", type);
    	return RoleDao.selectRightRole(param);
    }
    
    /**
	    * @Title: doRightRoleConfig 
	    * @Description: 将权限分配给角色
	    * @param @param rightId
	    * @param @param ids    参数 
	    * @return void    返回类型 
	    * @throws
	     */
		public void doRightRoleConfig(long rightId, List<Long> ids){
			roleRightDao.delRoleRightByRightId(rightId);
			List<RoleRight> rlist = new ArrayList<RoleRight>();
			RoleRight rr;
			for(long id : ids){
				rr = new RoleRight();
				rr.setRightId(rightId);
				rr.setRoleId(id);
				rlist.add(rr);
			}
//			roleRightDao.addBatchRoleRight(rlist); 
		}
		
		/**
		 * 返回所有角色
		 */
		public List<RoleInfo> findAllRole()
		{
			return RoleDao.findAllRole();			
		}
		public List<RoleInfo> findAllRole(RoleInfo roleinfo)
		{
			return RoleDao.findAllRole(roleinfo);			
		}
		
		/**
		 * 通过roleId找到角色信息
		 */
		public RoleInfo findRoleById(long roleId)
		{
			return RoleDao.findRoleById(roleId);
		}
		
		/**
		 * 修改角色信息
		 */
		public void  updateRole(RoleInfo roleinfo)
		{
			RoleDao.updateRole(roleinfo);
		}
		/**
		 * 改变角色状态（可用/停用）
		 */
		public void  changeRoleState(RoleInfo roleinfo)
		{
			if(roleinfo.getRoleState() == 1L) {
				roleinfo.setRoleState(2L);
			}else{
				roleinfo.setRoleState(1L);
			}
			RoleDao.changeRoleState(roleinfo);
		}
		
		/**
		 *  根据角色id显示权限树，若某权限与该角色有对应关系，则显示该权限已勾选。
		 */
		public void  chooseRightTree(long superId, StringBuffer sb, long type,long roleid)
		{
			int num = 0;
			Map<String,Object> para= new HashMap<>();
			para.put("roleId", roleid);
			List<RoleRight> roleright = roleRightDao.findRightListByRoleId(para);
			
			//把权限角色的对应关系存在Map a 里面
			Map<Object,Object> a = new HashMap<>();
			for(RoleRight rr : roleright)
			{
			a.put(rr.getRightId(), rr.getRoleId());
			}
			
			Map<String, Object> param = new HashMap<>();
	    	param.put("rightId", superId);
	    	param.put("rightType", type);
	        List<RightInfo> alist = rightDao.findAllRightByParentId(param);
	        for(RightInfo auth : alist){
	        	param.put("rightId", auth.getRightId());
	            List<RightInfo> olist = rightDao.findAllRightByParentId(param);
	            if(olist.size()>0){
	                sb.append("<li>");
	                //如果该权限在 a 里面，属性中加 checked="true"
	                if(a.containsKey(auth.getRightId()))	               
	                {
	                	sb.append("<a checked='true' name='RightInfo'  value="+auth.getRightId()+">"+auth.getRightName()+"</a>");
	                }
	                else
	                {
	                	sb.append("<a  name='RightInfo' value="+auth.getRightId()+">"+auth.getRightName()+"</a>");	
	                }
	                
	                sb.append("<ul>");
	                chooseRightTree(auth.getRightId(), sb, type,roleid);
	                sb.append("</ul>");
	                sb.append("</li>");
	            } else{
	                sb.append("<li>");
	                
	                if(a.containsKey(auth.getRightId()))
	                {
	                	sb.append("<a checked='true' name='RightInfo' value="+auth.getRightId()+">"+auth.getRightName()+"</a>");
	                }
	                else
	                {
	                	sb.append("<a name='RightInfo' value="+auth.getRightId()+">"+auth.getRightName()+"</a>");	
	                }
	                
	                sb.append("</li>");
	                chooseRightTree(auth.getRightId(), sb, type,roleid);
	            }
	        }
		}
		/**
		 * 赋予角色新的权限关系
		 */
		public void  changeRoleRight(List<RoleRight> roleRight,long roleId)
		{
			Map<String,Object> param = new HashMap<>();
			param.put("roleId", roleId);
			List<RoleRight> formerRoleRight = roleRightDao.findRightListByRoleId(param);
			
			List<RoleRight> wantToDelete = new ArrayList<>();
			for(RoleRight x:formerRoleRight)
			{
				if(false==roleRight.contains(x))
				{
					wantToDelete.add(x);
				}
			}
			roleRightDao.deleteBatchRoleRight(wantToDelete);
			for(RoleRight x:roleRight)
			{
				if(false==formerRoleRight.contains(x))
				{
					roleRightDao.addBatchRoleRight(x);
				}
			}			
		}
		/**
		 * 删除角色的所有权限关系
		 */
		public void delRoleRightByRId(long roleId)
		{
			roleRightDao.delRoleRightByRId(roleId);
		}
		/**
		 * 角色树
		 */
		public void roleTree(StringBuffer sb,long parentId)
		{
			
			//取得以参数parentId作为上级的角色
			 List<RoleInfo> roleList = RoleDao.findRolesByParentId(parentId);
			//遍历这些角色作为上级，取得下级；下级作为上级再次遍历（递归）直至没有下级
			//每获得一个角色，获取它的角色id，角色名称，放在a标签中
			//相同一层的角色相互之间为兄弟节点，下一层的角色为上一层的子节点
			if(false==roleList.isEmpty())
			{
				for(RoleInfo r:roleList)
				{
					sb.append("<li><a id='"+r.getRoleId()+"'>"+r.getRoleName()+"</a>");
					//如果该角色有下级（下级不为空）
					if(false==RoleDao.findRolesByParentId(r.getRoleId()).isEmpty())
					{
						sb.append("<ul>");
						roleTree(sb,r.getRoleId());
						sb.append("</ul>");
					}
					sb.append("</li>");
				}
			}else
			{
				logger.info("roleList is empty");
			}
		}
		
		
		/**
		 * 角色树,已分配给用户的角色选中
		 */
		public void roleTreeToUser(StringBuffer sb,long parentId,long userId)
		{
			
			//取得以参数parentId作为上级的角色
			 List<RoleInfo> roleList = RoleDao.findRolesByParentId(parentId);
			//遍历这些角色作为上级，取得下级；下级作为上级再次遍历（递归）直至没有下级
			//每获得一个角色，获取它的角色id，角色名称，放在a标签中
			//相同一层的角色相互之间为兄弟节点，下一层的角色为上一层的子节点
			List<UserRole> url = userRoleDao.findUserRolesByUId(userId);
			if(false==roleList.isEmpty())
			{
				for(RoleInfo r:roleList)
				{
					UserRole ur =new UserRole(userId,r.getRoleId(),1);
					//如果用户与角色有对应关系，则该角色被选中					
					if(url.contains(ur))
					{
						sb.append("<li><a checked='true' id='"+r.getRoleId()+"'>"+r.getRoleName()+"</a>");
					}else
					{
						sb.append("<li><a id='"+r.getRoleId()+"'>"+r.getRoleName()+"</a>");
					}
					//如果该角色有下级（下级不为空）
					if(false==RoleDao.findRolesByParentId(r.getRoleId()).isEmpty())
					{
						sb.append("<ul>");
						roleTreeToUser(sb,r.getRoleId(),userId);
						sb.append("</ul>");
					}
					sb.append("</li>");
				}
			}else
			{
				logger.info("roleList is empty");
			}
		}
		/**
		 * 用新的用户角色关系替代旧的，成功返回true，传入不同用户的关系返回flase
		 */
		public boolean replaceUserRole(List<UserRole> uRolList,long userId)
		{
			//判断是否是单一的用户id，若不是，返回false
			if(!uRolList.isEmpty())
			{
				for(UserRole ur:uRolList)
				{
					if(userId!=ur.getUserId())
					{
						return false;
					}
				}
			}
			//取得旧的用户角色关系
			List<UserRole> former = userRoleDao.findUserRolesByUId(userId);
			//删除
			for(UserRole ur:former)
			{
				if(!uRolList.contains(ur))
				{
					userRoleDao.delUserRole(ur);
				}
			}
			//添加
			for(UserRole ur:uRolList)
			{
				if(!former.contains(ur))
				{
					userRoleDao.addUserRole(ur);
				}
			}
			return true;
		}
 

	 

	 
}
