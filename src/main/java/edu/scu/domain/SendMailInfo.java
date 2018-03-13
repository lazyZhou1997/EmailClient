package edu.scu.domain;

/**
 * 用于保存用户的登录信息
 *
 * @author 周秦春
 * @date 2017-11-17
 */
public class SendMailInfo {

    private String serverHost;//邮件服务器地址
    private int serverPort = 25;//SMTP默认端口
    private String mail_from;//邮件发送方账户地址
    private String password;//邮件发送方账户密码
    private String rcpt_to;//邮件接收方账户地址
    private String subject;//邮件主题
    private String content;//邮件内容

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

    public String getMail_from() {
        return mail_from;
    }

    public void setMail_from(String mail_from) {
        this.mail_from = mail_from;
    }

    public String getRcpt_to() {
        return rcpt_to;
    }

    public void setRcpt_to(String rcpt_to) {
        this.rcpt_to = rcpt_to;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
