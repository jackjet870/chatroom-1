package com.leeyom.chat.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: Json数据结构工具类
 * Description: Json数据结构工具类
 * Copyriht: Copyright (c) 2016
 * Company: 龙岗远望技术软件公司
 * 
 */
public class JsonUtil {

	/**
	 * 根据传入的目标列结构和目标BEAN的List生产Json结构的字符串
	 * 
	 * @param destStruct
	 *            目标列结构的数组
	 * @param destListBean
	 *            目标BEAN的List
	 * @return
	 */
	public static String getJsonStr(String[] destStruct, List destListBean) {
		String strJson = "";

		for (int i = 0; i < destListBean.size(); i++) {
			Object bean = destListBean.get(i);

			strJson += "{";

			for (int j = 0; j < destStruct.length; j++) {
				String strCol = destStruct[j];
				String strValue = "";
				Object objValue = null;
				try {
					objValue = PropertyUtils.getProperty(bean, strCol);
				} catch (Exception e) {
				}

				if (objValue != null) {
					if (objValue instanceof Date) {
						Date objDate = (Date) objValue;
						strValue = DateUtil.getString(objDate,
								"yyyy-MM-dd HH:mm");
					} else {
						strValue = objValue.toString();
						// 将strValue中的引号转义
						strValue = getReplaceString(strValue);
					}
				}

				strJson += "\"" + strCol + "\":\"" + strValue + "\",";
			}

			if (strJson.endsWith(",")) {
				strJson = strJson.substring(0, strJson.length() - 1);
			}
			strJson += "},";
		}
		if (strJson.endsWith(",")) {
			strJson = strJson.substring(0, strJson.length() - 1);
		}

		return strJson;
	}
	/**
	 * 根据传入的目标列结构和目标BEAN的List生产Json结构的字符串
	 *
	 * @param destStruct
	 *            目标列结构的数组
	 * @param destListBean
	 *            目标BEAN的List
	 * @param format
	 *            目标BEAN的时间格式
	 * @return
	 */
	public static String getJsonStr(String[] destStruct, List destListBean,String format) {
		String strJson = "";

		for (int i = 0; i < destListBean.size(); i++) {
			Object bean = destListBean.get(i);

			strJson += "{";

			for (int j = 0; j < destStruct.length; j++) {
				String strCol = destStruct[j];
				String strValue = "";
				Object objValue = null;
				try {
					objValue = PropertyUtils.getProperty(bean, strCol);
				} catch (Exception e) {
				}

				if (objValue != null) {
					if (objValue instanceof Date) {
						Date objDate = (Date) objValue;
						strValue = DateUtil.getString(objDate,
								format);
					} else {
						strValue = objValue.toString();
						// 将strValue中的引号转义
						strValue = getReplaceString(strValue);
					}
				}

				strJson += "\"" + strCol + "\":\"" + strValue + "\",";
			}

			if (strJson.endsWith(",")) {
				strJson = strJson.substring(0, strJson.length() - 1);
			}
			strJson += "},";
		}
		if (strJson.endsWith(",")) {
			strJson = strJson.substring(0, strJson.length() - 1);
		}

		return strJson;
	}
	/**
	 * 根据传入的目标列结构和目标BEAN的List生产Json结构的字符串,日期格式为:yyyy-MM-dd
	 *
	 * @param destStruct
	 *            目标列结构的数组
	 * @param destListBean
	 *            目标BEAN的List
	 * @return
	 */
	public static String getJsonStrShortDate(String[] destStruct, List destListBean) {
		String strJson = "";

		for (int i = 0; i < destListBean.size(); i++) {
			Object bean = destListBean.get(i);

			strJson += "{";

			for (int j = 0; j < destStruct.length; j++) {
				String strCol = destStruct[j];
				String strValue = "";
				Object objValue = null;
				try {
					objValue = PropertyUtils.getProperty(bean, strCol);
				} catch (Exception e) {
				}

				if (objValue != null) {
					if (objValue instanceof Date) {
						Date objDate = (Date) objValue;
						strValue = DateUtil.getString(objDate,
								"yyyy-MM-dd");
					} else {
						//strValue = objValue.toString();
						strValue=String.valueOf(objValue);
						// 将strValue中的引号转义
						strValue = getReplaceString(strValue);
					}
				}

				strJson += "\"" + strCol + "\":\"" + strValue + "\",";
			}

			if (strJson.endsWith(",")) {
				strJson = strJson.substring(0, strJson.length() - 1);
			}
			strJson += "},";
		}
		if (strJson.endsWith(",")) {
			strJson = strJson.substring(0, strJson.length() - 1);
		}

		return strJson;
	}

