import com.batsw.tor_expert_bundle_controller.TorProcessFactory;
import com.batsw.tor_expert_bundle_controller.service.impl.Bundle;
import com.batsw.tor_expert_bundle_controller.common.ReturnValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Main {
    public  static final Logger log = LogManager.getLogger(Main.class);
    public static void main (String[] argv){
        try{
            ReturnValue result;
            TorProcessFactory torProcessFactory = new TorProcessFactory();
            Bundle b = torProcessFactory.getTorProcess();
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