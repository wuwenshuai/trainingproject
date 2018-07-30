package cn.shuhe.common;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.junit.jupiter.api.Test;

/**
 * @Auther: wuwenshuai
 * @Date: 2018/7/26 11:00
 * @Description:
 */
public class TestXmlToJson {

    @Test
    public void test() throws JSONException {
        String xml = "<class id="
                + "'1'"
                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>";

        String xml1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><message>\n" +
                "  <head>\n" +
                "    <transCode>1024</transCode>\n" +
                "    <transType>10</transType>\n" +
                "    <transReqTime>20171013104430</transReqTime>\n" +
                "    <transSeqNo>20171013104430662HBB000000000001</transSeqNo>\n" +
                "    <merchantId>N09120100000000</merchantId>\n" +
                "    <productCode>01K213</productCode>\n" +
                "    <netCode>N09120100000011</netCode>\n" +
                "    <operatorCode>ces</operatorCode>\n" +
                "    <customerId>12345678901234567890</customerId>\n" +
                "    <rcmdStoreCode>N09120100000011</rcmdStoreCode>\n" +
                "    <rcmdStoreName>还呗-虚拟网点</rcmdStoreName>\n" +
                "    <version>1.0</version>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <idNo>362502199211161873</idNo>\n" +
                "    <customerName>ces</customerName>\n" +
                "    <mobileNo>13566531723</mobileNo>\n" +
                "  </body>\n" +
                "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>+89+nK7kYjCzHeILDtTULB3FGlI=</DigestValue></Reference></SignedInfo><SignatureValue>E2Hhr3Z14G/OzCtx5lhxZcUmgWcMCqZ1cVF0UOwt7nrG0OXDUGM4QFnGlbMDaEFv9t32i74GeYAb\n" +
                "ZwRgPbXgc0d/0evwVQZV/wbF5ksoyRjXVMD5SaXoZVZJa/+zuAAFcc9rqOWuFtkqqpUDcGb+Nfk7\n" +
                "BOoQ3nHGbBgNUJbo/CQ=</SignatureValue></Signature></message>";
        JSONObject jsonObject = XML.toJSONObject(xml1);
        String s = jsonObject.toString();

        System.out.println(jsonObject);

    }
}
