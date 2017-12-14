import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

/**
 * 进行发送邮件的类
 *
 * @author 周秦春
 * @date 2017-11-15
 */
public class SendMailTemple {


    /**
     * 传入邮件信息，进行邮件发送
     * @param sendMailInfo 要发送的邮件信息
     * @return 返回true为发送成功，返回false为发送失败
     */
    public static boolean sendmail(SendMailInfo sendMailInfo) {
        boolean sendResult = false;

        try {
            //连接邮件服务器
            Socket socket = new Socket(sendMailInfo.getServerHost(), sendMailInfo.getServerPort());
            //获取与邮件服务器的输入输出流
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket
                    .getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));
            System.out.println(input.readLine());

            //打招呼
            output.println("HELO 163");
            output.flush();
            System.out.println(input.readLine());

            //验证登陆
            output.println("auth login");
            output.flush();
            System.out.println(input.readLine());

            //用户名
            output.println(new BASE64Encoder().encode(sendMailInfo.getMail_from().getBytes()));
            output.flush();
            System.out.println(input.readLine());

            //密码
            output.println(new BASE64Encoder().encode(sendMailInfo.getPassword().getBytes()));
            output.flush();

            //发件人
            output.println("mail from:<" + sendMailInfo.getMail_from() + ">");
            output.flush();
            System.out.println(input.readLine());

            //收件人
            output.println("rcpt to:<" + sendMailInfo.getRcpt_to() + ">");
            output.flush();
            System.out.println(input.readLine());

            //内容
            output.println("data");
            output.flush();
            System.out.println(input.readLine());
            String con = "From:" + sendMailInfo.getMail_from() + "\r\n";
            con += "To: " + sendMailInfo.getRcpt_to() + "\r\n";
            con = con + "Subject:" + sendMailInfo.getSubject() + "\r\n";
            con = con + "Content-Type: text/plain;charset=\"utf-8\"\r\n";
            con = con + "\r\n";
            con = con + sendMailInfo.getContent() + "\r\n";
            con = con + ".\r\n";

            //开始发送邮件
            output.print(con);
            output.flush();

            System.out.println(input.readLine());

            //结束邮件发送
            output.println("quit");
            output.flush();
            System.out.println(input.readLine());


            socket.close();
            input.close();
            output.close();

        } catch (ConnectException e) {
            System.out.println("connectException");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sendResult;
    }
}