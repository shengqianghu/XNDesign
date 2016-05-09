package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.SizeDao;
import cn.com.xn.model.Size;
import cn.com.xn.util.PageBean;

public class SizeService {
	private SizeDao sizeDao;
	public SizeService(){
		sizeDao=new SizeDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addSize(Size size){
		sizeDao.addSize(size);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteSize(Size size){
		if(size!=null&&size.getId()!=0){
			sizeDao.deleteSize(size.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateSize(Size size){
		sizeDao.updateSize(size);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Size>
	 * 
	 */
	public List<Size> listSize(Size size){
		String hql="from Size b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(size!=null){
			 objs=new Object[]{size.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return sizeDao.listSize(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Size size){
		String hql="from Size b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(size!=null){
			objs=new Object[]{size.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return sizeDao.pageBean(pageBean, hql, objs);
	}

}
