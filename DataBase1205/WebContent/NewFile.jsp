<%@ page language="java" contentType="image/jpeg;charset=GBK" %>
<%@ page language="java" import="java.util.*,java.awt.*, java.awt.image.*,javax.imageio.ImageIO" pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

  <% 
 // 在內存中创建图像  
  int width  = 600;  
  int height = 500;  
  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
    
 // 绘制图像  
  Graphics g = image.getGraphics();  
  Graphics2D g2d = (Graphics2D) g;  
  // 背景色  
  g.setColor(new Color(240, 249, 255));  
    
  g.fillRect(0, 0, width, height);  
  // 字体颜色  
  g.setColor(Color.BLACK);  
  g.setFont(new Font("宋体", Font.PLAIN, 22));  
  g.drawString("上半年访问量统计", 15, 25);  
  ArrayList list3= (ArrayList)request.getSession().getAttribute("list3");
   
  String mongth[] = { "1月", "2月", "3月", "4月", "5月", "6月" };  
    
  g.setFont(new Font("宋体", Font.BOLD, 16));  
  g.drawString("访问量（单位：万次）", 20, 50);  
  g.drawString("月份", 550, 465);  
  g.setFont(new Font("SanSSerif", Font.PLAIN, 12));  
    
  int visitValue = 0; 
   
  for (int i = 418; i > 0; i -= 38) {  
      g.setColor(Color.BLACK);  
      g.drawString("" + visitValue, 36, (i + 27));  
      g.setColor(Color.LIGHT_GRAY);  
      g.drawLine(80, (i + 27), 520, (i + 27));  
     visitValue += 10;  
  }  
 g.setColor(Color.BLACK);  
 g.drawLine(80, 40, 80, 445);  
 g.drawLine(80, 445, 550, 445);  
 int drawHigh[] = new int[mongth.length];  
 int drawwidth[] = new int[mongth.length];  
 
 for (int i = 0; i < 
		 list3.size(); i++) {  
	  
     g.drawString(mongth[i], 110 + i * 80, 465);  
 }  
    
 //g2d.setXORMode(Color.WHITE);  
 //折线粗细  
  g2d.setStroke(new BasicStroke(3.0f));  
  //折线的颜色  
 g2d.setPaint(Color.RED);  
 //画折线  
 g2d.drawPolyline(drawwidth, drawHigh, mongth.length);  
 // 产生图像  
  g.dispose();  
    
  ServletOutputStream sos = response.getOutputStream();  
  ImageIO.write(image,"JPEG",sos); 
  sos.close(); 
  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>