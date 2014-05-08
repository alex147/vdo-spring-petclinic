/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.util.DbPopulatingUtil;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Integration test using the 'vDO' profile.
 * 
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details.
 *      </p>
 * @author akanchev
 */
@ContextConfiguration(locations = { "classpath:spring/business-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("vdo")
public class ClinicServiceVdoTests extends AbstractClinicServiceTests {

    @Autowired
    private DbPopulatingUtil populatingUtil;
}
