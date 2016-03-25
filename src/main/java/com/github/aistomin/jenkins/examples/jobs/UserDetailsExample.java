package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.User;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to read user details.
 */
public class UserDetailsExample {

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
        final Iterator<User> users = jenkins.users().iterator();
        while (users.hasNext()) {
            User user = users.next();
            System.out.println("user.fullName() = " + user.fullName());
            System.out.println("user.username() = " + user.username());
            System.out.println("user.email() = " + user.email());
            System.out.println("user.url() = " + user.url());
            System.out.println("user.description() = " + user.description());
        }
    }
}
