package store.os.controller.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BaseController;

/**
 * creator violet
 * createTime 2019/2/23
 * description
 */

@Controller
@Api(value = "商品分类")
public class CategoryListController extends BaseController {

    @ApiOperation(value = "类目列表", notes = "类目列表")
    @RequestMapping(value = "/list", method = RequestMethod.DELETE)
    public String list(Model model,
                       @RequestParam(value = "categoryId", required = false, defaultValue = "1") String categoryId,
                       @RequestParam(value = "sort") String requestSort) {
        return "modules/product/product_list";
    }
}
