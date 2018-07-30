package cn.shuhe.common;

import cn.shuhe.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserContent {
	
	public static final String USER_IN_SESSION = "logininfo";

	/**
	 * 反向获取request的方法,请查看RequestContextListener.requestInitialized打包过程
	 * 
	 * @return
	 */
	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
	}

	public static void putCurrent(User current) {
		// 得到session,并把current放到session中
		getSession().setAttribute(USER_IN_SESSION, current);
	}

	public static User getCurrent() {
		return (User) getSession().getAttribute(USER_IN_SESSION);
	}

	
}