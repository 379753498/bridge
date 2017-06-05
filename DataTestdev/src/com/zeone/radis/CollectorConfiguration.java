package com.zeone.radis;

import java.util.ArrayList;
import java.util.List;

import com.zeone.lifeline.collector.conf.Configuration;
import com.zeone.lifeline.collector.conf.KeyValue;
import com.zeone.lifeline.collector.util.StringUtil;

public class CollectorConfiguration extends Configuration{
	private String cache = "redis";
	private String hosts,host = "10.5.4.3";
	private String password;
	private int port = 6379;
//	private int timeout;
	
	public CollectorConfiguration(){
		super.props.put(DEFAULT_SECTION, new ArrayList<KeyValue>());
		List<KeyValue> cache_props = new ArrayList<KeyValue>();
		super.props.put(Configuration.SEC_CACHE,cache_props);
		cache_props.add(new KeyValue("cache", this.cache));
		if (StringUtil.isNullOrEmpty(this.hosts)) {
			cache_props.add(new KeyValue("host", this.host));
			cache_props.add(new KeyValue("port", String.valueOf(this.port)));
			cache_props.add(new KeyValue("password", this.password));
			//cache_props.add(new KeyValue("timeout", String.valueOf(this.timeout)));
		} else {
			cache_props.add(new KeyValue("hosts", this.hosts));
		}
	}
}
