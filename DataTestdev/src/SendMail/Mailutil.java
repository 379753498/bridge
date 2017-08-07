package SendMail;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;
import com.zeone.bean.MialBean;
import com.zeone.data.databiud;
import com.zeone.lifeline.collector.util.DateUtil;






public class Mailutil {
	
	public static final String tdBegin="<td border="+"1"+">";
	public static final String tdEnd="</td border="+"1"+">";
	public static final String tRBegin="<tr>";
	public static final String tREnd="</tr>";
	public static final String tHBegin="<th border="+"1"+">";
	public static final String tHEnd="</th border="+"1"+">";
	// 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）, 
    //     对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = "379753498@qq.com";
    public static String myEmailPassword = "auphktzmvbfncbba";

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = "smtp.qq.com";

    // 收件人邮箱（替换为自己知道的有效邮箱）
    public static String receiveMailAccount = "xujian_anhui@gsafety.com";

  

	public static void Send(Session session ,MimeMessage msg  ,Address Address[]) throws MessagingException,
		AddressException, NoSuchProviderException {
			msg.setRecipients(MimeMessage.RecipientType.TO, Address);
          Transport transport = session.getTransport();
          transport.connect(myEmailSMTPHost, myEmailAccount, myEmailPassword);
          transport.sendMessage(msg, Address );
          transport.close();
	}

