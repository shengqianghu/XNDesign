package cn.com.xn.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateTable {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
}
