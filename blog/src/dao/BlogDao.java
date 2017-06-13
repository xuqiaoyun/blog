package dao;

import java.util.List;

import util.BaseDao;
import util.PageData;
import entity.Blog;



public class BlogDao {
		//增加
		public boolean addBlog(Blog b){
			return BaseDao.execute("insert into tbl_blog values(null,?,?)",
					b.getBname(),b.getBcontent())>0;
		}
		
		//查找所有
		@SuppressWarnings("unchecked")
		public List<Blog> queryAll(){
			return (List<Blog>)BaseDao.select("select *from tbl_blog", Blog.class);
		
		}
		
		//根据id查找用户
		public Blog qurryById(int bid){
			@SuppressWarnings("unchecked")
			List<Blog> list = (List<Blog>) BaseDao.select("select *from tbl_blog where bid=?", Blog.class, bid);
			return list.get(0);
		}
		
		//根据username查找用户
		public Blog qurryByUsername(String bname){
			@SuppressWarnings("unchecked")
			List<Blog> list = (List<Blog>) BaseDao.select("select *from tbl_blog where bname=?", Blog.class, bname);
			return list.get(0);
		}
		
		

		//修改用户
		
		public boolean update(Blog b , int bid){
			return BaseDao.execute("update tbl_blog set bname=?,bcontent where bid=?",
					b.getBname(),b.getBcontent(),bid)>0;
		}
		
		//删除用户
		/*public boolean delUser(int uid){
			return BaseDao.execute("delete from userinfo where uid = ?", uid)>0;
		}*/
		
		//批量删除
		public boolean delBlog(String bid){
			return BaseDao.execute("delete from tbl_blog where bid in" + "("+bid+")")>0;
		}
		
		
		/**
		 * 用户的分页查询
		 * 
		 * @param page
		 * @param pageSize
		 * @param user_name
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public PageData queryAllByPage(int page, int pageSize, String bname) {
			int start = (page - 1) * pageSize;
			List<Blog> data = null;

			String blogname = "";
			// 总记录数
			Integer total = 0;
			if (bname != null) {

				blogname = bname;

			}
			// 这种情况下是模糊查询
			data = (List<Blog>) BaseDao.select(
					"select * from tbl_blog where bname like '%" + blogname
							+ "%' limit " + start + "," + pageSize, Blog.class,
					null);

			// 第二个参数是当前查询对应总体数据的记录数
			// 如果是分页查询 不带模糊 应该是总记录数
			// 如果分页 带模糊查询 应该是模糊查询的 总记录数
			total = queryCount(blogname);
			System.out.println("toal :" + total);

			PageData pd = new PageData(data, total, pageSize, page);

			return pd;
		}

		/**
		 * 根据参数来查询总共有几条记录
		 * 
		 * @param user_name
		 * @return
		 */
		public Integer queryCount(String bname) {
			Long result = (Long) BaseDao.getFirst(
					"select count(*) from tbl_blog where bname like '%"
							+ bname + "%' ", null);

			// 将Long转换为Integer

			return Integer.parseInt(result + "");

		}

		/**
		 * 根据用户名模糊查询用户
		 * 
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List<Blog> queryByBname(String bname) {
			return (List<Blog>) BaseDao.select(
					"select * from tbl_blog where bname like '%" + bname
							+ "%' ", Blog.class, null);
		}
		
		
	}
		
		
		
	
