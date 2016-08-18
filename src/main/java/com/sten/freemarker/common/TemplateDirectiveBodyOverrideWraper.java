package com.sten.freemarker.common;

import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * TemplateDirectiveBody的代理类
 *
 * @author  sten
 * @since  2015年6月19日 上午11:31:54
 */
public class TemplateDirectiveBodyOverrideWraper implements TemplateDirectiveBody,TemplateModel {

    private TemplateDirectiveBody body;

    public TemplateDirectiveBodyOverrideWraper(TemplateDirectiveBody body) {
        super();
        this.body = body;
    }

    public void render(Writer out) throws TemplateException, IOException {
        if(body == null) return;
        body.render(out);
    }
}
