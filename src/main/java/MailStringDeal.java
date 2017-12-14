/**
 * 对收到的邮件服务器的字符串进行简单处理
 * @author 周秦春
 * @date 2017-12-10
 */
public class MailStringDeal {
    /**
     * 对收到的邮件内容字符串进行简单的处理
     *
     * @param input
     * @return
     */
    public static GetMailInfo process(String input) {
        GetMailInfo getMailInfo = new GetMailInfo();

        int startIndex = 0;//起始处
        int offsite = 0;//偏移量
        int endIndex = 0;//结束处索引

        //临时字符串
        String tempString;

        //获取发件人邮件地址
        startIndex = input.indexOf("\nFrom:", 0);
        endIndex = input.indexOf("\nTo:", 0);
        tempString = input.substring(startIndex + "\nFrom:".length(), endIndex);
        if (tempString.contains("<")) {
            startIndex = tempString.indexOf("<");
            endIndex = tempString.indexOf(">");
            getMailInfo.setReceived_from(tempString.substring(startIndex + 1, endIndex).trim());
        } else {
            getMailInfo.setReceived_from(tempString.trim());
        }

        //获取收件人地址
        startIndex = input.indexOf("\nTo:", 0);
        endIndex = input.indexOf("\n", startIndex + "\nTo:".length());
        tempString = input.substring(startIndex + "\nTo:".length(), endIndex);
        if (tempString.contains("<")) {
            startIndex = tempString.indexOf("<");
            endIndex = tempString.indexOf(">");
            getMailInfo.setMailAddress(tempString.substring(startIndex + 1, endIndex).trim());
        } else {
            getMailInfo.setMailAddress(tempString.trim());
        }

        startIndex = input.indexOf("Subject:", endIndex);
        if (startIndex == -1) {
            startIndex = input.indexOf("subject:", endIndex);
        }
        offsite = "Subject:".length();
        endIndex = input.indexOf("\r\n", startIndex + offsite);
        //获取邮件主题
        getMailInfo.setSubject(input.substring(startIndex + offsite, endIndex));

        //获取邮件内容
        getMailInfo.setContent(input.substring(endIndex + 2, input.length() - 3));

        //返回处理结果
        return getMailInfo;
    }

}