
package com.gamedoora.backend.userservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author aprajshekhar
 */
@Configuration
@RefreshScope
public class PropertiesConfig {

    private String primaryDbUrl;
    private String primaryDbDriver;
    private String primaryDbUser;
    private String primaryDbPassword;
    private String hibernateHbm2ddl;
    private String hibernateDialect;

    /**
     * @return the primaryDbUrl
     */
    public String getPrimaryDbUrl() {
        return primaryDbUrl;
    }

  /**
   * @param primaryDbUrl the primaryDbUrl to set
   */
  @Value("${userservice.db.primary.url}")
  public void setPrimaryDbUrl(String primaryDbUrl) {
        this.primaryDbUrl = primaryDbUrl;
    }

    /**
     * @return the primaryDbDriver
     */
    public String getPrimaryDbDriver() {
        return primaryDbDriver;
    }

    /**
     * @param primaryDbDriver the primaryDbDriver to set
     */
    @Value("${userservice.db.primary.driver}")
    public void setPrimaryDbDriver(String primaryDbDriver) {
        this.primaryDbDriver = primaryDbDriver;
    }

    /**
     * @return the primaryDbUser
     */
    public String getPrimaryDbUser() {
        return primaryDbUser;
    }

    /**
     * @param primaryDbUser the primaryDbUser to set
     */
    @Value("${userservice.db.primary.user}")
    public void setPrimaryDbUser(String primaryDbUser) {
        this.primaryDbUser = primaryDbUser;
    }

    /**
     * @return the primaryDbPassword
     */
    public String getPrimaryDbPassword() {
        return primaryDbPassword;
    }

    /**
     * @param primaryDbPassword the primaryDbPassword to set
     */
    @Value("${userservice.db.primary.password}")
    public void setPrimaryDbPassword(String primaryDbPassword) {
        this.primaryDbPassword = primaryDbPassword;
    }

  /**
   * @return the hibernateHbm2ddl
   */
  public String getHibernateHbm2ddl() {
    return hibernateHbm2ddl;
  }

  /**
   * @param hibernateHbm2ddl the hibernateHbm2ddl to set
   */
  public void setHibernateHbm2ddl(String hibernateHbm2ddl) {
    this.hibernateHbm2ddl = hibernateHbm2ddl;
  }

  /**
   * @return the hibernateDialect
   */
  public String getHibernateDialect() {
    return hibernateDialect;
  }

  /**
   * @param hibernateDialect the hibernateDialect to set
   */
  public void setHibernateDialect(String hibernateDialect) {
    this.hibernateDialect = hibernateDialect;
  }
    
    
    
}
