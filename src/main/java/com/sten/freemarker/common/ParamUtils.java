package com.sten.freemarker.common;

import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

import java.util.Map;

/**
 *
 * params map 参数获取工具类
 *
 * @author  sten
 * @since  2015年6月19日 上午11:31:54
 */
public class ParamUtils {

    private static String PREFIX = "_freemarker_directive_prefix_";

    public static String getDirectiveName(@SuppressWarnings("rawtypes") Map params) throws TemplateModelException {
        return PREFIX + getParamValue(params, "name") ;
    }

    public static String getParamValue(@SuppressWarnings("rawtypes") Map params, String key) throws TemplateModelException {
        Object value = params.get(key);
        if(value == null || "".equals(value.toString())) {
            throw new TemplateModelException("not found directive property : name");
        }

        return value.toString() ;
    }

    public static String getParamValue(@SuppressWarnings("rawtypes") Map params, String key, String defaultValue) throws TemplateException {
        Object value = params.get(key);
        return value == null ? defaultValue : value.toString();
    }

}
