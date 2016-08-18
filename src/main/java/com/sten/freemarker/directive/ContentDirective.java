package com.sten.freemarker.directive;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * freemarker 内容指令
 * 
 * @author  sten
 * @since  2015年6月19日 上午11:31:54
 */
public class ContentDirective extends AbstractDirective {

	public void execute(Environment env,
						@SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
						TemplateDirectiveBody body) throws TemplateException, IOException {
		String name = getDirectiveName(params) ;
		
		TemplateDirectiveBodyOverrideWraper current = new TemplateDirectiveBodyOverrideWraper(body,env);
		env.setVariable(name, current);
	}
	
	static class TemplateDirectiveBodyOverrideWraper implements TemplateDirectiveBody,TemplateModel{
		private TemplateDirectiveBody body;
		public Environment env;
		
		public TemplateDirectiveBodyOverrideWraper(TemplateDirectiveBody body,
				Environment env) {
			super();
			this.body = body;
			this.env = env;
		}
		
		public void render(Writer out) throws TemplateException, IOException {
			if(body == null) return;
			body.render(out);
		}
	}
	
}
