package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.PhotoDao;
import cn.com.xn.model.Photo;
import cn.com.xn.util.PageBean;

public class PhotoService {
	private PhotoDao photoDao;
	public PhotoService(){
		photoDao=new PhotoDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addPhoto(Photo photo){
		photoDao.addPhoto(photo);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deletePhoto(Photo photo){
		if(photo!=null&&photo.getId()!=0){
			photoDao.deletePhoto(photo.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updatePhoto(Photo photo){
		photoDao.updatePhoto(photo);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Photo>
	 * 
	 */
	public List<Photo> listPhoto(Photo photo){
		String hql="from Photo b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(photo!=null){
			 objs=new Object[]{photo.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return photoDao.listPhoto(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Photo photo){
		String hql="from Photo b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(photo!=null){
			objs=new Object[]{photo.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return photoDao.pageBean(pageBean, hql, objs);
	}

}
