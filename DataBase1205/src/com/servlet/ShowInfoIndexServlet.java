package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.test.DBUtil;
import com.test.Record;

/**
 * ��Ӧ�۲��¼չʾҳ��Echartsͼ����������ʹ��json��ʽ���ؿͻ�����Ҫ�����ݣ�
 * @author zhong
 *
 */
public class ShowInfoIndexServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");    //�趨�ͻ����ύ��servlet�����ݰ�UTF-8����
        response.setCharacterEncoding("UTF-8");    //�趨servlet���ظ��ͻ��˵����ݰ�UTF-8����
        response.setContentType("text/html;charset=UTF-8");    //��֪�������UTF-8��ʽ��������
                
        String name = request.getParameter("name");    //��ȡ̨վ������
        
        //��ȡ�������ڵ�������ǰ��0���ʽ�ַ������������ݿ��ѯ��
        Calendar  cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -4);        //��ȡ�������ڵ�������ǰ������ʱ��
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");    //�趨���ڸ�ʽ
        String fiveDaysAgoStr = sdf1.format(cal.getTime());    //������ǰ������ʱ�䰴ָ����ʽת�����ַ���
                
        //��ȡ��ǰʱ�䲢����ת����ָ����ʽ���ַ������������ݿ��ѯ��
        Date now = new Date();  
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String nowStr = sdf2.format(now);  
//System.out.println(nowStr);      
        
        
        
//======================================�������ݿ����============================================================================================        
        /*
         * �������ݿⲢ��ȡ�����ڸ����Ƶ�����վ�����вɼ�����
         */
        List<Record> records = new ArrayList<Record>();    //��һ��ArrayList��ʢװ��װ�˸��������ݵĶ���
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtil.getConnection();    //��ȡ�����ݿ������
            String sql = "select * from din where data_taizhan_num = ? and data_date >= ? and data_date <= ? order by data_date asc";    //��ʼ��SQL��ѯ���
            pstmt = conn.prepareStatement(sql);    //����preparedStatement������    
            pstmt.setString(1, name);    //�趨��ѯ����
            pstmt.setString(2, fiveDaysAgoStr);
            pstmt.setString(3, nowStr);
            rs = pstmt.executeQuery();    //��ȡ��ѯ���Ľ����
            while (rs.next()) {
                //��װRecord����
                Record r = new Record();
                r.setTaizhan_num(rs.getString(1));
                r.setDate(rs.getTimestamp(2));
                r.setTem(rs.getString(3));
                r.setHum(rs.getString(4));
                r.setPa(rs.getString(5));
                r.setRain(rs.getString(6));
                r.setWin_dir(rs.getString(7));
                r.setWin_sp(rs.getString(8));
                
                //��ʱ��ת���ɸ�����ʽ����echarts��X������������ʾ
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");             
                String str = sdf.format(rs.getTimestamp(2));
                r.setDateStr(str);
//System.out.println(r.getTem()+" | "+r.getHum()+" | "+r.getPa()+" | "+r.getRain()+" | "+r.getWin_dir()+" | "+r.getWin_sp());                                            
                records.add(r);        //����װ�õ�Record��������б�������
            }
            
        } catch (SQLException e) {
            System.out.println("��ѯ��������δ���!");
            e.printStackTrace();
        } finally {
            //��ѯ�������ͷ���Դ
            DBUtil.close(rs);
            DBUtil.close(pstmt);
            DBUtil.close(conn);
        }    
//======================================�������ݿ�������꣩============================================================================================         
        
        
        
      //��list�еĶ���ת��ΪJson��ʽ������
        Gson gson = new Gson();                    
        String json = gson.toJson(records);    
        
//System.out.println(json);
        
        //��json���ݷ��ظ��ͻ���
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);
    }

}