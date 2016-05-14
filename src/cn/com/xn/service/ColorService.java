package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.ColorDao;
import cn.com.xn.model.Color;
import cn.com.xn.util.PageBean;

public class ColorService {
	private ColorDao colorDao;
	public ColorService(){
		colorDao=new ColorDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addColor(Color color){
		colorDao.addColor(color);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteColor(Color color){
		if(color!=null&&color.getId()!=0){
			colorDao.deleteColor(color.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateColor(Color color){
		colorDao.updateColor(color);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Color>
	 * 
	 */
	public List<Color> listColor(Color color){
		String hql="from Color b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(color!=null){
			 objs=new Object[]{color.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return colorDao.listColor(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Color color){
		String hql="from Color b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(color!=null){
			objs=new Object[]{color.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return colorDao.pageBean(pageBean, hql, objs);
	}

}
