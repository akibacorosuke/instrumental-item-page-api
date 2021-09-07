package root.awsImage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {
        final AWSCredentials awsCredentials = new BasicAWSCredentials("",
                "");

        return AmazonS3ClientBuilder
                // Asia Pacific (Tokyo) ap-northeast-1
                .standard().withRegion(Regions.AP_NORTHEAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

}
