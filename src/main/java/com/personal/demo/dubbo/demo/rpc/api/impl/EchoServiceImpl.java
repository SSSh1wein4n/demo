
package com.personal.demo.dubbo.demo.rpc.api.impl;

import com.personal.demo.dubbo.demo.rpc.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

@Service(protocol = "dubbo")
class EchoServiceImpl implements EchoService {

	@Override
	public String echo(String message) {
		return "[echo] Hello, " + message;
	}

}
