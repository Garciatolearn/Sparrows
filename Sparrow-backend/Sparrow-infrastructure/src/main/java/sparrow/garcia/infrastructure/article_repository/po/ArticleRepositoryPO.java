package sparrow.garcia.infrastructure.article_repository.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("article_repository")
public class ArticleRepositoryPO {

    private String id;

    private String articleId;

    private String userId;

    private String articleTitle;

    private Integer deleted;

    private Date createdTime;

    private Date updatedTime;

}
