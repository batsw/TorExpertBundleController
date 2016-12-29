package com.batsw.tor_expert_bundle_controller;

import com.batsw.tor_expert_bundle_controller.service.impl.*;


public class TorProcessFactory {
    private TorchatConfigReader cfr;
    private TorchatcfgParser tcp;
    private TorrcFileParser trp;

    public  Bundle getTorProcess()
    {
        cfr  = new TorchatConfigReader();
        tcp = new TorchatcfgParser();
        trp = new TorrcFileParser();
        return new Bundle(cfr, tcp, trp);
    }
}
