package store.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * creator violet
 * createTime 2019/2/23
 * description
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected HttpServletResponse response;

    protected HttpServletRequest request;


    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(
//                new SimpleDateFormat("yyyy-MM-dd"), true));
//    }
//
//    /**
//     * 输出信息到页面
//     * @param msg：要输出的信息（可以是js脚本等）
//     */
//    public void printOutMsg(String msg){
//        try {
//            this.response.setCharacterEncoding("UTF-8");
//            this.response.setContentType("text/html;charset=utf-8");
//            PrintWriter out = null;
//            out = this.response.getWriter();
//            out.print(msg);
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 输出信息到页面
//     * @param response
//     * @param msg
//     */
//    public void printOutMsg(HttpServletResponse response, String msg){
//        try {
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("text/html;charset=utf-8");
//            PrintWriter out = null;
//            out = response.getWriter();
//            out.print(msg);
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 获取请求完整路径
//     * @param request
//     * @return
//     */
//    public String getUrl(HttpServletRequest request){
//        String url = request.getRequestURI();
//        String params = "";
//        if(request.getQueryString()!=null){
//            params = request.getQueryString().toString();
//        }
//        if(!"".equals(params)){
//            url = url+"?"+params;
//        }
//        return url;
//    }
//
//    /**
//     * 获取日期
//     * @param day   天
//     */
//    public String getDate(int day){
//        StringBuffer s = new StringBuffer();
//        Calendar c = Calendar.getInstance();
//        int currentDay = c.get(Calendar.DATE);
//        if(day < 0){
//            c.add(Calendar.YEAR, -1);
//            c.set(Calendar.DATE, currentDay);
//        }else if(day == 29){
//            c.add(Calendar.MONTH, -1);
//            c.set(Calendar.DATE, currentDay);
//        }else{
//            c.add(Calendar.DATE, -day);
//        }
//
//        s.append(c.get(Calendar.YEAR)+"-");
//        s.append((c.get(Calendar.MONTH)+1) < 10 ? ("0"+(c.get(Calendar.MONTH)+1)) : (c.get(Calendar.MONTH)+1));
//        s.append("-");
//        s.append(c.get(Calendar.DATE) < 10 ? ("0"+c.get(Calendar.DATE)) : c.get(Calendar.DATE));
//        return s.toString();
//    }
//
//    /**
//     * 转换统计的map
//     * @param statMap       统计的map
//     * @param constMap      常量的map
//     * @return
//     */
//    public Map<String, Long> getFmtMap(Map<String, Long> statMap, Map<Integer, String> constMap){
//        Map<String, Long> dataMap = null;
//        if(statMap != null){
//            dataMap = new LinkedHashMap<String, Long>();
//            for(Entry<String, Long> entry : statMap.entrySet()){
//                dataMap.put(constMap.get(Integer.valueOf(entry.getKey()))+"&"+Integer.valueOf(entry.getKey()), entry.getValue());
//            }
//        }
//        return dataMap;
//    }
//    /**
//     * 获取登录用户信息
//     * @return
//     */
//    public SessionUser getSessionUser(){
//        Object session = request.getSession().getAttribute(Constants.KEY_SESSION_USER);
//        return session == null ? null : (SessionUser) session;
//    }
//
//    /**
//     * 获取token
//     * @param type(1:登录;2:注册;3:找回密码)
//     * @return
//     */
//    protected RSAToken getRSAToken(int type){
//        // 生成一个token
//        String token = UUID.randomUUID().toString();
//        if(type == 1){
//            session.setAttribute(Constants.KEY_SESSION_TOKEN_LOGIN, token);
//        }else if(type == 2){
//            session.setAttribute(Constants.KEY_SESSION_TOKEN_REGISTER, token);
//        }else if(type == 3){
//            session.setAttribute(Constants.KEY_SESSION_TOKEN_FIND_PWD, token);
//        }
//
//        // 生成公钥信息
//        RSAPublicKey publicKey = RSAUtils.getDefaultPublicKey();
//        String modulus = new String(Hex.encodeHex(publicKey.getModulus().toByteArray()));
//        String exponent = new String(Hex.encodeHex(publicKey.getPublicExponent().toByteArray()));
//
//        RSAToken rsaToken = new RSAToken();
//        rsaToken.setToken(token);
//        rsaToken.setModulus(modulus);
//        rsaToken.setExponent(exponent);
//
//        return rsaToken;
//    }
//
//    /**
//     *获取后台登陆用户信息
//     *
//     */
//    public SessionUser getSessionAdminUser(){
//        AiUserInfo session = (AiUserInfo) request.getSession().getAttribute(Constants.KEY_SESSION_ADMIN_USER);
//        SessionUser adminUser = new SessionUser();
//        adminUser.setUserId(session.getId());
//        adminUser.setUsername(session.getUserName());
//        return adminUser == null ? null : adminUser;
//    }
//
//    /**
//     * 获取用户加密信息
//     * @return
//     */
//    public String getDesUserInfo(){
//        SessionUser sessionUser = getSessionUser();
//        String encryptText = "";
//        if(sessionUser != null){
//            String plainText = sessionUser.getUsername()+"&"+sessionUser.getUserId();
//            String secretKey = "3dbfac1abd334784860723ef2022a92f";
//            try {
//                encryptText = URLEncoder.encode(Des3.DESEncode(plainText, secretKey), "UTF-8");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return encryptText;
//    }
//
//    /**
//     * 设置用户session
//     * @param user
//     */
//    public void setSessionUser(AiUserInfo user){
//        if(user != null){
//            SessionUser sessionUser = new SessionUser();
//            sessionUser.setUserId(user.getId());
//            if(user.getUserName() != null && !"".equals(user.getUserName())){
//                sessionUser.setUsername(user.getUserName());
//            } else {
//                if(user.getPhone() != null &&  !"".equals(user.getPhone())){
//                    sessionUser.setUsername(user.getPhone());
//                }else {
//                    sessionUser.setUsername(user.getNickName());
//                }
//            }
//            sessionUser.setPhone(user.getPhone());
//            sessionUser.setUserType(user.getUserType()==null?0:user.getUserType());
//            sessionUser.setVipStatus(user.getVipLevel()==null?0:user.getVipLevel());
//            sessionUser.setLogoPath(user.getLogoPath());
//            session.setAttribute(Constants.KEY_SESSION_USER, sessionUser);
//        }
//    }

}
