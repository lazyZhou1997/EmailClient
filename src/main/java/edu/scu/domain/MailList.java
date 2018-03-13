package edu.scu.domain;

import edu.scu.domain.GetMailInfo;

import java.util.LinkedList;

/**
 * 列表用于保存收到的邮件信息
 *
 * @author 周秦春
 * @date 2017-11-30
 */
public class MailList {

    LinkedList<GetMailInfo> mails;

    /**
     * 构造函数，创建一个邮件列表
     */
    public MailList() {
        mails = new LinkedList<GetMailInfo>();
    }

    /**
     * 放入一个邮件信息对象到邮件列表末尾
     *
     * @param mail 要存储的邮件信息对象
     */
    public void putMail(GetMailInfo mail) {
        mails.push(mail);
    }

    /**
     * 移除邮件链表的第一个邮件信息对象，并且返回该邮件信息对象
     *
     * @return 列表中的第一个邮件信息对象
     */
    public GetMailInfo getMail() {
        return mails.pop();
    }

    /**
     * 返回当前列表中存储的邮件信息对象个数
     *
     * @return 当前存储的邮件信息对象个数
     */
    public int mailCount() {
        return mails.size();
    }
}