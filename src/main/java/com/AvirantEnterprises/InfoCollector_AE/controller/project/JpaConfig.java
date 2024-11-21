package com.AvirantEnterprises.InfoCollector_AE.controller.project;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.AvirantEnterprises.InfoCollector_AE.controller.project")
@EntityScan(basePackages = "com.AvirantEnterprises.InfoCollector_AE.controller.project")
public class JpaConfig {
    // configuration code
}
