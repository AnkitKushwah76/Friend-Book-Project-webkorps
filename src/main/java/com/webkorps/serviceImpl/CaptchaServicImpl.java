package com.webkorps.serviceImpl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
@Service
public class CaptchaServicImpl {


	public String chapcha(HttpServletResponse response) throws IOException {
	Font fntStyle1 = new Font("Arial", Font.BOLD, 30);
	Random randChars = new Random();
	String sImageCode = (Long.toString(Math.abs(randChars.nextLong()), 36)).substring(0, 6);
	BufferedImage bufferedImage = new BufferedImage(150, 40, BufferedImage.TYPE_INT_RGB);
	Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
	for (int j= 0; j < 15; j++) {
		graphics2D.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
	}
	graphics2D.setFont(fntStyle1);
	for (int i = 0; i < 6; i++) {
		graphics2D.setColor(new Color(randChars.nextInt(255), randChars.nextInt(255), randChars.nextInt(255)));
		if (i % 2 == 0) {
			graphics2D.drawString(sImageCode.substring(i, i + 1), 25 * i, 24);
		} else {
			graphics2D.drawString(sImageCode.substring(i, i + 1), 25 * i, 35);
		}
	}
	OutputStream outputStream = response.getOutputStream();
	ImageIO.write(bufferedImage, "jpeg", outputStream);
	graphics2D.dispose();
	return sImageCode;
}
}