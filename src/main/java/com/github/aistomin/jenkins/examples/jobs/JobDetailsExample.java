package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.Job;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 20/03/16.
 *
 * This class demonstrates how to read job details.
 */
public class JobDetailsExample {

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
        Iterator<Job> jobs = jenkins.jobs().iterator();
        while (jobs.hasNext()) {
            Job job = jobs.next();
            System.out.println("job.details().displayName() = " + job.details().displayName());
            System.out.println("job.details().description() = " + job.details().description());
            System.out.println("job.details().buildable() = " + job.details().buildable());
            System.out.println("job.url() = " + job.url());

        }
    }
}
