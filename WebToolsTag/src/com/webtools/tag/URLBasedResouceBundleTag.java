package com.webtools.tag;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
public class URLBasedResouceBundleTag extends BodyTagSupport{

	private PageContext pageContext;
	private String var;
	private String baseName;
	/**
	 * @return the var
	 */
	public String getVar() {
		return var;
	}
	/**
	 * @param var the var to set
	 */
	public void setVar(String var) {
		this.var = var;
	}
	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}
	/**
	 * @param baseName the baseName to set
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public void setPageContext(PageContext context)
	{	
		this.pageContext=context;
	}
	public int doStartTag()
	{
		String lang=this.getLocaleLang();
		ResourceBundle bundle =ResourceBundle.getBundle(baseName,new Locale(lang));
		Map<String,String> labelValueMap=new HashMap<String,String>();
		Enumeration<String> keys=bundle.getKeys();
		while(keys.hasMoreElements())
		{
			String key=keys.nextElement();
			labelValueMap.put(key,bundle.getString(key));
		}	
		pageContext.setAttribute(var, labelValueMap);
		return Tag.SKIP_BODY;
	}
	
	private String getLocaleLang()
	{
		String lang=(String)pageContext.getAttribute("lang", PageContext.SESSION_SCOPE);
		if(lang!=null)
		{
			return lang;
		}
		else
		{
			return null;
		}
		
		
	}
	
	public int doEndTag()
	{
		return Tag.EVAL_PAGE;
	}
		
	
}
