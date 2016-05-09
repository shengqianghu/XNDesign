package cn.com.xn.service;

import java.util.List;

import cn.com.xn.dao.RecordDao;
import cn.com.xn.model.Record;
import cn.com.xn.util.PageBean;

public class RecordService {
	private RecordDao recordDao;
	public RecordService(){
		recordDao=new RecordDao();
	}
	/**
	 * 添加
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void  addRecord(Record record){
		recordDao.addRecord(record);
	}
	/**
	 * 删除
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void deleteRecord(Record record){
		if(record!=null&&record.getId()!=0){
			recordDao.deleteRecord(record.getId());
		}
	}
	
	/**
	 * 修改
	 * 时间：2016-5-9
	 * @param $
	 * @return  void
	 * 
	 */
	public void updateRecord(Record record){
		recordDao.updateRecord(record);
	}
	/**
	 * 以List的方式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  List<Record>
	 * 
	 */
	public List<Record> listRecord(Record record){
		String hql="from Record b where 1=1";
		Object[] objs=null;
		//如果有条件则带上条件，为空的话查询全部
		/*if(record!=null){
			 objs=new Object[]{record.getCar().getId()};
			 hql+=" and b.car.id=?";
		}*/
		return recordDao.listRecord(hql, objs);
	}
	
	/**
	 * 通过分页的形式查询
	 * 时间：2016-5-9
	 * @param $
	 * @return  PageBean
	 * 
	 */
	public PageBean pageBean(PageBean pageBean,Record record){
		String hql="from Record b where 1=1";
		Object[] objs=null;
		//为空时查询全部信息
		/*if(record!=null){
			objs=new Object[]{record.getCar().getId()};
			hql=" and b.car.id=?";
		}*/
		if(pageBean==null){
			pageBean=new PageBean();
			//默认的一页显示10条记录
			pageBean.setPageSize(6);
		}
		return recordDao.pageBean(pageBean, hql, objs);
	}

}
