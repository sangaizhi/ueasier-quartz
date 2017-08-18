package cn.zyunc.ueasier.quartz.test.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
public class OrderPO {
    private Long id;
    private String code;
    private BigDecimal amount;
    private Long userId;
    private String userName;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
