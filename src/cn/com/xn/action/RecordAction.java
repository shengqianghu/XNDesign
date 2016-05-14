package cn.com.xn.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.com.xn.model.Record;
import cn.com.xn.service.RecordService;

public class RecordAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2700003730400491183L;
	private Record record;
	private RecordService service = new RecordService();
	
	public String submitRepair(){
		service.addRecord(record);
		return SUCCESS;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	
}
