package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 12/03/16.
 *
 * This class demonstrates how to list Jenkins jobs, read details, search for
 * jobs etc.
 */
public class FindJobsExample {

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
        final Iterator<Job> iterator = jenkins.jobs().findByName("<JOB TO SEARCH>");
        System.out.println("----------------- FOUND JOBS -----------------");
        while (iterator.hasNext()) {
            Job job =  iterator.next();
            System.out.println(job.name());
        }
        System.out.println("----------------------------------------------");
    }
}
