package com.tf.servlet.user;


import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.tf.pojo.Role;
import com.tf.pojo.User;
import com.tf.service.Role.RoleService;
import com.tf.service.Role.RoleServiceImpl;
import com.tf.service.User.UserService;
import com.tf.service.User.UserServiceImpl;
import com.tf.util.Constant;
import com.tf.util.PageSupport;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("doget...1"+req.getParameter("method") );
        String method = req.getParameter("method");
//        System.out.println(method+"_________");
//        System.out.println(req.getParameter("add"));
        if (method!= null && method.equals("pwdmodify")) {
//            System.out.println("doget...2");
            this.pwdmodify(req, resp);
        } else if(method!= null && method.equals("savepwd")){
//            System.out.println("doget...2");
            this.updatePwd(req,resp);
        }else if(method!= null && method.equals("query")){
            this.query(req,resp);
        }else if(method!= null && method.equals("add")){
//            System.out.println("add");
            this.add(req,resp);
        }else if(method!= null && method.equals("getrolelist")){
            this.getRoleList(req,resp);
        }else if(method!= null && method.equals("ucexist")){
            this.getRoleList(req,resp);
        }else if(method!= null && method.equals("deluser")) {
            this.delUser(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



    private void userCodeExist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //判断用户账号是否可用
        String userCode = request.getParameter("userCode");

        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(StringUtils.isNullOrEmpty(userCode)){
            //userCode == null || userCode.equals("")
            resultMap.put("userCode", "exist");
        }else{
            UserService userService = new UserServiceImpl();
            User user = userService.selectUserCodeExist(userCode);
            if(null != user){
                resultMap.put("userCode","exist");
            }else{
                resultMap.put("userCode", "notexist");
            }
        }

        //把resultMap转为json字符串以json的形式输出
        //配置上下文的输出类型
        response.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter outPrintWriter = response.getWriter();
        //把resultMap转为json字符串 输出
        outPrintWriter.write(JSONArray.toJSONString(resultMap));
        outPrintWriter.flush();//刷新
        outPrintWriter.close();//关闭流
    }
//    函数名改成别的是否可行
//    验证旧密码
    public static void pwdmodify(HttpServletRequest req, HttpServletResponse resp){

        HttpSession session = req.getSession();
        Object user = session.getAttribute(Constant.USER_SESSION);
        Map<String,String> map = new HashMap<String,String>();
        String input = req.getParameter("oldpassword");
//        System.out.println("pwdmodify()..."+user);
//        System.out.println("pwdmodify()..."+input);

        if(user==null){
//            result改成别的是否可行
            map.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(input)){
            map.put("result","error");
        }else{
            String userPassword = ((User) user).getUserPassword();
            if(userPassword!=null&&userPassword.equals(input)){
                map.put("result","true");

            }else {
                map.put("result","false");
            }
        }
        try {
            JSONArray JA = new JSONArray();
            resp.setContentType("Application/Json");
            PrintWriter writer = resp.getWriter();
            writer.write(JA.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    保存修改密码
    public void updatePwd(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

        UserService us=new UserServiceImpl();
        String newpassword = (String) req.getParameter("newpassword");
        Object o = req.getSession().getAttribute(Constant.USER_SESSION);
        Long id = ((User) o).getId();
//        System.out.println("updatePwd"+us+"||"+newpassword+"||"+id);
        boolean flag = us.updatePwd(id, newpassword);
        if(flag){
            req.setAttribute("message","修改成功请重新登录");
            req.getSession().setAttribute(Constant.USER_SESSION,null);

        }else {
            req.setAttribute("message","修改失败");

        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);

    }

//    用户列表界面
    public void query(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

        UserServiceImpl userService = new UserServiceImpl();
        RoleServiceImpl roleService = new RoleServiceImpl();

//        获取用户角色列表
        List<Role> roleNameList = roleService.getRoleNameList();


        PageSupport pageSupport = new PageSupport();
//        获取当前页
        String currentPageNo=req.getParameter("pageIndex");
        int pageSize=5;


//        给用户角色选单赋值
        req.setAttribute("roleList",roleNameList);

//        获取用户名
        String queryUserName = req.getParameter("queryname");
//        获取用户角色
        String queryUserRole = req.getParameter("queryUserRole");


        String queryUserRoletemp="";
        if(queryUserRole==null||queryUserRole.equals("")){
            queryUserRoletemp="0";
        }else{
            queryUserRoletemp=queryUserRole;
        }
        if(currentPageNo==null){
            currentPageNo="1";
        }

//        获取总共数据有几条
        int count = userService.getCount(queryUserName,Long.parseLong(queryUserRoletemp));


//        获取共有几页
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(count);
        pageSupport.setCurrentPageNo(Integer.parseInt(currentPageNo));

        int totalPageCount = pageSupport.getTotalPageCount();

        List<User> userList= userService.getUserList(
                queryUserName,
                Long.valueOf(queryUserRoletemp),
                Integer.parseInt(currentPageNo),
                pageSize
        );





        req.setAttribute("userList",userList);
        req.setAttribute("roleList", roleNameList);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("totalCount",count);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("queryUserName", queryUserName);
        req.setAttribute("queryUserRole", queryUserRoletemp);
        req.getRequestDispatcher("/jsp/userlist.jsp").forward(req,resp);



    }
    private void getRoleList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Role> roleList = null;
        RoleService roleService = new RoleServiceImpl();
        roleList = roleService.getRoleNameList();
        for (Role role : roleList) {
            System.out.println(role);
        }
        //把roleList转换成json对象输出
        response.setContentType("application/json");
        PrintWriter outPrintWriter = response.getWriter();
        outPrintWriter.write(JSONArray.toJSONString(roleList));
        outPrintWriter.flush();
        outPrintWriter.close();
    }
    public void add(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {

        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleNameList = roleService.getRoleNameList();
        req.setAttribute("userRole",roleNameList);
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");
        User session= (User) req.getSession().getAttribute(Constant.USER_SESSION);
        Long id = session.getId();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date creationDate = new Date(System.currentTimeMillis());

        User user=new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(Integer.parseInt(gender));
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Long.valueOf(userRole));
        user.setCreationDate(creationDate);
        user.setCreatedBy(id);
        try {

            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserService userService=new UserServiceImpl();
        int i = userService.addUser(user);

        if(i>0){
            resp.sendRedirect(req.getContextPath()+"/jsp/user.do?method=query");
        }else{
            req.getRequestDispatcher("useradd.jsp"  ).forward(req,resp);
        }


    }
    public void delUser(HttpServletRequest req, HttpServletResponse resp){
        String userid = req.getParameter("uid");
        HashMap<String, String> json = new HashMap<>();
        List<Long> uidlist=new ArrayList<>();
        if(userid!=null){
            Long uid=Long.parseLong(userid);
            UserService userService=new UserServiceImpl();

            boolean delcount = userService.delUser(uid);
            List<User> userList=userService.getUserList(null,Long.valueOf(0),1,1000);
            for (User user : userList) {
                uidlist.add(user.getId());
            }
            System.out.println(userList.contains(userid));
            if(Long.parseLong(userid)>0){
                if(delcount){
                    json.put("delResult","true");
                }else {
                    json.put("delResult","false");

                }
            }else {
                json.put("delResult","noexist");
            }

        }else {
            json.put("delResult","false");
        }
        resp.setContentType("application/json");
        PrintWriter outPrintWriter = null;
        try {
            outPrintWriter = resp.getWriter();
            outPrintWriter.write(JSONArray.toJSONString(json));
            outPrintWriter.flush();
            outPrintWriter.close();
//            req.getRequestDispatcher("us.jsp"  ).forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void test(){
        String s=null;
        Long l= Long.valueOf(String.valueOf(s));
//        System.out.println(Long.parseLong(s));
//        System.out.println(l);
    }
}
