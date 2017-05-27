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
		// 1. ����������֤�뻭�����
		BufferedImage authImg = new BufferedImage(120, 80, BufferedImage.TYPE_INT_RGB);
		// 2. ͨ����������ȡ����
		Graphics g = authImg.getGraphics();
		// 3. ���û�������
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		// 4. ������֤��
		Random rd = new Random();
		String all = "";
		String num = "";
		for(int i=0; i<4;i++){
			num = String.valueOf((rd.nextInt(10)));
			all += num;
			g.drawString(num, i*25, 30);  // TODO ������Ҫȥ����num�հף��Լ���֤���м仭һ����
		}
		request.getSession().setAttribute("authCode", all);
		
		// 5. ��������ͼƬ����
		g.dispose();
		// 6. ��ͼƬ���ظ�����ҳ��
		ImageIO.write(authImg, "jpeg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}