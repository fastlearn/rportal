package com.renguangli.rportal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class RportalApplicationTests {

	@Test
	public void contextLoads() {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128);//要生成多少位，只需要修改这里即可128, 192或256
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			String s = byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为"+s.length());
			System.out.println("二进制密钥的长度为"+s.length()*4);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			System.out.println("没有此算法。");
		}
	}

	/**
	 * byte数组转化为16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String byteToHexString(byte[] bytes){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String strHex=Integer.toHexString(bytes[i]);
			if(strHex.length() > 3){
				sb.append(strHex.substring(6));
			} else {
				if(strHex.length() < 2){
					sb.append("0" + strHex);
				} else {
					sb.append(strHex);
				}
			}
		}
		return  sb.toString();

	}

	@Test
	public void test1() {
        String str = "/hello/1.0/hello?count=1";
        System.out.println(str.substring(str.lastIndexOf('=') + 1, str.length()));
    }

}
