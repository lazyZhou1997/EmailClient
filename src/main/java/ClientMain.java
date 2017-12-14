import java.util.Scanner;

/**
 * 邮件客户端启动部分，接收用户的选择，启动相应功能
 *
 * @author 周秦春
 * @date 2017-11-10
 */
public class ClientMain {
    public static void main(String args[]) {
        Scanner stdinScanner = new Scanner(System.in);

        exit:
        while (true) {
            System.out.println("输入\"s\"或者\"S\"发送文件，输入\"r\"或者\"R\"接受文件\n" +
                    "输入\"q\"或者\"Q\"来结束程序。");
            //获取用户输入
            String input = stdinScanner.nextLine();
            //启动用户选择的功能
            switch (input.toLowerCase()) {
                case "s":
                    //发送邮件功能
                    SendMailLogc sendMailLogc = new SendMailLogc();
                    sendMailLogc.start();
                    break;
                case "r":
                    //接收邮件功能
                    GetMailLogc getMailLogc = new GetMailLogc();
                    getMailLogc.start();
                    break;

                case "q":
                    //GOTO跳出循环，退出程序
                    break exit;
                default:
                    break;
            }
        }
        stdinScanner.close();
    }

}