package com.test;

import java.sql.Timestamp;

	  
	public class Record {
	    
	    private String taizhan_num;    //̨վ��
	    private String tem;            //�¶�
	    private String hum;            //ʪ��
	    private String pa;            //ѹǿ
	    private String rain;        //����
	    private String win_dir;        //����
	    private String win_sp;        //����
	    private String dateStr;        //�۲����ڣ�����Echarts��ʾ��ʽ��
	    private Timestamp date;        //�۲����ڣ�ԭʼ��ʽ��
	    
	    /**
	     * ��ȡ�۲����ڣ�����echartsͼ��չʾ����
	     * @return �۲�����ֵ
	     */
	    public String getDateStr() {
	        return dateStr;
	    }

	    /**
	     * ���ù۲����ڣ�����echartsͼ��չʾ����
	     * @param dateStr �����ù۲�����ֵ
	     */
	    public void setDateStr(String dateStr) {
	        this.dateStr = dateStr;
	    }
	    
	    /**
	     * ��ȡ�����ù۲��¼��̨վ���ƣ�
	     * @return ̨վ����
	     */
	    public String getTaizhan_num() {
	        return taizhan_num;
	    }

	    /**
	     * ���ò����ù۲��¼��̨վ���ƣ�
	     * @param taizhan_num ������̨վ����
	     */
	    public void setTaizhan_num(String taizhan_num) {
	        this.taizhan_num = taizhan_num;
	    }

	    /**
	     * ��ȡ�¶ȣ�
	     * @return �¶�ֵ
	     */
	    public String getTem() {
	        return tem;
	    }

	    /**
	     * �����¶ȣ�
	     * @param tem �������¶�ֵ
	     */
	    public void setTem(String tem) {
	        this.tem = tem;
	    }

	    /**
	     * ��ȡʪ�ȣ�
	     * @return ʪ��ֵ 
	     */
	    public String getHum() {
	        return hum;
	    }

	    /**
	     * ����ʪ�ȣ�
	     * @param hum ������ʪ��ֵ
	     */
	    public void setHum(String hum) {
	        this.hum = hum;
	    }

	    /**
	     * ��ȡѹǿ��
	     * @return ѹǿֵ
	     */
	    public String getPa() {
	        return pa;
	    }

	    /**
	     * ����ѹǿ��
	     * @param pa ������ѹǿֵ
	     */
	    public void setPa(String pa) {
	        this.pa = pa;
	    }

	    /**
	     * ��ȡ������
	     * @return ����ֵ
	     */
	    public String getRain() {
	        return rain;
	    }

	    /**
	     * ����������
	     * @param rain ����������ֵ
	     */
	    public void setRain(String rain) {
	        this.rain = rain;
	    }

	    /**
	     * ��ȡ����
	     * @return ����ֵ
	     */
	    public String getWin_dir() {
	        return win_dir;
	    }

	    /**
	     * ���÷���
	     * @param win_dir �����÷���ֵ
	     */
	    public void setWin_dir(String win_dir) {
	        this.win_dir = win_dir;
	    }

	    /**
	     * ��ȡ���٣�
	     * @return ����ֵ
	     */
	    public String getWin_sp() {
	        return win_sp;
	    }

	    /**
	     * ���÷���
	     * @param win_sp �����÷���ֵ
	     */
	    public void setWin_sp(String win_sp) {
	        this.win_sp = win_sp;
	    }

	    /**
	     * ��ȡ�۲����ڣ�
	     * @return �۲�����
	     */
	    public Timestamp getDate() {
	        return date;
	    }

	    /**
	     * ���ù۲����ڣ� 
	     * @param date �۲�����ֵ
	     */
	    public void setDate(Timestamp date) {
	        this.date = date;
	    }

	    
	}
