//package store.common.plugin;
//
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PropertiesLoaderUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//import java.util.Scanner;
//
///**
// * author  violet
// * createTime 2019/4/1 16:56
// * description MybatisPlus代码生成器
// * version 1.0
// */
//public class MybatisPlusGenerator {
//    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusGenerator.class);
//
//
//    /**
//     * <p>
//     * 读取控制台内容
//     * </p>
//     */
//    private static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//    private static Properties getProperties() {
//        // 读取配置文件
//        Resource resource = new ClassPathResource("/properties/jdbc.properties");
//        Properties props = new Properties();
//        try {
//            props = PropertiesLoaderUtils.loadProperties(resource);
//        } catch (IOException e) {
//            logger.error("CustomGenerator.getProperties:{0}", e);
//        }
//        return props;
//    }
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("d:");
//        gc.setAuthor("violet");
//        gc.setOpen(false);
//        // gc.setSwagger2(true); 实体属性 Swagger2 注解
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        Properties props = getProperties(); //配置文件读取
//
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl(props.getProperty("jdbc.url"));
//        // dsc.setSchemaName("public");
//        dsc.setDriverName(props.getProperty("jdbc.driver"));
//        dsc.setUsername(props.getProperty("jdbc.username"));
//        dsc.setPassword(props.getProperty("jdbc.password"));
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("store");
//        pc.setModuleName("os");
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//        // 如果模板引擎是 velocity
//        // String templatePath = "/templates/mapper.xml.vm";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return "/develop/code/my_" + tableInfo.getEntityName() + ".java";
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
//
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
////        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
////        strategy.setEntityLombokModel(true);
////        strategy.setRestControllerStyle(true);
////        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//
//        String[] tableNames = {"cms_config",
//                "cms_log",
//                "cms_menu",
//                "cms_organization",
//                "cms_role",
//                "cms_role_menu",
//                "cms_user",
//                "cms_user_login_log",
//                "cms_user_role",
//                "cms_version_log",
//                "os_address",
//                "os_advert",
//                "os_advert_detail",
//                "os_category",
//                "os_category_advert",
//                "os_comment",
//                "os_comment_reply",
//                "os_email",
//                "os_favorite",
//                "os_kind",
//                "os_kind_attribute",
//                "os_label",
//                "os_navigation",
//                "os_navigation_bar",
//                "os_order",
//                "os_order_product",
//                "os_order_shipment",
//                "os_order_status",
//                "os_product",
//                "os_product_attribute",
//                "os_product_category",
//                "os_product_detail",
//                "os_product_image",
//                "os_product_parameter",
//                "os_product_recommend",
//                "os_product_spec_rel",
//                "os_product_specification",
//                "os_question",
//                "os_recommend",
//                "os_shopping_cart",
//                "os_specification",
//                "os_specification_attribute",
//                "os_user",
//                "os_user_login_log",
//                "support_image_log"
//        };
//        strategy.setInclude(tableNames);// 需要生成的表
////        strategy.setSuperEntityColumns("id");
////        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");//此处可以修改为表前缀
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
