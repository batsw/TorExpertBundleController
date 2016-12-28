package com.batsw.tor_expert_bundle_controller.service.i;

import com.batsw.tor_expert_bundle_controller.common.ReturnValue;
/**
 * Interface used to start manage the lifecycle of Tor Bundle expert
 */
public interface IBundleProcess<T> {

     ReturnValue run();

     ReturnValue stop();

     ReturnValue getConfiguration();

     Process getProcessHandle();

     T getBundleInfo();

     String getHostname();
}