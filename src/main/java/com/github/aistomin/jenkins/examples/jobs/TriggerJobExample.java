package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to trigger new build.
 */
public class TriggerJobExample {

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
        Job job = jenkins.jobs().findByName("<JOB NAME>").next();
        job.trigger();
        // look into your Jenkins web: new build must appear.
    }
}
