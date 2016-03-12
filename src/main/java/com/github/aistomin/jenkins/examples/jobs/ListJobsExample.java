package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.Jobs;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 12/03/16.
 *
 * This class demonstrates how to list Jenkins jobs, read details, search for
 * jobs etc.
 */
public class ListJobsExample {

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
        Jobs jobs = jenkins.jobs();
        System.out.println("----------------- JOBS -----------------");
        final Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job =  iterator.next();
            System.out.println(job.name());
        }
        System.out.println("----------------------------------------");
    }
}
