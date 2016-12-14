package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dao.Din;
import com.dao.DinDao;
import com.dao.Income;
import com.test.JDBconne;
 
public class AllIncomeServelt extends HttpServlet {
	private Connection connection;
    public void init() throws ServletException
    {
        super.init();
                  //获得数据库连接
       connection=JDBconne.getConnetion();
    }
    public void destroy()
    {
     super.destroy();
           //关闭数据库连接 
         JDBconne.closeConnection();
    }


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
     doPost(request, response);
 }
 
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
	 
        DinDao din=new DinDao();
        ArrayList<Din> listincome=din.income(connection, "2016-01-01","2016-01-31");
        ArrayList<Din> listincome2=din.income(connection, "2016-02-01","2016-02-29");
        ArrayList<Din> listincome3=din.income(connection, "2016-03-01","2016-03-31");
        ArrayList<Din> listincome4=din.income(connection, "2016-04-01","2016-04-30");
        ArrayList<Din> listincome5=din.income(connection, "2016-05-01","2016-05-31");
        ArrayList<Din> listincome6=din.income(connection, "2016-06-01","2016-06-30");
        ArrayList<Din> listincome7=din.income(connection, "2016-07-01","2016-07-31");
        ArrayList<Din> listincome8=din.income(connection, "2016-08-01","2016-08-31");
        ArrayList<Din> listincome9=din.income(connection, "2016-09-01","2016-09-30");
        ArrayList<Din> listincome10=din.income(connection, "2016-10-01","2016-10-31");
        ArrayList<Din> listincome11=din.income(connection, "2016-11-01","2016-11-30");
        ArrayList<Din> listincome12=din.income(connection, "2016-12-01","2016-12-31");
        
        
        System.out.println("list的长度是多少"+listincome.size());
        ArrayList list=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
   
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
      
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();
        ArrayList list10=new ArrayList();
        ArrayList list11=new ArrayList();
        ArrayList list12=new ArrayList();
       for(int i=0;i<listincome.size();i++){
        	list.add(listincome.get(i).getJiage());
        	
        }
       for(int i=0;i<listincome2.size();i++){
       	list2.add(listincome2.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome3.size();i++){
       	list3.add(listincome3.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome4.size();i++){
       	list4.add(listincome4.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome5.size();i++){
       	list6.add(listincome5.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome7.size();i++){
       	list7.add(listincome7.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome8.size();i++){
       	list8.add(listincome8.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome9.size();i++){
       	list9.add(listincome9.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome10.size();i++){
       	list10.add(listincome10.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome11.size();i++){
       	list11.add(listincome11.get(i).getJiage());
       	
       }
       for(int i=0;i<listincome12.size();i++){
       	list12.add(listincome12.get(i).getJiage());
       	
       }
       int income=0;
       int income2=0;
       int income3=0;
       int income4=0;
       int income5=0;
       int income6=0;
       int income7=0;
       int income8=0;
       int income9=0;
       int income10=0;
       int income11=0;
       int income12=0;
       
        System.out.println("list3"+list3.size());
        
        for(int i=0;i<list.size();i++){
        	income=income+(int)list.get(i);
        }
        for(int i=0;i<list2.size();i++){
        	income2=income2+(int)list2.get(i);
        }
        for(int i=0;i<list3.size();i++){
        	income3=income3+(int)list3.get(i);
        }
        for(int i=0;i<list4.size();i++){
        	income4=income4+(int)list4.get(i);
        }
        for(int i=0;i<list5.size();i++){
        	income5=income5+(int)list5.get(i);
        }
        for(int i=0;i<list6.size();i++){
        	income6=income6+(int)list6.get(i);
        }
        for(int i=0;i<list7.size();i++){
        	income7=income7+(int)list7.get(i);
        }
        for(int i=0;i<list8.size();i++){
        	income8=income8+(int)list8.get(i);
        }
        for(int i=0;i<list9.size();i++){
        	income9=income9+(int)list9.get(i);
        }
        for(int i=0;i<list10.size();i++){
        	income10=income10+(int)list10.get(i);
        }
        for(int i=0;i<list11.size();i++){
        	income11=income11+(int)list11.get(i);
        }
        for(int i=0;i<list12.size();i++){
        	income12=income12+(int)list12.get(i);
        }
        ArrayList<Income> main=new ArrayList<Income>();
        int all=income+income2+income3+income4+income5+income6+income7+income8+income9+income10+income11+income12; 
        Income month=new Income("1月", income);
        main.add(month);
        Income month2=new Income("2月", income2);
        main.add(month2);
        Income month3=new Income("3月", income3);
        main.add(month3);
        Income month4=new Income("4月", income4);
        main.add(month4);
        Income month5=new Income("5月", income5);
        main.add(month5);
        Income month6=new Income("6月", income6);
        main.add(month6);
        Income month7=new Income("7月", income7);
        main.add(month7);
        Income month8=new Income("8月", income8);
        main.add(month8);
        Income month9=new Income("9月", income9);
        main.add(month9);
        Income month10=new Income("10月", income10);
        main.add(month10);
        Income month11=new Income("11月", income11);
        main.add(month11);
        Income month12=new Income("12月", income12);
        main.add(month12);
        System.out.println("income="+income); 
        request.getSession().setAttribute("all", all);
        request.getSession().setAttribute("main", main);
        System.out.println("mainlist="+main.size());
        System.out.println("mainlist="+main.get(1).getMonth());
			request.getRequestDispatcher("NewFile3.jsp").forward(request, response);
      
     
     
     
      
 }

}