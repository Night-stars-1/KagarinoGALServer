package com.kagarino.webserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kagarino.webserver.entity.Article;
import com.kagarino.webserver.mapper.ArticleMapper;
import com.kagarino.webserver.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖表 服务实现类
 * </p>
 *
 * @author zwj
 * @since 2024-06-05
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
