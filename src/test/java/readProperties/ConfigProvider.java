package readProperties;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URl = "https://webtopdf.com/ru/";
}
