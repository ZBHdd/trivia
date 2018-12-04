package AWS;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AWS.AWS
 * @Description TODO
 * @Author Satan
 **/

public class AWS  {


    private AmazonSNSClient amazonSNSClient;

    // 如何获取accessKey?  https://console.aws.amazon.com/iam/home
    public synchronized void init(String accessKey, String secretKey ) {
        AmazonSNSClientBuilder clientBuilder = AmazonSNSClientBuilder.standard();
        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(awsCredentials);
        clientBuilder.setCredentials(provider);
        // Regions 就是你选择从哪个国家的服务器接入,价格参考 https://amazonaws-china.com/cn/sns/sms-pricing/
        clientBuilder.setRegion(Regions.AP_SOUTHEAST_1.getName());
        amazonSNSClient = (AmazonSNSClient) clientBuilder.build();
    }

    public void sendSms(String areaCode, String phone, String message) {
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<>();
        String phoneNumb = areaCode + phone;
        sendSMSMessage(amazonSNSClient, message, phoneNumb, smsAttributes);
    }

    private static void sendSMSMessage(AmazonSNSClient snsClient, String message,
                                String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));
        System.out.println(result.toString());
    }

}