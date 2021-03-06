package com.study.servletImg;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateImg
 */
@WebServlet("/CreateImg")
public class CreateImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateImg() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 创建缓存验证码画板对象
		BufferedImage authImg = new BufferedImage(120, 80, BufferedImage.TYPE_INT_RGB);
		// 2. 通过画板对象获取画笔
		Graphics g = authImg.getGraphics();
		// 3. 设置画笔字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 4. 绘制验证码
		Random rd = new Random();
		String all = "";
		String num = "";
		for(int i=0; i<4;i++){
			num = String.valueOf((rd.nextInt(10)));
			all += num;
			g.drawString(num, i*25, 30);  // TODO 这里需要去测试num空白，以及验证码中间画一条线
		}
		request.getSession().setAttribute("authCode", all);
		
		// 5. 画笔整理图片定型
		g.dispose();
		// 6. 将图片返回给请求页面
		ImageIO.write(authImg, "jpeg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