	/**
	 * 针对需要转义的字符进行转义，以免与Ext需要的Json结构冲突，现在需要转义的字符有、\和"
	 * 
	 * @param str
	 * @return
	 */
	public static String getReplaceString(String str) {
		
		if (StringUtil.notNull(str)) { 
			// 将str中的引号转义 
			str = str.replaceAll("\\\\", "\\\\\\\\"); 
			str = str.replaceAll("\"", "\\\\\""); 
			// 将str中的换行符转义 
			str = str.replaceAll("\r", "\\\\r"); 
			str = str.replaceAll("\n", "\\\\n"); 
		} else { 
			str = ""; 
		} 
		return str; 
	}
	public static String beansToJson(Object bean) {
		StringBuilder json = new StringBuilder();
		PropertyDescriptor[] props = null;
		try {
			bean.getClass().getName();
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod()
							.invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * @param array
	 * 
	 * @return String
	 */
	public static String arrayToJson(Object[] array) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (array != null && array.length > 0) {
			for (Object obj : array) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	/**
	 * javabean
	 * 
	 * @param bean
	 * 
	 * @return String
	 */
	public static String beanToJson(Object bean) {
		if(bean.getClass().getName() == "org.apache.struts.action.ActionServletWrapper"){
			return null;
		}

		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod()
							.invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				} catch (Exception e) {
				}
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * beanToJsonOnly
	 * 
	 * @param bean
	 * 
	 * @return String
	 */
	public static String beanToJsonOnly(String root, Object bean) {
		JSONArray jArray = new JSONArray();
		JSONObject jObject = new JSONObject();
		JSONObject jsoObject = new JSONObject();
		PropertyDescriptor[] props = null;
		try {
			props = Introspector.getBeanInfo(bean.getClass(), Object.class)
					.getPropertyDescriptors();
		} catch (IntrospectionException e) {
		}
		if (props != null) {
			for (int i = 0; i < props.length; i++) {
				try {
					String name = objectToJsonforbeanToJsonOnly(props[i]
							.getName());
					String value = objectToJsonforbeanToJsonOnly(props[i]
							.getReadMethod().invoke(bean));

					jObject.put(name, value);
				} catch (Exception e) {
				}
			}
			jArray.add(jObject);
			jsoObject.put("success", true);
			jsoObject.put(root, jArray);
		} else {
		}
		return jsoObject.toString();
	}

	/**
	 * @param bool
	 * @return
	 * 
	 */
	public static String booleanToJson(Boolean bool) {
		return bool.toString();
	}

	/**
	 * 
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToJson(Date date) {
		String dateFormatString = "";
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatString = sdf.format(date);
		return dateFormatString;
	}

	public static String listToJson(List<?> list) {
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0) {
			for (Object obj : list) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		} else {
			json.append("]");
		}
		return json.toString();
	}

	public static String mapToJson(Map<?, ?> map) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (map != null && map.size() > 0) {
			for (Object key : map.keySet()) {
				json.append(objectToJson(key));
				json.append(":");
				json.append(objectToJson(map.get(key)));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static String nullToJson() {
		return "";
	}

	public static String numberToJson(Number number) {
		if (number.toString().equals("0") || number.toString().equals("0.0")) {
			return "\"0\"";
		}
		return number.toString();
	}

	public static String objectToJson(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("\"\"");
		} else if (obj instanceof Number) {
			json.append(numberToJson((Number) obj));
		} else if (obj instanceof Boolean) {
			json.append(booleanToJson((Boolean) obj));
		} else if (obj instanceof String) {
			json.append("\"").append(stringToJson(obj.toString())).append("\"");
		} else if (obj instanceof Object[]) {
			json.append(arrayToJson((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(listToJson((List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(mapToJson((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(setToJson((Set<?>) obj));
		} else if (obj instanceof Date) {
			json.append("\"").append(dateToJson((Date) obj)).append("\"");
		} else if (obj instanceof Long) {
			json.append("\"").append(stringToJson(obj.toString())).append("\"");
		} else {
			json.append(beanToJson(obj));
		}
		return json.toString();
	}

	public static String objectToJsonforbeanToJsonOnly(Object obj) {
		StringBuilder json = new StringBuilder();
		if (obj == null) {
			json.append("");
		} else if (obj instanceof Number) {
			json.append(numberToJson((Number) obj));
		} else if (obj instanceof Boolean) {
			json.append(booleanToJson((Boolean) obj));
		} else if (obj instanceof String) {
			json.append("").append(stringToJson(obj.toString())).append("");
		} else if (obj instanceof Object[]) {
			json.append(arrayToJson((Object[]) obj));
		} else if (obj instanceof List) {
			json.append(listToJson((List<?>) obj));
		} else if (obj instanceof Map) {
			json.append(mapToJson((Map<?, ?>) obj));
		} else if (obj instanceof Set) {
			json.append(setToJson((Set<?>) obj));
		} else if (obj instanceof Date) {
			json.append("").append(dateToJson((Date) obj)).append("");
		} else {
			json.append(beanToJsonOnly(null, obj));
		}
		return json.toString();
	}

	public static String setToJson(Set<?> set) {
		StringBuilder json = new StringBuilder();
		json.append("{");
		if (set != null && set.size() > 0) {
			for (Object obj : set) {
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, '}');
		} else {
			json.append("}");
		}
		return json.toString();
	}

	public static JSONArray stringArrayToJSONArray(String[] jStrings) {
		JSONArray jArray = new JSONArray();
		JSONObject jobject = null;
		for (int i = 0; i < jStrings.length; i++) {
			jobject = JSONObject.fromObject(jStrings[i]);
			jArray.add(jobject);
			jobject.clear();
		}
		return jArray;
	}

	public static JSONObject stringArrayToJSONObject(String[] jString, int index) {
		JSONObject jsObject = new JSONObject();
		JSONArray jArray = stringArrayToJSONArray(jString);
		jsObject = (JSONObject) jArray.get(index);
		return jsObject;
	}

	public static String stringToJson(String s) {
		if (s == null) {
			return nullToJson();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				if (ch >= '\u0000' && ch <= '\u001F') {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
	public static String getJsonStr(List paramList,List valueList){
		StringBuilder ps = new StringBuilder();
		for (int i =0;i<paramList.size();i++) {
			if (i==0) {
				ps.append("{");
			}
			Object currentData = valueList.get(i)==null?"":valueList.get(i);
			if (i!=paramList.size()-1) {
				ps.append("\""+paramList.get(i)+"\":\"" + currentData + "\",");
			}
			if (i==paramList.size()-1) {
				ps.append("\""+paramList.get(i)+"\":\"" + currentData + "\"},");
			}
		}
		return ps.toString();
	}
	public static HashMap<String, String> toHashMap(Object object){   
        HashMap<String, String> data = new HashMap<String, String>();   
        // 将json字符串转换成jsonObject   
        JSONObject jsonObject = JSONObject.fromObject(object);   
        Iterator it = jsonObject.keys();   
        // 遍历jsonObject数据，添加到Map对象   
        while (it.hasNext()) {   
            String key = String.valueOf(it.next());   
            String value = (String) jsonObject.get(key);   
            data.put(key, value);   
        }   
        return data;   
	 }  

	/**
	 * json转换成Map
	 * 需要的json格式为{"userName":"XXX","tel","12323"}
	 * @param json
	 * @return
	 */
	public static Map<String,String> jsonToMap(String json){
		Map<String, String> jsonMap = new HashMap<String, String>();
		String[] jsonArray = json.substring(1, json.length()-1).split(",");
		for (int i = 0; i < jsonArray.length; i++) {
			String key = jsonArray[i].split(":")[0];
			String value = jsonArray[i].split(":")[1];
			System.out.println("################"+key+"%%%%%%%%%%%%%%%%%%%%%%%%%%"+value);
			jsonMap.put(key, value);
		}
		return jsonMap;
	}
	public static String string2Json(String s) {        
        StringBuffer sb = new StringBuffer();        
        for (int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);    
             switch (c){  
             case '\"':        
                 sb.append("\\\"");        
                 break;        
             case '\\':        
                 sb.append("\\\\");        
                 break;        
             case '/':        
                 sb.append("\\/");        
                 break;        
             case '\b':        
                 sb.append("\\b");        
                 break;        
             case '\f':        
                 sb.append("\\f");        
                 break;        
             case '\n':        
                 sb.append("\\n");        
                 break;        
             case '\r':        
                 sb.append("\\r");        
                 break;        
             case '\t':        
                 sb.append("\\t");        
                 break;        
             default:        
                 sb.append(c);     
             }  
         }      
        return sb.toString();     
     } 
	public static List listCrawl(List dataList,Class clazz){  
        String ss="java.lang.String,java.util.Date,java.lang.Integer,java.lang.Long,int,float,long";  
        String filterType="java.util.Map,java.util.HashMap,java.util.Set,java.util.HashSet";  
        try{  
        for(int i=0;i<dataList.size();i++){  
            Object originalObj=dataList.get(i);//原始数据对象  
            Method[] originalMethods= clazz.getDeclaredMethods();//原始数据对象的方法  
            for(Method originalMethod:originalMethods){  
                System.out.println("original MethodName:  "+originalMethod.getName());  
                if(originalMethod.getName().contains("get")){  
                    System.out.println("getMethod returnType: "+originalMethod.getReturnType().getName());  
                    String returnType=originalMethod.getReturnType().getName();//get方法返回的对象类型  
                    if(!ss.contains(returnType)&&!filterType.contains(returnType)){//不是基本类型和Set Map等集合，即是二级对象  
                        Object proxyObjct=originalMethod.invoke(originalObj, null);//二级hibernate代理对象  
                        if(proxyObjct!=null){//二级代理对象是否为空  
                        Class proxyClass=proxyObjct.getClass();  
                        Method[] proxyMethods=proxyClass.getDeclaredMethods();  
                          
                        Class tempClazz=Class.forName(returnType);//创建一个hibernate代理的原始二级对象  
                        Object tempObject=tempClazz.newInstance();//创建一个hibernate代理的原始二级对象  
                          
                        for(Method proxyMethod:proxyMethods ){//  
                            if(ss.contains(proxyMethod.getReturnType().getName())){//只抓取hibernate代理的二级对象的基础数据  
                            if(proxyMethod.getName().contains("get")){  
                                Object returnValue=proxyMethod.invoke(proxyObjct, null);//  
                                System.out.println("proxy  returnValue:"+returnValue);  
                                String setMethod=proxyMethod.getName().replace("get", "set");  
                                System.out.println("setMethod name:"+setMethod);  
                                Method tempMethod=tempClazz.getDeclaredMethod(setMethod, proxyMethod.getReturnType());  
                                tempMethod.invoke(tempObject, returnValue);  
                            }  
                            }  
                        }  
                        Method originalMethod1=clazz.getDeclaredMethod(originalMethod.getName().replace("get", "set"), originalMethod.getReturnType());  
                        originalMethod1.invoke(originalObj, tempObject);//为原始对象重新装入一个非hibernate代理对象  
                          
                        }  
                          
                    }  
                    }  
            }  
        }  
        }catch(Exception e){  
            System.out.println("处理加载对象出现问题");  
            e.printStackTrace();  
        }  
          
        return dataList;  
    }  
}
