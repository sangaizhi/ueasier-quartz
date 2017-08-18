package cn.zyunc.ueasier.quartz.test.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.zyunc.ueasier.quartz.test.service.OrderService;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
@Component
public class TestExecutor {

	@Autowired
	private OrderService orderService;

	public void execute() {
		orderService.readAndSaveFromFile("C:\\Users\\Admin\\Desktop\\testFile.txt");
	}

}
