package SendMail;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Main {
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "379753498@qq.com";
    public static String myEmailPassword = "Xj301012";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.qq.com";

    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "xujian_anhui@gsafety.com";

    public static void main(String[] args) throws Exception {
    	  Properties props = init();

          Session session = Session.getInstance(props);

//          Send(session, myEmailAccount);
    }

	public static void Send(Session session ,String BT ,StringBuilder builder ,Address Address[]) throws MessagingException,
			AddressException, NoSuchProviderException {
			Message msg = new MimeMessage(session);
          msg.setSubject("seenews 错误");
          StringBuilder builder1 = new StringBuilder();
          builder1.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
          builder1.append("\n页面爬虫错误");
          builder1.append("\n时间 " + new Date());
          msg.setText(builder1.toString());
          msg.setFrom(new InternetAddress(myEmailAccount));

          Transport transport = session.getTransport();
          transport.connect("smtp.qq.com", myEmailAccount, "schbywtiboembijd");

          transport.sendMessage(msg, Address );
          transport.close();
	}

	public static Properties init() throws GeneralSecurityException {
		Properties props = new Properties();

          // 开启debug调试
          props.setProperty("mail.debug", "true");
          // 发送服务器需要身份验证
          props.setProperty("mail.smtp.auth", "true");
          // 设置邮件服务器主机名
          props.setProperty("mail.host", "smtp.qq.com");
          // 发送邮件协议名称
          props.setProperty("mail.transport.protocol", "smtp");

          MailSSLSocketFactory sf = new MailSSLSocketFactory();
          sf.setTrustAllHosts(true);
          props.put("mail.smtp.ssl.enable", "true");
          props.put("mail.smtp.ssl.socketFactory", sf);
		return props;
	}

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "某宝网", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject("打折钜惠", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent("XX用户你好, 今天全场5折, 快来抢购, 错过今天再等一年。。。", "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

}
