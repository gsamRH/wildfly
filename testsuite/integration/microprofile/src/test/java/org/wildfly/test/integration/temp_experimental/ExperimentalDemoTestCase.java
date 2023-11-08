/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.wildfly.test.integration.temp_experimental;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.test.integration.microprofile.config.smallrye.AbstractMicroProfileConfigTestCase;

/**
 * @author <a href="http://jmesnil.net/">Jeff Mesnil</a> (c) 2017 Red Hat inc.
 * @author Jan Stourac <jstourac@redhat.com>
 */
@RunWith(Arquillian.class)
@RunAsClient
public class ExperimentalDemoTestCase extends AbstractMicroProfileConfigTestCase {

    @Deployment
    public static Archive<?> deploy() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "experimental.war")
                .addClasses(ExperimentalApplication.class);

        return war;
    }

    @Test
    public void testPriorityOrderingProperties() throws Exception {
        // Don't actually test anything, we're just interested in the server log messages at this stage
    }
}
