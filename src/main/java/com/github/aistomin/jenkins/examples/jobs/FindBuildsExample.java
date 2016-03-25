package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Build;
import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to search Jenkins jobs.
 */
public class FindBuildsExample {

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
        final Iterator<Build> found = jenkins.jobs().findByName("<JOB NAME>")
            .next().builds().findByNumber("<BUILD NUMBER>");
        System.out.println("----------------- FOUND BUILDS -----------------");
        while (found.hasNext()) {
            Build build =  found.next();
            System.out.println(build.details().fullDisplayName());
        }
        System.out.println("----------------------------------------------");
    }
}
