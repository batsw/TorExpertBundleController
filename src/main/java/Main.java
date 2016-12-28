import com.batsw.tor_expert_bundle_controller.service.impl.*;
import com.batsw.tor_expert_bundle_controller.common.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.concurrent.TimeUnit;

public class Main {
    public  static final Logger log = LogManager.getLogger(Main.class);
    public static void main (String[] argv){
        try{
            ReturnValue result;
            TorchatConfigReader cfr = new TorchatConfigReader();
            TorchatcfgParser tcp = new TorchatcfgParser();
            TorrcFileParser trp = new TorrcFileParser();
            Bundle b = new Bundle(cfr, tcp, trp);
            result = b.getConfiguration();
            if (!result.getSuccess()) {
                log.error ("Invalid app configuration please contact suport");
            }
            b.run();
            TimeUnit.SECONDS.sleep(5);
            b.stop();
        } catch (Exception e ){
            log.error("Application stopped: " + e.getMessage());
        }
    }
}