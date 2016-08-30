package com.runrong.managecenter.business.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.runrong.managecenter.business.aop.CheckPermission;
import com.runrong.managecenter.business.service.AdminGroupService;
import com.runrong.managecenter.business.service.AdminService;
import com.runrong.managecenter.business.service.PermissionService;
import com.runrong.managecenter.business.service.UserService;
import com.runrong.managecenter.config.RSAConfig;
/**
 * 界面控制层
 * @author yanyimin
 *
 */
@Controller
@RequestMapping("/managecenter")
public class RouteController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PermissionService permissionService;
	
	@Autowired
	AdminGroupService adminGroupService;
	
	/**
	 * 登录界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/login")
	@ResponseBody
	public ModelAndView login(HttpServletRequest request,ModelMap map) throws ParseException{		
		//RandomCodeHelper.setVerifyCodeInSession(request);
		map.put("modulus",RSAConfig.modulus);
		map.put("exponent", RSAConfig.exponent);
		return new ModelAndView("/managecenter/login");
	}
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getVerifyCode")
	public ModelAndView getCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
				
		String randomCode = (UUID.randomUUID().toString()).substring(0, 4);
		request.getSession().setAttribute("verifyCode", randomCode);
		Date date =new Date();
    	//验证码创建时间
		request.getSession().setAttribute("verifyCodeCreateTime", new Timestamp(date.getTime()));
    	
		response.setContentType("image/jpeg"); // 因为向客户端发送的内容是图片. 所以用这种内容类型

		int width = 78;
		int height = 34;
		// 1.创建一个图片对象
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);

		// 2.得到画布
		Graphics graphics = image.getGraphics();

		// 3.开始在图片上画画

		// 3.1 用白色填充. 首先要设置上下文的颜色
		graphics.setColor(Color.white);// 设置白色
		graphics.fillRect(1, 1, width - 2, height - 2);

		// 3.2 用黑色写文字
		graphics.setColor(Color.black);
		graphics.setFont(new Font("宋体", Font.BOLD, 30));
		graphics.drawString(randomCode, width / 12, height / 2 + 5);
		// 3.3 画混淆内容
		graphics.setColor(Color.red);
		for (int i = 0; i < 20; i++) {
			graphics.fillOval(new Random().nextInt(width),
					new Random().nextInt(height), 3, 3);
		}
		for (int i = 0; i < 5; i++) {
			graphics.setColor(new Color[] { Color.red, Color.blue, Color.GRAY }[new Random()
					.nextInt(3)]);
			graphics.drawLine(new Random().nextInt(width),
					new Random().nextInt(height), new Random().nextInt(width),
					new Random().nextInt(height));
		}

		// 4.关闭画布,释放资源...
		graphics.dispose();
		// 输出图片

		ImageIO.write(image, "JPG", response.getOutputStream());
		
		return null;
	}
	
	/**
	 * 管理员界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/admin")
	@ResponseBody
	@CheckPermission
	public ModelAndView admin(HttpServletRequest request,ModelMap map) throws ParseException{
				
		List list=(List) adminService.getAdministrator(request).getBody();
		
		map.put("list", list);
		return new ModelAndView("/managecenter/admin");
	}
	
	

	/**
	 * 用户界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/user")
	@ResponseBody
	@CheckPermission
	public ModelAndView user(HttpServletRequest request,ModelMap map) throws ParseException{
				
		List list=(List) userService.getUser(request).getBody();
		
		map.put("list", list);
		return new ModelAndView("/managecenter/user");
	}
	
	
	/**
	 * 资产负债表界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/balancestatement")
	@ResponseBody
	public ModelAndView balancestatement(HttpServletRequest request,ModelMap map) throws ParseException{
					
		return new ModelAndView("/managecenter/balancestatement");
	}

	/**
	 * 现金流量表界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/cashflowstatement")
	@ResponseBody
	public ModelAndView cashflowstatement(HttpServletRequest request,ModelMap map) throws ParseException{
					
		return new ModelAndView("/managecenter/cashflowstatement");
	}
	
	/**
	 * 利润表界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/profitstatement")
	@ResponseBody
	public ModelAndView profitstatement(HttpServletRequest request,ModelMap map) throws ParseException{
					
		return new ModelAndView("/managecenter/profitstatement");
	}
	
	/**
	 * 查找表界面
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/findstatement")
	@ResponseBody
	public ModelAndView findstatement(HttpServletRequest request,ModelMap map) throws ParseException{
					
		return new ModelAndView("/managecenter/findstatement");
	}	
	
	/**
	 * 管理组权限界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminGroupPermission")
	@ResponseBody
	public ModelAndView adminGroupPermission(HttpServletRequest request,ModelMap map){
		List adminGroupList =(List)adminGroupService.getAdminGroup(request).getBody();
		List list=(List) permissionService.getPermission(request).getBody();
		map.put("adminGroupList",adminGroupList);
		map.put("list", list);
		return new ModelAndView("/managecenter/adminGroupPermission");
	}
}
