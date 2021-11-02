package LoginSystem;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> loginInfo = new HashMap();

    IDandPasswords() {
        loginInfo.put("POSEIDON","123");
        loginInfo.put("HADES","456");
        loginInfo.put("ZEUS","789");
    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
