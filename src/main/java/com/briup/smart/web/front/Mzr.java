package com.briup.smart.web.front;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.taglibs.standard.tag.rt.fmt.BundleTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.smart.bean.Business;
import com.briup.smart.bean.Deliveryman;
import com.briup.smart.bean.ShowIncoming;
import com.briup.smart.mapper.UserOrderMapper3;
import com.briup.smart.service.BusinessService;
import com.briup.smart.service.DeliverymanService;
import com.github.pagehelper.PageInfo;


@Controller
public class Mzr {
	@Autowired
	private  BusinessService bservice;
	@Autowired
	private DeliverymanService dmservice;
	@Autowired
	private UserOrderMapper3 uomapper3;
	@RequestMapping("/shopping.do")
	public String test1(){
		System.out.println("访问成功");
		return "shopping";
	}
	@RequestMapping("/food.do")
	public String test2(){
		System.out.println("访问成功");
		return "food";
	}
	@RequestMapping("/goodsInfo.do")
	public String test3(){
		System.out.println("访问成功");
		return "goodsInfo";
	}
//	@RequestMapping("/dayIncoming.do")
//	public String dayIncoming(){
//		System.out.println("访问成功");
//		return "dayIncoming";
//	}
//	@RequestMapping("/monthIncoming.do")
//	public String test4(){
//		System.out.println("访问成功");
//		return "monthIncoming";
//	}
//	@RequestMapping("/yearIncoming.do")
//	public String test5(){
//		System.out.println("访问成功");
//		return "yearIncoming";
//	}
//	@RequestMapping("/searchDeliveryman.do")
//	public String deliverymanManage(){
//		System.out.println("访问成功--------------------------------");
//		return "searchDeliveryman";
//	}
	@RequestMapping("/addDeliveryman.do")
	public String test6(){
		System.out.println("访问成功");
		return "addDeliveryman";
	}
	
	@RequestMapping("/updateDeliveryman.do")
	public String addDeliveryman(){
		System.out.println("访问成功");
		return "updateDeliveryman";
	}
	@RequestMapping("/business/login")
	public String loginCheck(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		System.out.println("-------------------------");
		System.out.println("==========================="+account);
		bservice.login(account, password);
		if("boss".equals(account)){
           return "orders";
		}else {
		   return "food";
		}
	}
	@RequestMapping("/searchDeliveryman.do")
	public String showDeliveryman(HttpServletRequest request) {
	    List<Deliveryman>dmlist=dmservice.selectAllDeliveryman();
	    System.out.println(dmlist);
	    request.setAttribute("deliveryman",dmlist);
	    return "searchDeliveryman";
	}
	@RequestMapping("/pageInfoShowDeliveryman")
	public void pageInfoshowDeliveryman(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		String pNum = request.getParameter("pageNum");
		int pageNum = 1;
		if(pNum!=null&&!"".equals(pNum)) {
			pageNum = Integer.parseInt(pNum);
		}
		String pSize = request.getParameter("pageSize");
		int pageSize = 5;
		if(pSize!=null&&!"".equals(pSize)) {
			pageSize = Integer.parseInt(pSize);
		}
		PageInfo<Deliveryman> pageInfo = 
				dmservice.selectAllDeliveryman(pageNum, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		System.out.println(pageInfo);
		request.getRequestDispatcher(
				"searchDeliveryman").forward(request, response);
	}
	@RequestMapping("/dayIncoming.do")
	public String showDaliyIncoming(HttpServletRequest request) {
		List<ShowIncoming> dlist=uomapper3.getDailyIncomingByMonth();
		request.setAttribute("showIncoming", dlist);
		System.out.println(dlist);
	    return "dayIncoming";
	}
	@RequestMapping("/monthIncoming.do")
	public String showMonthlyIncoming(HttpServletRequest request) {
		List<ShowIncoming> dlist=uomapper3.getMonthlyIncomingByYear();
		request.setAttribute("showIncoming", dlist);
		System.out.println(dlist);
	    return "monthIncoming";
	}
	@RequestMapping("/yearIncoming.do")
	public String showYearlyIncoming(HttpServletRequest request) {
		List<ShowIncoming> dlist=uomapper3.getYearlyIncoming();
		request.setAttribute("showIncoming", dlist);
		System.out.println(dlist);
	    return "yearIncoming";
	}
}
