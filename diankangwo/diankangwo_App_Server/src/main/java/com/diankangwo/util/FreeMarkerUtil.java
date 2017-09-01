package com.diankangwo.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * freemark 模板工具
 * 
 * @author xiaoyu
 *
 */
public class FreeMarkerUtil {
	
	private static final Log LOG = LogFactory.getLog(FreeMarkerUtil.class);

	/**
	 * 获取模板字符串流
	 * 
	 * @param templateName 模板文件名称
	 * @param templateEncoding 模板文件编码格式
	 * @param root	数据模型根对象
	 */
	@SuppressWarnings("deprecation")
	public static String analysisTemplate(String templateName,String templateEncoding, Map<?, ?> root) {
		StringWriter writer = new StringWriter();
		try {
			//创建Configuration对象
			Configuration config = new Configuration();
			//指定模板路径
			String home = System.getenv("CATALINA_HOME");
			File file = new File(home+"/webapps/teach-eval/WEB-INF/classes");
			//设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(file);
			//设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());
			Template template = config.getTemplate(templateName,templateEncoding);
			//合并数据模型与模板
			//Writer out = new OutputStreamWriter(System.out);
			//template.process(root, out);
			template.process(root, writer);
			//out.flush();
			//out.close();
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LOG.debug("模板文件不存在："+e.getMessage());
		} catch (TemplateException e) {
			LOG.debug(e.getMessage());
		}
		//返回模板字符串流
		return writer.toString();
	}
	
}
