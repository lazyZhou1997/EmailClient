package edu.scu.connection;

import edu.scu.domain.GetMailInfo;
import edu.scu.domain.MailList;
import edu.scu.utils.MailStringDeal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

/**
 * @author 周秦春
 * @date 2017-12-7
 */
public class GetMailTemple {

    public static MailList getMail(GetMailInfo getMailInfo) {
        MailList getMails = new MailList();
        try {
            //与邮件服务器建立连接
            Socket socket = new Socket(getMailInfo.getServerHost(), getMailInfo.getServerPort());
            //获取邮件服务器流
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket
                    .getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

            //打印欢迎信息
            System.out.println(input.readLine());

            //登录
            //账号
            output.println("user " + getMailInfo.getMailAddress());
            output.flush();
            //打印服务器回应
            System.out.println(input.readLine());
            //密码
            output.println("pass " + getMailInfo.getPassword());
            output.flush();

            //判断是否登录成功
            String serverSay;
            serverSay = input.readLine();
            System.out.println(serverSay);
            if (!serverSay.startsWith("+OK")) {

                System.out.println("登录错误");
                socket.close();
                input.close();
                output.close();
                return getMails;
            }
            System.out.println(serverSay);


            //处理接收的邮件
            //邮件数量
            int mailCount = Integer.parseInt(serverSay.substring(4, 5));
            //开始接收
            for (int i = 1; i <= mailCount; i++) {
                output.println("RETR " + i);//提示服务器要接收的邮件
                output.flush();

                StringBuilder receive = new StringBuilder();
                String tempStr;
                while (true) {
                    tempStr = input.readLine();
                    receive.append("\r\n");
                    receive.append(tempStr);
                    if (tempStr.equals(".")) {//接受完一个邮件
                        break;
                    }
                }
                //处理刚刚接收的邮件
                //System.out.println(receive.toString());
                getMails.putMail(MailStringDeal.process(receive.toString()));
            }

            //提示邮件服务器接收已经完成
            output.println("quit");
            output.flush();
            //服务器回应
            System.out.println(input.readLine());


            socket.close();
            input.close();
            output.close();
            System.out.println("接收邮件完成");

        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getMails;

    }
}