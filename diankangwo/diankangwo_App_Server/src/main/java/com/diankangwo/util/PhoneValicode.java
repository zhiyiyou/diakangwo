package com.diankangwo.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
 * 手机短信验证码
 * 
 * @author xiaoyu
 *
 */
public class PhoneValicode {

	/**
	 * 手机短信
	 */
	public void xioo(String volicode, String phone) throws IOException {
		// 发送内容
		String content = "【卡车医生】验证码：" + volicode + ";如非本人操作请忽略本短信！";
		String sign = "";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=kcys");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=8D3E49F4965EF436BEF84BD87CA7");

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+phone);

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content=" + URLEncoder.encode(content, "UTF-8"));

		// 追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");

		// 加签名
		sb.append("&sign=" + URLEncoder.encode(sign, "UTF-8"));

		// type为固定值pt extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		// String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		//sb.append(new Date().getTime());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("sb:" + sb.toString());
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		InputStream is = url.openStream();

		// 转换返回值
		String returnStr = convertStreamToString(is);

		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
		System.out.println("-----------------------------------------------------------------");
		System.out.println(returnStr);
		System.out.println("-----------------------------------------------------------------");
		System.out.println(phone);
		System.out.println("验证码："+content);
	}
	
	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
}
