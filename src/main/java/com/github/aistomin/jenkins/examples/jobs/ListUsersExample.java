package com.github.aistomin.jenkins.examples.jobs;

import com.github.aistomin.jenkins.Jenkins;
import com.github.aistomin.jenkins.User;
import com.github.aistomin.jenkins.Users;
import com.github.aistomin.jenkins.real.RealJenkins;
import com.github.aistomin.jenkins.real.UsernamePasswordCredentials;
import java.util.Iterator;

/**
 * Created by aistomin on 12/03/16.
 *
 * This class demonstrates how to list Jenkins users.
 */
public class ListUsersExample {

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
        Users users = jenkins.users();
        System.out.println("----------------- USERS -----------------");
        final Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user =  iterator.next();
            System.out.println(user.fullName());
        }
        System.out.println("----------------------------------------");
    }
}
