package com.XMonitor.curator.controller;

import com.XMonitor.curator.core.ZookeeperFactory;
import com.XMonitor.curator.zk.ZookeeperHosts;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ksy on 2015/6/11.
 */

@Controller
@RequestMapping("/zk")
public class ZKController {

    @Autowired
    ZookeeperFactory zkFactory;

    @RequestMapping(value = "/connect", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object getCheck(@RequestParam(value = "connectString") String connectString) throws Exception {
//        ZookeeperHosts zh = new ZookeeperHosts(connectString);
//        return zh.hostInfos();
        CuratorFramework client = zkFactory.createClient(connectString);
        if(client != null){
            return "success";
        }
        return "fail";
    }
}
