import edu.scu.connection.GetMailTemple;
import edu.scu.domain.GetMailInfo;
import edu.scu.domain.MailList;

import java.io.*;
import java.util.Scanner;

/**
 * 收取邮件获取登录信息类
 *
 * @author 周秦春
 * @date 2017-11-25
 */
public class GetMailLogcInfo {

    private GetMailInfo getMailInfo;
//    private String storePath = "." + File.separator;

    public void start() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        //创建收邮件信息对象
        getMailInfo = new GetMailInfo();

        //获取账号
        System.out.println("请输入邮箱账号：");
        getMailInfo.setMailAddress(in.nextLine());

        //获取密码
        System.out.println("请输入账号密码：");
        getMailInfo.setPassword(in.nextLine());

        //解析出邮件服务器地址
        String temp[] = getMailInfo.getMailAddress().split("@");
        getMailInfo.setServerHost("pop." + temp[1]);

        //设置邮件服务器端口
        getMailInfo.setServerPort(110);

        MailList mails = GetMailTemple.getMail(getMailInfo);

        //对收取到的邮件进行处理
        int mailsCount = mails.mailCount();


        //写文件的流
        BufferedOutputStream bufferedOutputStream;
        for (int i = 0; i < mailsCount; i++) {

//                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(storePath + getMailInfo.getReceived_from() + getMailInfo.getSubject()+i));
            GetMailInfo getMailInfo = mails.getMail();
            System.out.println("=====================================================");
            System.out.println("||                                                  ||");
            System.out.println("                    第"+i+"封信件                      ");
            System.out.println("||                                                  ||");
            System.out.println("=====================================================");

            System.out.print("信件主题:");
            System.out.println(getMailInfo.getSubject());
//                bufferedOutputStream.write(getMailInfo.getSubject().getBytes());
            System.out.println("=====================================================");
            System.out.print("发信人:");
            System.out.println(getMailInfo.getReceived_from());
            System.out.println("=====================================================");

            System.out.println("邮件内容：");
            System.out.println(getMailInfo.getContent());
            System.out.println("======================邮件结束=========================");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }

    }
}