package com.util.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.clinte.page.clintebean;
import com.clinte.page.clitebeaninit;
import com.ping.page.Ping;
import com.vpn.page.vpn;

public class uitltest {

	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException {
		
		clitebeaninit la=new clitebeaninit();
		uitltest te=new uitltest();
		te.test(la.ls);
	}
	
	public void test(ArrayList<clintebean>  ls) throws IOException
	{
	 for (clintebean clintebean : ls) { 
		
		 if(clintebean.getIsvpn().equals("yes"))
		 {
			 continue;
//			 vpn.connectVPN("VPN", "hfyd", "hfyd");
//			 Ping p = new Ping();
//			if( p.pingtest(clintebean.getIp())){
//				StringBuffer sb= new StringBuffer();
//				sb.append(clintebean.getBridgename()+"\t");
//				sb.append(clintebean.getGrataynamee()+"\t");
//				sb.append(clintebean.getIsvpn()+"\t");
//				sb.append(new Date()+"\t");
//				sb.append("ping测试成功"+"\n");
//				
//				System.out.println(sb.toString());
//				
//			}
//			else
//			{
//				StringBuffer sb= new StringBuffer();
//				sb.append(clintebean.getBridgename()+"\t");
//				sb.append(clintebean.getGrataynamee()+"\t");
//				sb.append(clintebean.getIsvpn()+"\t");
//				sb.append(new Date()+"\t");
//				sb.append("ping测试失败"+"\n");
//				
//				System.out.println(sb.toString());
//			}
//			vpn.disconnectVPN("VPN");
		 }
		 else {
			 
			 		Ping p = new Ping();
				if( p.pingtest(clintebean.getIp()))
				{
					StringBuffer sb= new StringBuffer();
					sb.append(clintebean.getBridgename()+"\t");
					sb.append(clintebean.getIp()+"\t");
					sb.append(clintebean.getGrataynamee()+"\t");
					sb.append(clintebean.getIsvpn()+"\t");
					sb.append(new Date()+"\t");
					sb.append("ping测试成功"+"\n");
					
					System.out.println(sb.toString());
					
				}
				else
				{
					StringBuffer sb= new StringBuffer();
					sb.append(clintebean.getBridgename()+"\t");
					sb.append(clintebean.getIp()+"\t");
					sb.append(clintebean.getGrataynamee()+"\t");
					sb.append(clintebean.getIsvpn()+"\t");
					sb.append(new Date()+"\t");
					sb.append("ping测试失败"+"\n");
					
					System.out.println(sb.toString());
				}
				
			 
		 }
		 
		 
		 
	}
		
	}
	
	
}
