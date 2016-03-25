package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.User;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 25/03/16.
 *
 * This class demonstrates how to search Jenkins users.
 */
public class FindUsersExample {

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
        final Iterator<User> found = jenkins.users()
            .findByUsername("<USERNAME>");
        System.out.println("----------------- FOUND USERS -----------------");
        while (found.hasNext()) {
            User user =  found.next();
            System.out.println(user.fullName());
        }
        System.out.println("----------------------------------------------");
    }
}
