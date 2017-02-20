package com.demo.springmvc.controller;

import com.demo.springmvc.controller.validation.ValidGroup1;
import com.demo.springmvc.exception.CustomException;
import com.demo.springmvc.po.ItemCustom;
import com.demo.springmvc.po.ItemQueryVo;
import com.demo.springmvc.po.Items;
import com.demo.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 2017-2-20 11:32:34
 * 商品查询添加查询条件：商品名称、价格范围
 * 添加商品功能开发
 * 删除商品功能开发
 * Created by 7 on 2017/2/9.
 */
@Controller
@RequestMapping("/item")
public class GoodController {

    //这两句代码的意思是获取itemService bean 同理与@Autowired
//	ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("springmvc/applicationContext-Service.xml");
//	itemService = (ItemService) applicationContext.getBean("itemService");
    //下面是通过注解获取bean
    @Autowired
    private ItemService itemService;

    /**
     * 查看所有的商品列表
     *
     * @return 模型和视图
     * @throws Exception
     */
    @RequestMapping(value = "/queryItem", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView queryItem() throws Exception {

//		//调用service查询商品列表
        List<ItemCustom> itemList = itemService.findItemsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemList);
//		System.out.println("xxx"+itemList);
        // 指定逻辑视图名
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    //批量修改商品查询
    @RequestMapping(value = "/editItemsList", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItemsList() throws Exception {

//		//调用service查询商品列表
        List<ItemCustom> itemList = itemService.findItemsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemList);
//		System.out.println("xxx"+itemList);
        // 指定逻辑视图名
        modelAndView.setViewName("editItemsList");
        return modelAndView;
    }

    //批量修改商品提交
    @RequestMapping(value = "/editItemsListSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public String editItemsListSubmit(ItemQueryVo itemQueryVo) throws Exception {

        return "success";
    }

    @RequestMapping(value = "/delItemsListSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public String delItemsListSubmit(ItemQueryVo itemQueryVo) throws Exception {

        return "success";
    }
    /**
     * Controller返回值-为String/修改单个sql
     *
     * @param model 模型
     * @return jsp地址
     * @throws Exception
     */
    @RequestMapping(value = "/editItem", method = {RequestMethod.GET})
    public String editItems(Model model, Integer id) throws Exception {


        //通过request-获取商品id;
//		String idx = request.getParameter("id");
//		Integer integer = Integer.valueOf(idx);
        //简单数据回显
        model.addAttribute("id", id);
        ItemCustom itemList = itemService.findItemsById(id);

//      未知异常处理
//		int i=1/0;

        //调试自定义异常
        if (itemList == null) {
            throw new CustomException("修改商品信息不存在");
        }
        model.addAttribute("itemCustom", itemList);
        return "editItem";
    }

    //根据商品id信息查看Restful接口
    //@RequestMapping中指定restful方式的url中的参数，参数需要用{}包起来
    //@PathVariable将url中的{}包起参数和形参进行绑定
    @RequestMapping("/viewItems/{id}")
    public
    @ResponseBody
    ItemCustom viewItems(@PathVariable("id") Integer id) throws Exception {
        //调用 service查询商品信息
        ItemCustom itemsCustom = itemService.findItemsById(id);

        return itemsCustom;
    }


    //商品修改提交
    //itemsQueryVo是包装类型的pojo
    //@ModelAttribute 的pojo数据回显。
//	public String editItemSubmit(Integer id,ItemsCustom itemsCustom,
//			ItemsQueryVo itemsQueryVo)throws Exception{
    //简单的pojo数据，放到model中。需要其中value和jsp中的一致。
    //注意（ItemCustom item）形参和jsp中一致，不需要addAttribute，但是不推荐使用。
//    pictureFile 上传图片
    //校验前面加注解，后面带上错误
    //@Validated定义属于某一个组的校验
    @RequestMapping(value = "/editItemSubmit")
    public String editItemSubmit(Model model,
                                 Integer id,
                                 @Validated(value = {ValidGroup1.class}) @ModelAttribute(value = "itemCustom") ItemCustom itemCustom,
                                 BindingResult bindingResult,
                                 @RequestParam("pictureFile") MultipartFile pictureFile) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            model.addAttribute("errors", allErrors);
            for (ObjectError error : allErrors) {
                //输出错误信息
                System.out.println(error.getDefaultMessage());
            }
            //如果校验错误，回到商品修改页面
            return "editItem";
        }

        //表单提交出错，重新回到表单。用户填写数据，将提交的参数在页面上回显。
        model.addAttribute("id", id);
        uploadPictureFile(itemCustom, pictureFile);


