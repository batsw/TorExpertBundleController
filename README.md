# TorExpertBundleController
## Description
Provides an easy to use interface that helps you manage the tor expert bundle lifecycle

## Version
The current version runs only on Windows 

## Example 

```
import com.batsw.tor_expert_bundle_controller.TorProcessFactory;
import com.batsw.tor_expert_bundle_controller.service.impl.Bundle;
import com.batsw.tor_expert_bundle_controller.common.ReturnValue;

import java.util.concurrent.TimeUnit;

public class Main {
  //  public  static final Logger log = LogManager.getLogger(Main.class);
    public static void main (String[] argv){
        try{
            ReturnValue result;
            TorProcessFactory torProcessFactory = new TorProcessFactory();
            Bundle b = torProcessFactory.getTorProccess();
            result = b.getConfiguration();
            if (!result.getSuccess()) {
                return ;
            }
            b.run();
            TimeUnit.SECONDS.sleep(5);
            b.stop();
        } catch (Exception e ){
   
        }
    }
}
```

