package com.tf.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class imageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("refresh","3");
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g=(Graphics2D)image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);

        g.setColor(Color.BLACK);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makeNum(),0,20);

        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999)+"";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<7-num.length();i++){
            sb.append("0");
        }
        num=sb.toString()+num;
        return num;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
