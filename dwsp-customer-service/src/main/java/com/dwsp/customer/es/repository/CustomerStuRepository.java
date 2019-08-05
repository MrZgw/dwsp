package com.dwsp.customer.es.repository;

import com.dwsp.customer.entity.CustomerStu;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @Description: customerStu es操作接口<br>
 * @Project: dwsp <br>
 * @CreateDate: Created in 2019/8/2 15:10 <br>
 * @Author: <a href="zgw@qq.com">zgw</a>
 */
public interface CustomerStuRepository extends ElasticsearchCrudRepository<CustomerStu, Long> {
}
