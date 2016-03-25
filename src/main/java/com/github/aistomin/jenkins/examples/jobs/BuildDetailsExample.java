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
 * This class demonstrates how to read job build details.
 */
public class BuildDetailsExample {

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
        final Iterator<Build> builds = job.builds().iterator();
        while (builds.hasNext()) {
            Build build = builds.next();
            System.out.println(
                "build.details().fullDisplayName() = "
                    + build.details().fullDisplayName()
            );
            System.out.println(
                "build.details().displayName() = "
                    + build.details().displayName()
            );
            System.out.println(
                "build.details().duration() = " + build.details().duration()
            );
            System.out.println(
                "build.result().name() = " + build.result().name()
            );
        }
    }
}
