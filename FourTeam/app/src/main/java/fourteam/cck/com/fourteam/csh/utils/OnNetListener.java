package fourteam.cck.com.fourteam.csh.utils;

import java.io.IOException;


public interface OnNetListener {
    public void onSuccess(Object o) throws IOException;
    public void onError(IOException e);
}
