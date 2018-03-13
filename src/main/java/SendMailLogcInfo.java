import edu.scu.connection.SendMailTemple;
import edu.scu.domain.SendMailInfo;

import java.util.Scanner;

/**
 * 发送邮件时对服务器登录所需要的数据进行获取和解析
 *
 * @author 周秦春
 * @date 2017-11-17
 */
public class SendMailLogcInfo {
    public void start() {
        @SuppressWarnings("resource")
        Scanner stdinScanner = new Scanner(System.in);

        //构建对象保存发送服信息
        SendMailInfo sendMailInfo = new SendMailInfo();

        //获取用户邮件服务器账号
        System.out.println("请输入发件邮件账户：");
        sendMailInfo.setMail_from(stdinScanner.nextLine());

        //获取用户邮件服务器密码
        System.out.println("请输入发件账户密码：");
        sendMailInfo.setPassword(stdinScanner.nextLine());

        //获取收件邮件服务器账号
        System.out.println("请输入收件邮件账户：");
        sendMailInfo.setRcpt_to(stdinScanner.nextLine());

        //解析用户邮件服务器SMTP_HOST
        String temp[] = sendMailInfo.getMail_from().split("@");
        //设置用户邮件服务器SMTP_HOST
        sendMailInfo.setServerHost("smtp." + temp[1]);

        //设置SMTP默认端口25
        sendMailInfo.setServerPort(25);

        //获取用户邮件信息
        System.out.println("请输入邮件主题：");
        sendMailInfo.setSubject(stdinScanner.nextLine());

        //获取用户邮件信息
        System.out.println("请输入邮件内[以##DONE结束]：");
        StringBuilder tempStr = new StringBuilder();
        String tempStr1;
        while (true) {
            tempStr1 = stdinScanner.nextLine();
            if (tempStr1.equals("##DONE")) {
                break;
            }
            tempStr.append(tempStr1);
        }
        sendMailInfo.setContent(tempStr.toString());

        System.out.println("正在发送！");

        //发送邮件操作
        if (SendMailTemple.sendmail(sendMailInfo)) {
            //发送成功
            System.out.println("邮件发送成功！");
        }

    }

}