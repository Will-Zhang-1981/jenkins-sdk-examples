package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 12/03/16.
 *
 * This class demonstrates how to search Jenkins jobs.
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
        Iterator<Job> found = jenkins.jobs().findByName("<JOB TO SEARCH>");
        System.out.println("----------------- FOUND JOBS -----------------");
        while (found.hasNext()) {
            Job job =  found.next();
            System.out.println(job.name());
        }
        System.out.println("----------------------------------------------");
    }
}
