package store.os.common.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import store.os.common.tag.HtmlTagRuleBund;

import javax.servlet.*;
import java.io.IOException;

/**
 * @creator violet
 * @createTime 2019/3/11
 * @description
 */

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorator/default")//拦截规则，/decorator/default 会被转发
                .addExcludedPath("/static/**") //白名单
                .addTagRuleBundle(new HtmlTagRuleBund());//自定义标签
        super.applyCustomConfiguration(builder);
    }
}
