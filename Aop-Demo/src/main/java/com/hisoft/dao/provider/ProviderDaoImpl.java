package com.hisoft.dao.provider;

import com.hisoft.pojo.Provider;
import org.springframework.stereotype.Repository;

@Repository("providerdao")
public class ProviderDaoImpl implements ProviderDao{
    @Override
    public int add(Provider provider) {
        System.out.println("供应商添加成功");
        return 1;
    }
}
