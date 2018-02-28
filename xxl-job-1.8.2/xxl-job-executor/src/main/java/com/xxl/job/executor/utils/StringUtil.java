package com.xxl.job.executor.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 去除字符串中的制表、回车、换行符，并将两个以上空格替换为空 eg:<sdfl name>\r\n </asdf> return:<sdfl
	 * name></asdf>
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\t|\r|\n|( {1,})");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static boolean isEmptyStr(String source) {
		if (source == null || source.trim().length() == 0)
			return true;
		return false;
	}
	
	/**
	 * 判断字符串是否不为空
	 * @param source
	 * @return
	 */
	public static boolean isNotEmptyStr(String source) {
		if (source == null || "".equals(source.trim()))
			return false;
		return true;
	}

	/**
	 * 字符串首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirst(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

	/**
	 * 字符串首字母小写
	 * 
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirst(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
		return sb.toString();
	}

	public static String trim(String str) {
		if (str != null) {
			return str.trim();
		} else {
			return "";
		}
	}
	//去除页面中的标签
	public static String Html2Text(String inputString) {
        String htmlStr = inputString; //含html标签的字符串
            String textStr ="";
      Pattern p_script;
      Matcher m_script;
      Pattern p_style;
      Matcher m_style;
      Pattern p_html;
      Matcher m_html;

      try {
       String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
       String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
          String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

          p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
          m_script = p_script.matcher(htmlStr);
          htmlStr = m_script.replaceAll(" "); //过滤script标签

          p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
          m_style = p_style.matcher(htmlStr);
          htmlStr = m_style.replaceAll(""); //过滤style标签

          p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
          m_html = p_html.matcher(htmlStr);
          htmlStr = m_html.replaceAll(""); //过滤html标签

       textStr = htmlStr.replaceAll("&nbsp;", " ");

      }catch(Exception e) {
               System.err.println("Html2Text: " + e.getMessage());
      }

      return textStr;//返回文本字符串
       }

	/**
	 * 根据parents返回level
	 * @param parents
	 * @param findText
     * @return
     */
	public static int getLevelByParents(String parents,String findText){
		int count = 1;//没有|的时候返回level为1
		int index = 0;
		while ((index = parents.indexOf(findText, index)) != -1) {
			index = index + findText.length();
			count++;
		}
		return count;
	}

	/**
	 * 根据parents返回上一级
	 * @param parents
	 * @param findText
     * @return
     */
	public static String getLastParents(String parents,String findText){
		int index = 0;
		int lastIndex =0;
		int finalIndex = parents.lastIndexOf(findText);
		int level = getLevelByParents(parents,findText);
		if(level==1){
			return parents;
		}
		if(level==2){
			return parents.substring(0,parents.indexOf(findText));
		}
		while ((index = parents.indexOf(findText, index)) != finalIndex) {
			lastIndex = index;
			index = index + findText.length();
		}
		parents = parents.substring(lastIndex+1,index);
		return parents;
	}


}