package com.test;

import java.sql.Timestamp;

	  
	public class Record {
	    
	    private String taizhan_num;    //台站名
	    private String tem;            //温度
	    private String hum;            //湿度
	    private String pa;            //压强
	    private String rain;        //雨量
	    private String win_dir;        //风向
	    private String win_sp;        //风速
	    private String dateStr;        //观测日期（用于Echarts显示格式）
	    private Timestamp date;        //观测日期（原始格式）
	    
	    /**
	     * 获取观测日期（用于echarts图表展示）；
	     * @return 观测日期值
	     */
	    public String getDateStr() {
	        return dateStr;
	    }

	    /**
	     * 设置观测日期（用于echarts图表展示）；
	     * @param dateStr 待设置观测日期值
	     */
	    public void setDateStr(String dateStr) {
	        this.dateStr = dateStr;
	    }
	    
	    /**
	     * 获取产生该观测记录的台站名称；
	     * @return 台站名称
	     */
	    public String getTaizhan_num() {
	        return taizhan_num;
	    }

	    /**
	     * 设置产生该观测记录的台站名称；
	     * @param taizhan_num 待设置台站名称
	     */
	    public void setTaizhan_num(String taizhan_num) {
	        this.taizhan_num = taizhan_num;
	    }

	    /**
	     * 获取温度；
	     * @return 温度值
	     */
	    public String getTem() {
	        return tem;
	    }

	    /**
	     * 设置温度；
	     * @param tem 待设置温度值
	     */
	    public void setTem(String tem) {
	        this.tem = tem;
	    }

	    /**
	     * 获取湿度；
	     * @return 湿度值 
	     */
	    public String getHum() {
	        return hum;
	    }

	    /**
	     * 设置湿度；
	     * @param hum 待设置湿度值
	     */
	    public void setHum(String hum) {
	        this.hum = hum;
	    }

	    /**
	     * 获取压强；
	     * @return 压强值
	     */
	    public String getPa() {
	        return pa;
	    }

	    /**
	     * 设置压强；
	     * @param pa 待设置压强值
	     */
	    public void setPa(String pa) {
	        this.pa = pa;
	    }

	    /**
	     * 获取雨量；
	     * @return 雨量值
	     */
	    public String getRain() {
	        return rain;
	    }

	    /**
	     * 设置雨量；
	     * @param rain 待设置雨量值
	     */
	    public void setRain(String rain) {
	        this.rain = rain;
	    }

	    /**
	     * 获取风向；
	     * @return 风向值
	     */
	    public String getWin_dir() {
	        return win_dir;
	    }

	    /**
	     * 设置风向；
	     * @param win_dir 待设置风向值
	     */
	    public void setWin_dir(String win_dir) {
	        this.win_dir = win_dir;
	    }

	    /**
	     * 获取风速；
	     * @return 风速值
	     */
	    public String getWin_sp() {
	        return win_sp;
	    }

	    /**
	     * 设置风向；
	     * @param win_sp 待设置风向值
	     */
	    public void setWin_sp(String win_sp) {
	        this.win_sp = win_sp;
	    }

	    /**
	     * 获取观测日期；
	     * @return 观测日期
	     */
	    public Timestamp getDate() {
	        return date;
	    }

	    /**
	     * 设置观测日期； 
	     * @param date 观测日期值
	     */
	    public void setDate(Timestamp date) {
	        this.date = date;
	    }

	    
	}
