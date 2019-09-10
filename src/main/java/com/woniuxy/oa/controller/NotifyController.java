package com.woniuxy.oa.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Notify;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.service.NotifyService;

/**
 *	通知公告模块控制器
 * @author ChaoX
 *
 */
@Controller
public class NotifyController {
	
	@Autowired
	NotifyService notifyService;
	
	/**
	 * 	查询数据库获取所有收信人
	 *  @return
	 */
	@GetMapping("/findAllUser")
	public ModelAndView getAllUsers() {
		List<User> users = notifyService.findAllUsers();
		ModelAndView mav = new ModelAndView("forward:/noticeAdd");
		mav.addObject("users", users);
		return mav;
	}
	
	/**
	 * 	将通知存入数据库并实现页面转发至我的通知
	 * @param title
	 * @param content
	 * @param recipinet
	 * @param senderid
	 * @param file(最大为10MB)
	 * @return
	 */
	@PostMapping("/doNotifyAdd")
	public String doNotify(String title, String content, String edescribe, int[] recipinet, int senderid, MultipartFile file, HttpSession session) {
		String filepath = null;
		String filename = null;
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timestamp = simpleDateFormat.format(currentDate);
		User user = (User) session.getAttribute("user");
		if(!file.isEmpty()) {
			filepath = ("E:\\WoniuOA\\FileUpload\\");
			filename = timestamp+"-"+user.getUname()+"-"+file.getOriginalFilename();
			try {
				file.transferTo(new File(filepath, filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for (int rec : recipinet) {
			notifyService.insertNotify(title, content, edescribe, filepath, filename, rec, senderid);
		}
		return "redirect:/noticeMy";
	}
	
	/**
	 * 	我发布的公告
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMySendNotifys/{pageNum}")
	public Map<String, Object> getMySendNotifys(@PathVariable("pageNum") int pageNum, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		User user = (User) session.getAttribute("user");
		PageHelper.startPage(pageNum, 10);
		List<String> unames = new ArrayList<String>();
		List<Notify> mySendNotifys = notifyService.findMySendNotifys(user.getUid());
		PageInfo<Notify> pageInfo = new PageInfo<Notify>(mySendNotifys);
		for (Notify msn : pageInfo.getList()) {
			int receiverid = msn.getReceiverid();
			String uname = notifyService.findUnameByUid(receiverid);
			unames.add(uname);
		}
//		map.put("msns", mySendNotifys);
		map.put("unames", unames);
		map.put("page", pageInfo);
		return map;
	}
	
	/**
	 * 	我接收的公告
	 * @param session
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getMyReciveNotifys/{pageNum}")
	public Map<String, Object> getMyReciveNotifys(@PathVariable("pageNum") int pageNum, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		User user = (User) session.getAttribute("user");
		PageHelper.startPage(pageNum, 10);
		List<Notify> myReciveNotifys = notifyService.findMyReciveNotifys(user.getUid());
		PageInfo<Notify> pageInfo = new PageInfo<Notify>(myReciveNotifys);
		List<String> unames = new ArrayList<String>();
		for (Notify mrn : pageInfo.getList()) {
			int senderid = mrn.getSenderid();
			String uname = notifyService.findUnameByUid(senderid);
			unames.add(uname);
		}
//		map.put("mrns", myReciveNotifys);
		map.put("unames", unames);
		map.put("page", pageInfo);
		return map;
	}
	
	/**
	 * 	修改通知详情页数据显示
	 * @param id tb_notify主键
	 * @return
	 */
	@GetMapping("/noticeDetail/{id}")
	public ModelAndView getNoticeDetail(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("forward:/noticeDetail");
		Notify notify = notifyService.findNotifyById(id);
		String senderName = notifyService.findUnameByUid(notify.getSenderid());
		String receiverName = notifyService.findUnameByUid(notify.getReceiverid());
		mav.addObject("notifyDetail", notify);
		mav.addObject("sn",senderName);
		mav.addObject("rn", receiverName);
		return mav;
	}
	
	@GetMapping("/noticeDetailReadOnly/{id}")
	public ModelAndView getNoticeDetailReadOnly(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("forward:/noticeDetailReadOnly");
		Notify notify = notifyService.findNotifyById(id);
		String senderName = notifyService.findUnameByUid(notify.getSenderid());
		String receiverName = notifyService.findUnameByUid(notify.getReceiverid());
		mav.addObject("notifyDetail", notify);
		mav.addObject("sn",senderName);
		mav.addObject("rn", receiverName);
		return mav;
	}
	
	/**
	 * 	在未审批状态下撤回发布的通知
	 * @param id
	 * @return
	 */
	@GetMapping("/noticeRecall/{id}")
	public String recallNotity(@PathVariable("id") int id) {
		notifyService.recallNotifyById(id);
		return "redirect:/noticeMy";
	}
	
	/**
	 * 	修改通知后跳转至我的通知
	 * @param id tb_notify主键
	 * @param title
	 * @param content
	 * @param realName 发布人姓名
	 * @param recipinet 接收人姓名
	 * @param file
	 * @return
	 */
	@PostMapping("/updateNotify")
	public String updateNoticy(int id,String title,String content,String realName,String recipinet,MultipartFile file,HttpSession session) {
		String filepath = null;
		String filename = null;
		Date currentDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timestamp = simpleDateFormat.format(currentDate);
		User user = (User) session.getAttribute("user");
		if(!file.isEmpty()) {
			filepath = ("E:\\WoniuOA\\FileUpload\\");
			filename = timestamp+"-"+user.getUname()+"-"+file.getOriginalFilename();
			try {
				file.transferTo(new File(filepath, filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int receiverid = notifyService.findselectReceiveridByRealname(recipinet);
		int senderid = notifyService.findSenderidByRecipinet(realName);
		notifyService.modifyNotifyById(title, content, filepath, filename, receiverid, senderid, id);
		return "redirect:/noticeMy";
	}
	
	/**
	 * 	返回所有未审核的数据到页面
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getUncheckedNotifys/{pageNum}")
	public Map<String, Object> getUncheckedNotifys(@PathVariable("pageNum") int pageNum) {
		Map<String, Object> map = new HashMap<>();
		PageHelper.startPage(pageNum, 10);
		List<Notify> uncheckedNotifys = notifyService.findUncheckedNotifys();
		PageInfo<Notify> pageInfo = new PageInfo<Notify>(uncheckedNotifys);
		List<String> unames = new ArrayList<String>();
		List<String> runames = new ArrayList<String>();
		for (Notify un : pageInfo.getList()) {
			int senderid = un.getSenderid();
			int receiverid = un.getReceiverid();
			String uname = notifyService.findUnameByUid(senderid);
			String runame = notifyService.findUnameByUid(receiverid);
			unames.add(uname);
			runames.add(runame);
		}
//		map.put("uns", uncheckedNotifys);
		map.put("unames", unames);
		map.put("runames", runames);
		map.put("page", pageInfo);
		return map;
	}
	
	/**
	 * 	更新审批状态
	 * @param asid
	 * @param id
	 * @return
	 */
	@GetMapping("/updateNotifyState/{id}/{asid}")
	public String updateNotifyState(@PathVariable("asid") int asid, @PathVariable("id") int id) {
		notifyService.modifyNotifyStateById(asid, id);
		return "redirect:/noticeExamin";
	}
	
	/**
	 * 	文件下载
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("/downloadFile/{id}")
	public ModelAndView downloadFile(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("forward:/noticeDetail");
		Notify notify = notifyService.findNotifyById(id);
		
		String fileName = notify.getNfilename();// 文件名
		String filePath = notify.getNfilepath();//文件路径
		System.out.println(filePath);
        if (fileName != null) {
            //设置文件路径
            //File file = new File("/Users/dalaoyang/Documents/dalaoyang.jpeg");
            File file = new File(filePath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));// 设置文件名，解决中文编码问题
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    mav.addObject("downloadmsg", "下载成功" );
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        mav.addObject("downloadmsg", "下载失败" );
		
		return mav;
	}
}
