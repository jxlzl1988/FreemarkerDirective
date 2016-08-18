package com.sten.freemarker.directive;

import com.sten.freemarker.common.ParamUtils;
import com.sten.freemarker.common.TemplateDirectiveBodyOverrideWraper;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.util.Map;

/**
 * freemarker 布局指令
 * 
 * @author  sten
 * @since  2015年6月19日 上午11:31:41
 */
public class LayoutDirective  implements TemplateDirectiveModel {
	
	public void execute(Environment env,
						@SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
						TemplateDirectiveBody body) throws TemplateException, IOException {

		String name = ParamUtils.getDirectiveName(params) ;
		TemplateDirectiveBodyOverrideWraper overrideBody = (TemplateDirectiveBodyOverrideWraper) env.getVariable(name) ;
		if(overrideBody == null) {
			if(body != null) {
				body.render(env.getOut());
			}
		}else {
			overrideBody.render(env.getOut());
		}
	}
		
}
