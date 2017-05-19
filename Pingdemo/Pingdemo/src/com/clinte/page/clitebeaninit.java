package com.clinte.page;

import java.util.ArrayList;

public class clitebeaninit {

	public static ArrayList<clintebean>  ls=new ArrayList<clintebean>(); 
	public clitebeaninit()
	{
		clintebean cl= new clintebean();
		cl.setBridgename("金寨高架-东流路口");
		cl.setGrataynamee("HF_JZDL_00000003");
		cl.setIp("192.168.2.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("金寨高架-习友路口");
		cl.setGrataynamee("HF_JZXY_00000006");
		cl.setIp("192.168.5.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("金寨高架-习友路口匝道");
		cl.setGrataynamee("HF_JZXY_00000007");
		cl.setIp("192.168.6.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("金寨高架-望江路口");
		cl.setGrataynamee("HF_JZWJ_00000002");
		cl.setIp("192.168.1.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("金寨高架-祁门路口");
		cl.setGrataynamee("HF_JZQM_00000005");
		cl.setIp("192.168.3.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("金寨高架-黄山路口");
		cl.setGrataynamee("HF_JZHS_00000001");
		cl.setIp("192.168.0.95");
		cl.setIsvpn("yes");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("G206立交桥");
		cl.setGrataynamee("HF_G206_00000001");
		cl.setIp("112.27.200.87");
		cl.setIsvpn("NO");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("环湖路南淝河大桥");
		cl.setGrataynamee("HF_HHDD_NFH_0001");
		cl.setIp("112.26.31.174");
		cl.setIsvpn("NO");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("派河大桥");
		cl.setGrataynamee("HF_PHDQ_00000001");
		cl.setIp("117.71.49.123");
		cl.setIsvpn("NO");
		ls.add(cl);
		cl= new clintebean();
		cl.setBridgename("繁华大道跨南淝河大桥");
		cl.setGrataynamee("HF_FHDD_DY000001");
		cl.setIp("112.27.204.6");
		cl.setIsvpn("NO");
		ls.add(cl);
		
	}
	
}