        //调用service更新商品信息
        itemService.updateByPrimaryKeyWithBLOBs(id, itemCustom);
        //测试数据回显
//        return "editItem";
        //重定向。
        return "redirect:queryItem.action";
        //转发
//		return "forward:queryItem.action";
    }

    /**
     * 上传图片功能
     *
     * @param itemCustom
     * @param pictureFile
     * @throws IOException
     */
    private void uploadPictureFile(@Validated(value = {ValidGroup1.class}) @ModelAttribute(value = "itemCustom") ItemCustom itemCustom, @RequestParam("pictureFile") MultipartFile pictureFile) throws IOException {
        //上传图片
        if (pictureFile != null && pictureFile.getOriginalFilename() != null && pictureFile.getOriginalFilename().length() > 0) {
            System.out.println("file is not null");
            //图片上传成功，将图片地址写入数据库
            String filePath = "C:\\upload\\pic\\";
            //获取图片的原始名称
            String originalFilename = pictureFile.getOriginalFilename();
            //生成新的文件名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新文件
            File file = new File(filePath + newFileName);
            //将内存中的文件写入磁盘
            pictureFile.transferTo(file);
            //将新图片的地址写入数据库
            itemCustom.setPic(newFileName);

        }
    }

    //删除 商品(绑定数组)
    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] delete_id) throws Exception {

        //调用service方法删除 商品
        //....

//		itemService.deleteItems(delete_id);
        for (int i = 0; i < delete_id.length; i++) {
            System.out.println(delete_id);
        }
        return "success";
    }

    /**
     * Controller返回值-返回值为空
     * @param request
     * @param response
     * @throws Exception
     */
/*	@RequestMapping(value = "/editItem",method = RequestMethod.GET)
    public void editItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemCustom itemList=itemService.findItemsById(1);
		request.setAttribute("item",itemList);
		//使用request转发页面，需要些完整路径
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request,response);
	}*/


    /**
     * 单独将商品类型的方法提出来，将方法返回值填充到request，在页面显示
     * 通过ModelAttribute将公用取数据的方法，传递都页面，这样就不需要再每一个controler中传递参数
     *
     * @return 返回一个HashMap
     * @throws Exception
     */
    @ModelAttribute("itemsType")
    public Map<String, String> getItemsType() throws Exception {

        HashMap<String, String> itemsType = new HashMap<String, String>();
        itemsType.put("001", "数码");
        itemsType.put("002", "服装");
        return itemsType;

    }

    /**
     * spring mvc入门案例。自行封装数据
     *
     * @return 模型和视图
     */
    @RequestMapping("/queryItems1")
    public ModelAndView queryItems1() {
        // 使用静态数据将商品信息列表显示在jsp页面
        // 商品列表
        List<Items> itemsList = new ArrayList<Items>();

        Items items_1 = new Items();
        items_1.setName("联想笔记本");
        items_1.setPrice(6000f);
        items_1.setCreatetime(new Date());
        items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items_2 = new Items();
        items_2.setName("苹果手机");
        items_2.setPrice(5000f);
        items_2.setDetail("iphone6苹果手机！");

        Items items_3 = new Items();
        items_3.setName("苹果手机");
        items_3.setPrice(5000f);
        items_3.setDetail("iphone6苹果手机！");

        itemsList.add(items_1);
        itemsList.add(items_2);
        itemsList.add(items_3);

        ModelAndView modelAndView = new ModelAndView();
        //将数据填充到request
//		request.setAttribute("itemsList", itemsList);
        modelAndView.addObject("itemsList", itemsList);
        //指定转发的jsp页面
        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        return modelAndView;
    }

//	这种方式无法实现多个Controller共用
    //自定义属性编辑器
//	@InitBinder
//	public void initBinder(WebDataBinder binder) throws Exception {
//		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//	}

    //添加商品-2017-2-20 15:22:30
    @RequestMapping("/addItem")
    public String addItem(Model model, ItemCustom itemCustom) throws Exception {
        itemCustom = new ItemCustom();
        Date date = new Date();
        itemCustom.setCreatetime(date);
        model.addAttribute("itemCustom", itemCustom);
        return "addItem";
    }

    //添加商品提交-2017-2-20 15:22:41
    @RequestMapping("/addItemSubmit")
    public String addItemSubmit(Model model, @Validated(value = {ValidGroup1.class}) ItemCustom itemCustom, @RequestParam("pictureFile") MultipartFile pictureFile) throws Exception {
        //完成图片上次功能，设置图片属性
        uploadPictureFile(itemCustom, pictureFile);
        //执行插入数据库工作
        int res = 0;
        try {
            System.out.println("before");
            res = itemService.insert(itemCustom);
            System.out.println("after");
            if (res == 1) {
                //添加成功，重定向到商品列表页
                return "redirect:/item/queryItem.action";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败，跳到添加标签
            return "addItem";
        } finally {

        }
        //添加失败，跳到添加标签
        return "addItem";
    }

}
