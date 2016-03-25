package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to cancel build.
 */
public class CancelJobExample {

    /**
     * Jenkins delay between triggering job and build actually starts.
     */
    public static final Integer DELAY = 10000; // 10 seconds

    /**
     * Start example.
     *
     * Note: For testing this example please keep in mind two things:
     * 1. If job builds really fast it's difficult to get moment when build is
     *  running. Please, select builds which takes at least >= 1 minute.
     * 2. CancelJobExample.DELAY depends on your installation. Maybe your should
     *  increase this value if your Jenkins is not started builds immediately
     *  after triggering.
     *
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
        Thread.sleep(CancelJobExample.DELAY); // wait until build starts.
        job.builds().lastUnsuccessful().cancel();
        // look into your Jenkins web: cancelled build must be there.
    }
}