	public static Session Sessioninit() throws GeneralSecurityException {
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
          
          Session session = Session.getInstance(props);

		return session;
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
    public static MimeMessage createMimeMessage(Session session ,ArrayList<MialBean> ls) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(myEmailAccount, "徐健", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//        message.setRecipients(MimeMessage.RecipientType.TO, Address);

        // 4. Subject: 邮件主题
        message.setSubject("桥梁自动监测系统数据中断提示邮件"+DateUtil.format(new Date(),	"yyyy-MM-dd HH:mm:ss"), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(getContent(ls).toString(), "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

    
    
    
    public static MimeMessage createMimeMessages(Session session ,ArrayList<databiud> datatest, String date) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(myEmailAccount, "徐健", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
//        message.setRecipients(MimeMessage.RecipientType.TO, Address);

        // 4. Subject: 邮件主题
        message.setSubject("关于"+date+"桥梁历史数据检测分析结果"+"----"+DateUtil.format(new Date(),	"yyyy-MM-dd HH:mm:ss")+"检测完成", "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(getContentx(datatest).toString(), "text/html;charset=UTF-8");
        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }

    
    
    
    public static StringBuffer getContent(ArrayList<MialBean> ls)
    {
    	StringBuffer sb= new StringBuffer();
    	sb.append("<html>");
    	sb.append("<body>");
    	
    	sb.append("下表是来自于自动监测系统监测的实时数据 请尽快处理中断情况");
    	
    	sb.append("<table border="+"1"+">");
    	
    	sb.append("<tr>");
		sb.append("<th border="+"1"+">");
		sb.append("桥梁名称");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("传感器名称");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("模块号");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("通道号");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("最后一条数据时间");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("最后一条数据值");
		sb.append("</th border="+"1"+">");
		sb.append("<th border="+"1"+">");
		sb.append("累计中断时间");
    	sb.append("</th border="+"1"+">");    	 		
    	sb.append("</tr>");
    	for (MialBean mialBean : ls) {
    		
    		sb.append("<tr>");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getSensorData().getBridgename());
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getSensorData().getEquipmentname());
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getSensorData().getModularnum());
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getSensorData().getPathnum());
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(DateUtil.format(new Date(mialBean.getHistory()),"yyyy-MM-dd HH:mm:ss"));
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getVaule());
    		sb.append("</td border="+"1"+">");
    		sb.append("<td border="+"1"+">");
    		sb.append(mialBean.getPassString());
    		sb.append("</td border="+"1"+">");    	 		
    		sb.append("</tr>");
		}
    	
    	
    	
    	
    	sb.append("</table>");
    	sb.append("</body>");
    	sb.append("</html>");
    	
		return sb;
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    public static StringBuffer getContentx(ArrayList<databiud> datatest)
    {
    	StringBuffer sb= new StringBuffer();
    	sb.append("<html>");
    	sb.append("<body>");
    	
    	sb.append("下表是来历史分析系统分析结果请查阅、详细资料可向我索要");
    	
    	sb.append("<table border="+"1"+">");
    	
    	
    	sb.append(Mailutil.tRBegin);
    	sb.append(Mailutil.tHBegin);
    	sb.append("桥梁名称");
    	sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("传感器名称");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("传感器类型");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("模块号");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("通道号");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("实际数据行数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("理论数据行数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("理论频率");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("错误频率数" );
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("错误频率占比");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("中断数据次数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("累计中断时间");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("累计中断时间占比");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("重复数据个数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("重复数据占比" );
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("超出量程范围数据个数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("超出量程范围数据占比");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("数据接收异常数据总数");
		sb.append(Mailutil.tHEnd);
    	sb.append(Mailutil.tHBegin);
		sb.append("数据接收异常数据总数占比");
		sb.append(Mailutil.tHEnd);
		sb.append(Mailutil.tREnd);
    
    	for (databiud databiud : datatest) {
    		sb.append(Mailutil.tRBegin);
    		sb.append(Mailutil.tdBegin);
    		sb.append(databiud.getBridgename());
    		sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getEquipmentname());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getLeixing());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getModularnum());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getPathnum());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getFilerow());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getLilunfilerow());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getLilunpl());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getPl());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getCuowuPLzhanbi());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getZhongduanshuju());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getZhongduanshijian());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getLeijizhongduanshijianzhanbi());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getChongfushujugeshu());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getChongfushujzhanbi());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getChaochuliangchenggeshu());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getChaochuliangchengfanweizhanbi());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getShujujieshoushijianyichangzongshu());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdBegin);
			sb.append(databiud.getJieshouyichangzongshuzhanbi());
			sb.append(Mailutil.tdEnd);
    		sb.append(Mailutil.tdEnd);
		}
    	    	    	    	
    	sb.append("</table>");
    	sb.append("</body>");
    	sb.append("</html>");
    	
		return sb;
    	
    	
    	
    }
    
    
    public static Address[] getAddress() throws UnsupportedEncodingException
    {
    	Address[] addre = new Address[1];
    	
    	
    	addre[0]=new InternetAddress("xujian_anhui@gsafety.com",  "UTF-8");
		return addre;
    	
    	
    }
    
    public static Address[] getAddres() throws UnsupportedEncodingException
    {
    	Address[] addre = new Address[1];
    	
    	
    	addre[0]=new InternetAddress("379753498@qq.com",  "UTF-8");
		return addre;
    	
    	
    }
    
    
    public static Address[] getoneAddress() throws UnsupportedEncodingException
    {
    	Address[] addre = new Address[1];
    	
    	addre[0]=new InternetAddress("xujian_anhui@gsafety.com", "徐健", "UTF-8");
//    	addre[1]=new InternetAddress("chuzhujun@gsafety.com", "储著钧", "UTF-8");
//    	addre[2]=new InternetAddress("huangzhuanzhuan@gsafety.com", "黄转转", "UTF-8");
//    	addre[3]=new InternetAddress("fuming@gsafety.com", "fuming", "UTF-8");
//    	addre[4]=new InternetAddress("huangwenshi@gsafety.com",  "黄文实","UTF-8");
//    	addre[5]=new InternetAddress("zhangxiaoxia@gsafety.com", "张老师", "UTF-8");
//    	addre[6]=new InternetAddress("chengxueming@gsafety.com", "程学明", "UTF-8");
//    	addre[7]=new InternetAddress("wangshouren@gsafety.com", "首长", "UTF-8");
//    	addre[8]=new InternetAddress("yuxiaolong@gsafety.com", "yuxiaolong", "UTF-8");
//    	addre[9]=new InternetAddress("wanglijuan@gsafety.com", "wanglijuan", "UTF-8");
		return addre;
    	
    	
    }
}
