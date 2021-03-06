package com.itz.cloud.cmd;

/**
 * @author CodeZhang
 * @ProjectName cloud-learning
 * @Package com.itz.cloud
 * @Version 1.0
 * @date 2021/3/6 23:47
 */
public class WindowsShowCmd implements ShowCmd {

    @Override
    public String show() {
        return "dir";
    }
}
