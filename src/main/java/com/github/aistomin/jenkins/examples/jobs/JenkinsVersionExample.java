package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;

/**
 * Created by aistomin on 12/03/16.
 *
 * This class demonstrates how to get Jenkins version.
 */
public class JenkinsVersionExample {

    /**
     * Start example.
     * @param args Ignore them.
     * @throws Exception If something is wrong.
     */
    public static void main(String[] args) throws Exception {
        Jenkins jenkins = new RealJenkins(
            "<YOUR JENKINS URL>",
            new UsernamePasswordCredentials("<USERNAME>", "<PASSWORD>")
        );
        System.out.println("Version: " + jenkins.version());
    }
}
