package servlet;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class EncodeUtil {
	public static void encode(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map map = request.getParameterMap();
		    //����ύ��ֵ
		    Collection vs = map.values();
		    Iterator it = vs.iterator();
		    while(it.hasNext()){
		    	String[] v = (String[])it.next();
		    	for(int i=0;i<v.length;i++){
		    		try {
						v[i] = new String(v[i].getBytes("ISO8859-1"),"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
		    	}
		    }
	}
}
