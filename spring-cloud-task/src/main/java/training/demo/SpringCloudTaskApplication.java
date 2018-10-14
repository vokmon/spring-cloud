package training.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTaskApplication.class, args);
    }

    @Bean
    public ToolProcessingTask toolProcessingTask() {
        return new ToolProcessingTask();
    }

    public class ToolProcessingTask implements CommandLineRunner {

        @Override
        public void run(String... strings) throws Exception {
            // parameters stationid, license plate, timestamp

            if (null != strings) {
                System.out.println("parameter length is " + strings.length);
                final String stationId = strings[0];
                final String licensePlate = strings[1];
                final String timestamp = strings[2];
                System.out.println(
                        "Station ID is " + stationId + ", plate is " + licensePlate
                                + ", timestamp is " + timestamp);

            }
        }

    }
}
