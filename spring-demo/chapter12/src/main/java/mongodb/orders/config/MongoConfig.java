package mongodb.orders.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author luopeng
 * @date 2019/11/20 22:32
 * EnableMongoRepositories注解启用MongoDB的Repository功能
 */
@Configuration
@EnableMongoRepositories(basePackages = "mongodb.orders.db")
public class MongoConfig extends AbstractMongoConfiguration {



    @Override
    protected String getDatabaseName() {
        //指定数据库名称
        return "OrdersDB";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }
}
