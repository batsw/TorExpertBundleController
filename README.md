# TorExpertBundleController

## Purpose
Tor expert bundle controller provides an easy to use interface that helps you manage the tor expert bundle lifecycle. 
Features:
- Start stop Tor expert bundle
- Read log messages of Tor expert bundle
- Retrive the hidden service directory hostname
- Get information about used ports

## Notes:
The current version runs on Windows systems.
  
## What is Tor Expert Bundle? 
Tor is a program you can run on your computer that helps keep you safe on the Internet. It protects you by bouncing your communications around a distributed network of relays run by volunteers all around the world: it prevents somebody watching your Internet connection from learning what sites you visit, and it prevents the sites you visit from learning your physical location. This set of volunteer relays is called the Tor network. More information can be found [here] (https://www.torproject.org/docs/faq.html.en#WhatIsTor). 

Tor expert bundle (you can dowload it from [here](https://www.torproject.org/download/download)) is basically a proxy that 
allows you to connect to `Tor network` using seockets.

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
### Development details
- Platform: Windows 10 Pro 
- IDE: IntelliJ IDEA 2016.2.5
- Build system: Maeven 3.0.5
- Dependencies: log4j 2.7, json-simple 1.1.1 

## Building the project 

### Building project in Intelij
Steps: 
- use gitbash to clone the  repository
- Start Intelij 
- File -> Open -> Select project location 
- Maven Projects -> Execute Maven Goal -> Set command line parameter to package -> Execute

### Building project in Eclipse
Steps
- use gitbash to clone the  repository
- Start Eclipse 
- File ->  Open project From File... -> Select project location -> Finish
- Right Click pom.xml -> Run as -> Maeven Build  

### Using the library
Import as a jar file the
