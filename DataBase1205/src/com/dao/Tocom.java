


package com.dao;





import java.io.UnsupportedEncodingException;

public class Tocom
{
	public static String toCN(String value)
	{
                String cn = null;
		try
		{
			// �����ݽ������ַ���ת����byte���飬��ȷ�������
			byte[] b = value.getBytes("ISO-8859-1");
			// ��byte���鹹��һ���µ��ַ�������ָ�������
			cn = new String(b, "GBK");
		}
		catch (UnsupportedEncodingException e)
		{
		}
		// ��ת���ɹ����ַ�������
		return cn;
	}
}
