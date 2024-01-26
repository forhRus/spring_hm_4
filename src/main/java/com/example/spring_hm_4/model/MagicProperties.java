package com.example.spring_hm_4.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Класс хранит запросы для базы данных.
 * значения для полей он получает из файла application.properties
 */
@ConfigurationProperties("sql")
@Data
public class MagicProperties {

  private String QUERY_SELECT_ALL;
  private String QUERY_INSERT_USER;
  private String QUERY_DELETE_USER;
  private String QUERY_UPDATE_USER;
  private String QUERY_SELECT_USER;

}
