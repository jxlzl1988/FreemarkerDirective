package com.sten.freemarker.directive;

import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 *  freemarker 父指令
 * 
 * @author  sten
 * @since  2015年6月19日 上午11:31:09
 */
public class AbstractDirective implements TemplateDirectiveModel{
	
	public void execute(Environment env,
						@SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
						TemplateDirectiveBody body) throws TemplateException, IOException {
		throw new AbstractMethodError() ;
	}
	
	public String PREFIX = "_freemarker_directive_prefix_";
	public String DIRECTIVE_PROPERTY_NAME = "name" ;
	
	public String getDirectiveName(@SuppressWarnings("rawtypes") Map params) throws TemplateModelException {
		return PREFIX + getParamValue(params, DIRECTIVE_PROPERTY_NAME) ;
	}
	
	public String getParamValue(@SuppressWarnings("rawtypes") Map params, String key) throws TemplateModelException {
		Object value = params.get(key);
		if(value == null || "".equals(value.toString())) {
			throw new TemplateModelException("not found directive property :"+DIRECTIVE_PROPERTY_NAME );
		}
		
		return value.toString() ;
	}
	
	public String getParamValue(@SuppressWarnings("rawtypes") Map params, String key, String defaultValue) throws TemplateException {
		Object value = params.get(key);
		return value == null ? defaultValue : value.toString();
	}
}
