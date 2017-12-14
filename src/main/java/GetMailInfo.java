/**
 * 保存收件所需的信息
 *
 * @author 周秦春
 * @date 2017-11-10
 */
public class GetMailInfo {


    private String serverHost;
    private int serverPort;
    private String mailAddress;//收件人邮件地址
    private String password;
    private String received_from;//发件人邮件地址
    private String subject;
    private String content;

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceived_from() {
        return received_from;
    }

    public void setReceived_from(String received_from) {
        this.received_from = received_from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
}
