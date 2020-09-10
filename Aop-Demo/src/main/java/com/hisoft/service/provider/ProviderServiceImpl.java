package com.hisoft.service.provider;

import com.hisoft.dao.provider.ProviderDao;
import com.hisoft.pojo.Provider;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Data
@Service("providerservice")
public class ProviderServiceImpl implements ProviderService{
    @Resource(name = "providerdao")
    private ProviderDao providerDao;
    @Override
    public Integer add(Provider provider) {
        return providerDao.add(provider);
    }
}
