package com.watchitlater.spring;

import org.antlr.stringtemplate.AttributeRenderer;
import org.antlr.stringtemplate.NoIndentWriter;
import org.antlr.stringtemplate.StringTemplate;

import java.io.IOException;
import java.io.Writer;

public class WebStringTemplate extends StringTemplate {

    private WebAttributeRenderer defaultRenderer = new WebAttributeRenderer(WebFormat.html);

    public void setDefaultFormat(WebFormat defaultFormat) {
        defaultRenderer = new WebAttributeRenderer(defaultFormat);
    }

    public AttributeRenderer getAttributeRenderer(Class aClass) {
        AttributeRenderer renderer = super.getAttributeRenderer(aClass);
        return (renderer != null) ? renderer : defaultRenderer;
    }

    public void register(Renderer renderer) {
        registerRenderer(renderer.getTypeToRender(), new RendererAdaptor(renderer));
    }

    public void write(Writer out) throws IOException {
        write(new NoIndentWriter(out));
    }
}