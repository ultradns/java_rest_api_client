package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.client.exception.UltraClientException;
import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;
import com.ultradns.ultra.rest.dto.AccountList;
import com.ultradns.ultra.rest.dto.RRSet;
import com.ultradns.ultra.rest.dto.RRSetList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/*
 * User: kbhandar
 * Date: 10/24/19
 *
 * Copyright 2019 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class RestApiClientRDTest extends AbstractBaseRestApiClientTest {
    private static final Logger LOG = LoggerFactory.getLogger(RestApiClientRDTest.class);

    private String zoneName;
    private String accountName;

    @Before
    public void setup() throws IOException {
        zoneName = getRandomZoneName();

        AccountList accountList = REST_API_CLIENT.getAccountDetails();
        assertNotNull(accountList);
        accountName = accountList.getAccounts().get(0).getAccountName();
        assertNotNull(accountName);
        LOG.debug("accountName = " + accountName);

        String result = REST_API_CLIENT.createPrimaryZone(accountName, zoneName);
        assertNotNull(result);
        LOG.debug("result = " + result);
    }

    @After
    public void cleanup() throws IOException {
        try {
            REST_API_CLIENT.deleteZone(zoneName);
        } catch (UltraClientException e) {
            // do nothing
        }
    }

    @Test
    public void convertARecordToRDPool() throws IOException {
        // Test data
        String ownerName = "owner-1." + zoneName;
        String recordType = "A";
        Integer ttl = 300;

        // Create a single A record for the ownerName
        List<String> rdata = Lists.newArrayList("1.1.1.1");
        RRSet rrSet = new RRSet(zoneName, ownerName, recordType, ttl, rdata, null);
        String result = REST_API_CLIENT.createRRSet(zoneName, rrSet);
        assertNotNull(result);
        LOG.debug("result = " + result);

        // Retrieve the created A record; pass the owner-name in the query string
        RRSetList rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "match:EXACT owner:" + ownerName, 0,
                MAX_PAGE_SIZE, UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertTrue(rrsets.getRrSets().get(0).getProfile().isEmpty());

        // Update ownerName RRSet to RD Pool
        Map<String, Object> profile = Maps.newHashMap();
        profile.put("@context", UltraRestSharedConstant.ProfileType.RD_POOL.getContext());
        profile.put("order", "ROUND_ROBIN");
        profile.put("description", "This is a new RD Pool");

        rdata = Lists.newArrayList("1.1.1.1", "2.2.2.2");
        rrSet = new RRSet(zoneName, ownerName, recordType, ttl, rdata, null);
        rrSet.setProfile(profile);
        result = REST_API_CLIENT.updateRRSet(zoneName, rrSet);
        assertNotNull(result);
        LOG.debug("result = " + result);

        // Retrieve the created RD Pool; pass the owner-name in the query string
        rrsets = REST_API_CLIENT.getRRSetsByType(zoneName, "A", "match:EXACT owner:" + ownerName, 0, MAX_PAGE_SIZE,
                UltraRestSharedConstant.RRListSortType.OWNER, false);
        assertNotNull(rrsets);
        LOG.debug("rrsets = " + rrsets);
        assertNotNull(rrsets.getRrSets());
        assertNotNull(rrsets.getRrSets().get(0));
        assertNotNull(rrsets.getRrSets().get(0).getProfile());
        assertEquals(UltraRestSharedConstant.ProfileType.RD_POOL.getContext(),
                rrsets.getRrSets().get(0).getProfile().get("@context"));
        assertEquals("ROUND_ROBIN", rrsets.getRrSets().get(0).getProfile().get("order"));
    }
}
