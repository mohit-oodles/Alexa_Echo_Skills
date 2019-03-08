package main.java.constant;

public class RequestConstants {

    public String requestJson = "{\n" +
            "\t\"version\": \"1.0\",\n" +
            "\t\"session\": {\n" +
            "\t\t\"new\": false,\n" +
            "\t\t\"sessionId\": \"amzn1.echo-api.session.d5432ef0-c82b-4321-9cbe-b73d87b623fa\",\n" +
            "\t\t\"application\": {\n" +
            "\t\t\t\"applicationId\": \"amzn1.ask.skill.8fdbdf55-7294-4fdf-b038-1df2c9f32ffe\"\n" +
            "\t\t},\n" +
            "\t\t\"user\": {\n" +
            "\t\t\t\"userId\": \"amzn1.ask.account.AELLXMLXCTBWWPJVRXKL3YFTFN5R23Q5XJQ2GV77SQK3LLA2QSARYYPQWHKBF3WVNXJFPSZCYHHDBF2LJNEO6CSQYAKLLQSIYPJMUGTHFZASVVOFX6TBIWFOM2HJRRXZCWJOETLIS3IQUNLYVBA3R2R2J6T2UQXBIQZEIA5JDXNSLHRB7CF6DIFG663DNRBOR4MC2YVVHMESSRA\"\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"context\": {\n" +
            "\t\t\"AudioPlayer\": {\n" +
            "\t\t\t\"playerActivity\": \"IDLE\"\n" +
            "\t\t},\n" +
            "\t\t\"System\": {\n" +
            "\t\t\t\"application\": {\n" +
            "\t\t\t\t\"applicationId\": \"amzn1.ask.skill.8fdbdf55-7294-4fdf-b038-1df2c9f32ffe\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"user\": {\n" +
            "\t\t\t\t\"userId\": \"amzn1.ask.account.AELLXMLXCTBWWPJVRXKL3YFTFN5R23Q5XJQ2GV77SQK3LLA2QSARYYPQWHKBF3WVNXJFPSZCYHHDBF2LJNEO6CSQYAKLLQSIYPJMUGTHFZASVVOFX6TBIWFOM2HJRRXZCWJOETLIS3IQUNLYVBA3R2R2J6T2UQXBIQZEIA5JDXNSLHRB7CF6DIFG663DNRBOR4MC2YVVHMESSRA\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\"device\": {\n" +
            "\t\t\t\t\"deviceId\": \"amzn1.ask.device.AHFHTJRV4J6RDZQWNDKZJYXIYKSBM7YIGNJWHVWZ7OLFVOGLSTMLG2DQDCWVG3IWQNHTB6XQONMH3TY5UUVPKCCHQ6U5E2YDGLPD3QMYUF5VFO55Z5PVIXIOTCWB3NPJFDOYKATURGHMRJDSIRTDIUNZ7YUPXNBWT6V2RQUSHZB4A3S44NWK4\",\n" +
            "\t\t\t\t\"supportedInterfaces\": {\n" +
            "\t\t\t\t\t\"AudioPlayer\": {}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"apiEndpoint\": \"https://api.eu.amazonalexa.com\",\n" +
            "\t\t\t\"apiAccessToken\": \"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjEifQ.eyJhdWQiOiJodHRwczovL2FwaS5hbWF6b25hbGV4YS5jb20iLCJpc3MiOiJBbGV4YVNraWxsS2l0Iiwic3ViIjoiYW16bjEuYXNrLnNraWxsLjhmZGJkZjU1LTcyOTQtNGZkZi1iMDM4LTFkZjJjOWYzMmZmZSIsImV4cCI6MTU1MDgzMTg1MywiaWF0IjoxNTUwODMxNTUzLCJuYmYiOjE1NTA4MzE1NTMsInByaXZhdGVDbGFpbXMiOnsiY29uc2VudFRva2VuIjpudWxsLCJkZXZpY2VJZCI6ImFtem4xLmFzay5kZXZpY2UuQUhGSFRKUlY0SjZSRFpRV05ES1pKWVhJWUtTQk03WUlHTkpXSFZXWjdPTEZWT0dMU1RNTEcyRFFEQ1dWRzNJV1FOSFRCNlhRT05NSDNUWTVVVVZQS0NDSFE2VTVFMllER0xQRDNRTVlVRjVWRk81NVo1UFZJWElPVENXQjNOUEpGRE9ZS0FUVVJHSE1SSkRTSVJURElVTlo3WVVQWE5CV1Q2VjJSUVVTSFpCNEEzUzQ0TldLNCIsInVzZXJJZCI6ImFtem4xLmFzay5hY2NvdW50LkFFTExYTUxYQ1RCV1dQSlZSWEtMM1lGVEZONVIyM1E1WEpRMkdWNzdTUUszTExBMlFTQVJZWVBRV0hLQkYzV1ZOWEpGUFNaQ1lISERCRjJMSk5FTzZDU1FZQUtMTFFTSVlQSk1VR1RIRlpBU1ZWT0ZYNlRCSVdGT00ySEpSUlhaQ1dKT0VUTElTM0lRVU5MWVZCQTNSMlIySjZUMlVRWEJJUVpFSUE1SkRYTlNMSFJCN0NGNkRJRkc2NjNETlJCT1I0TUMyWVZWSE1FU1NSQSJ9fQ.KAq4elcWP-YNC32wSgRrSkgp_Gre-G2T08b5c-UTI-e2DwgZEDElHy8x3G5BY5EG77cX91C68HT77i1zSZmOEQq5W6axISUwwvJubLlnbkXHLeG7VtraHeFPH45uNR7sJzrlPAq_PbxUX3xfDu-DKmJ5DXNb6NNukqBMzURKTQYSwOfuLZsaVUSqzDQtLKRmnLOYUIwtup6xAJHesBY-wMWZrep7PnSpOOGkvujn251e84Hid2rrDZa2Mx_QrNPTll2nehWFZG7r8lS-84iWyp1QMRrbe7lZVuytQiyxrYwBRAibvKZ2Ahqby66pwJssJ56Ky20yCo1Nh0BbIjpatw\"\n" +
            "\t\t},\n" +
            "\t\t\"Viewport\": {\n" +
            "\t\t\t\"experiences\": [\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"arcMinuteWidth\": 246,\n" +
            "\t\t\t\t\t\"arcMinuteHeight\": 144,\n" +
            "\t\t\t\t\t\"canRotate\": false,\n" +
            "\t\t\t\t\t\"canResize\": false\n" +
            "\t\t\t\t}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"shape\": \"RECTANGLE\",\n" +
            "\t\t\t\"pixelWidth\": 1024,\n" +
            "\t\t\t\"pixelHeight\": 600,\n" +
            "\t\t\t\"dpi\": 160,\n" +
            "\t\t\t\"currentPixelWidth\": 1024,\n" +
            "\t\t\t\"currentPixelHeight\": 600,\n" +
            "\t\t\t\"touch\": [\n" +
            "\t\t\t\t\"SINGLE\"\n" +
            "\t\t\t]\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t\"request\": {\n" +
            "\t\t\"type\": \"IntentRequest\",\n" +
            "\t\t\"requestId\": \"amzn1.echo-api.request.5ecdcd7c-b096-46c1-9a83-008e015e9ae4\",\n" +
            "\t\t\"timestamp\": \"2019-02-22T10:32:33Z\",\n" +
            "\t\t\"locale\": \"en-US\",\n" +
            "\t\t\"intent\": {\n" +
            "\t\t\t\"name\": \"CustomerServiceIntent\",\n" +
            "\t\t\t\"confirmationStatus\": \"NONE\"\n" +
            "\t\t}\n" +
            "\t}\n" +
            "}";
}
