package httpclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class InetAddressTest {
    private final String stringUrl;

    public InetAddressTest(URL url) {
        this.stringUrl = String.valueOf(url);
    }

    public void getHostAddress() {
        System.out.println("URL" + " " + this.stringUrl);
    }

    public String getAddress() throws IOException {
        InetAddress dns;
        String hostAddress;

        String splitUrl = stringUrl.substring(8);
        dns = InetAddress.getByName(splitUrl);
        hostAddress = dns.getHostAddress();

        return hostAddress;
    }
}
