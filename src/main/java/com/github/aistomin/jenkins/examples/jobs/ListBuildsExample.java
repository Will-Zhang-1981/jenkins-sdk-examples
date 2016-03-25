package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Build;
import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to list Jenkins job builds.
 */
public class ListBuildsExample {

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
        System.out.println("----------------- BUILDS -----------------");
        Iterator<Build> iterator = job.builds().iterator();
        while (iterator.hasNext()) {
            Build build =  iterator.next();
            System.out.println(build.number());
        }
        System.out.println("----------------------------------------");
    }
}
