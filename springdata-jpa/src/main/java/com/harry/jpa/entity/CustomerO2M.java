package com.harry.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户的实体类
 * 明确使用的注解都是JPA规范的
 * 所以导包都要导入javax.persistence包下的
 */
@Entity//表示当前类是一个实体类
@Table(name="cst_customer")//建立当前实体类和表之间的对应关系
public class CustomerO2M implements Serializable {

    @Id//表明当前私有属性是主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)//指定主键的生成策略
    @Column(name="cust_id")//指定和数据库表中的cust_id列对应
    private Long custId;
    @Column(name="cust_name")//指定和数据库表中的cust_name列对应
    private String custName;
    @Column(name="cust_source")//指定和数据库表中的cust_source列对应
    private String custSource;
    @Column(name="cust_industry")//指定和数据库表中的cust_industry列对应
    private String custIndustry;
    @Column(name="cust_level")//指定和数据库表中的cust_level列对应
    private String custLevel;
    @Column(name="cust_address")//指定和数据库表中的cust_address列对应
    private String custAddress;
    @Column(name="cust_phone")//指定和数据库表中的cust_phone列对应
    private String custPhone;

    //配置客户和联系人的一对多关系
    @OneToMany(mappedBy="customer")
    private Set<LinkMan> linkmans = new HashSet<LinkMan>(0);

    public Long getCustId() {
        return custId;
    }
    public void setCustId(Long custId) {
        this.custId = custId;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustSource() {
        return custSource;
    }
    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }
    public String getCustIndustry() {
        return custIndustry;
    }
    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }
    public String getCustLevel() {
        return custLevel;
    }
    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }
    public String getCustAddress() {
        return custAddress;
    }
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }
    public String getCustPhone() {
        return custPhone;
    }
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
    public Set<LinkMan> getLinkmans() {
        return linkmans;
    }
    public void setLinkmans(Set<LinkMan> linkmans) {
        this.linkmans = linkmans;
    }

    @Override
    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource
                + ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + ", custAddress=" + custAddress
                + ", custPhone=" + custPhone + "]";
    }

}
