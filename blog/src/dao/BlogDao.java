package dao;

import java.util.List;

import util.BaseDao;
import util.PageData;
import entity.Blog;

public class BlogDao {
	// ����
	public boolean addBlog(Blog b) {
		return BaseDao.execute("insert into tbl_blog values(null,?,?)",
				b.getBname(), b.getBcontent()) > 0;
	}

	// qqqqqq
	public boolean addBlogByPage(Blog b) {
		return BaseDao.execute("insert into tbl_blog values(null,?,?)",
				b.getBname(), b.getBcontent()) > 0;
	}

	// qqqqqq2222222
	public boolean addBlogByPage2(Blog b) {
		return BaseDao.execute("insert into tbl_blog values(null,?,?)",
				b.getBname(), b.getBcontent()) > 0;
	}

	// ��������
	@SuppressWarnings("unchecked")
	public List<Blog> queryAll() {
		return (List<Blog>) BaseDao.select("select *from tbl_blog", Blog.class);

	}

	// ����id�����û�
	public Blog qurryById(int bid) {
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) BaseDao.select(
				"select *from tbl_blog where bid=?", Blog.class, bid);
		return list.get(0);
	}

	// ����username�����û�
	public Blog qurryByUsername(String bname) {
		@SuppressWarnings("unchecked")
		List<Blog> list = (List<Blog>) BaseDao.select(
				"select *from tbl_blog where bname=?", Blog.class, bname);
		return list.get(0);
	}

	// �޸��û�

	public boolean update(Blog b, int bid) {
		return BaseDao.execute(
				"update tbl_blog set bname=?,bcontent where bid=?",
				b.getBname(), b.getBcontent(), bid) > 0;
	}

	// ɾ���û�
	/*
	 * public boolean delUser(int uid){ return
	 * BaseDao.execute("delete from userinfo where uid = ?", uid)>0; }
	 */

	// ����ɾ��
	public boolean delBlog(String bid) {
		return BaseDao.execute("delete from tbl_blog where bid in" + "(" + bid
				+ ")") > 0;
	}

	/**
	 * �û��ķ�ҳ��ѯ
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
		// �ܼ�¼��
		Integer total = 0;
		if (bname != null) {

			blogname = bname;

		}
		// �����������ģ����ѯ
		data = (List<Blog>) BaseDao.select(
				"select * from tbl_blog where bname like '%" + blogname
						+ "%' limit " + start + "," + pageSize, Blog.class,
				null);

		// �ڶ��������ǵ�ǰ��ѯ��Ӧ�������ݵļ�¼��
		// ����Ƿ�ҳ��ѯ ����ģ�� Ӧ�����ܼ�¼��
		// �����ҳ ��ģ����ѯ Ӧ����ģ����ѯ�� �ܼ�¼��
		total = queryCount(blogname);
		System.out.println("toal :" + total);

		PageData pd = new PageData(data, total, pageSize, page);

		return pd;
	}

	/**
	 * ���ݲ�������ѯ�ܹ��м�����¼
	 * 
	 * @param user_name
	 * @return
	 */
	public Integer queryCount(String bname) {
		Long result = (Long) BaseDao.getFirst(
				"select count(*) from tbl_blog where bname like '%" + bname
						+ "%' ", null);

		// ��Longת��ΪInteger

		return Integer.parseInt(result + "");

	}

	/**
	 * �����û���ģ����ѯ�û�
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Blog> queryByBname(String bname) {
		return (List<Blog>) BaseDao.select(
				"select * from tbl_blog where bname like '%" + bname + "%' ",
				Blog.class, null);
	}

}
