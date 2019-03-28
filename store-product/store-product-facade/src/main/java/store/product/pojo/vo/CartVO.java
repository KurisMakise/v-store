package store.product.pojo.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/21
 * @description
 */
public class CartVO {
    /**
     * 订单列表
     */
    private List<ShoppingCartVO> shoppingCartVOs;

    /**
     * 订单总数量
     */
    private Integer totalNumber;

    /**
     * 订单总价格
     */
    private BigDecimal totalPrice;

    /**
     * 订单总积分
     */
    private Integer totalScore;

    public List<ShoppingCartVO> getShoppingCartVOs() {
        return shoppingCartVOs;
    }

    private void getTotal() {
        int totalNumberTmp = 0;
        int totalScoreTmp = 0;
        BigDecimal totalPriceTmp = BigDecimal.valueOf(0d);
        for (ShoppingCartVO shoppingCartVO : shoppingCartVOs) {
            totalNumberTmp += shoppingCartVO.getBuyNumber();
            totalScoreTmp += shoppingCartVO.getScore();
            totalPriceTmp = totalPriceTmp.add(shoppingCartVO.getProductAmount());
        }
        totalNumber = totalNumberTmp;
        totalPrice = totalPriceTmp;
        totalScore = totalScoreTmp;
    }

    public void setShoppingCartVOs(List<ShoppingCartVO> shoppingCartVOs) {
        this.shoppingCartVOs = shoppingCartVOs;
        getTotal();
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
