package com.sten.freemarker.directive;

import com.sten.freemarker.common.ParamUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * freemarker 关系指令
 * 
 * @author  sten
 * @since  2015年6月19日 上午11:30:24
 */
public class ParentDirective  implements TemplateDirectiveModel {

	public void execute(Environment env,
						@SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
						TemplateDirectiveBody body) throws TemplateException, IOException {
		
		String name = ParamUtils.getParamValue(params,"name");
		String encoding = ParamUtils.getParamValue(params, "encoding",null);
		env.include(name, encoding, true);
	}
}
