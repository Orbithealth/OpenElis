package org.bahmni.feed.openelis.event.objects.impl;

import org.bahmni.feed.openelis.externalreference.dao.ExternalReferenceDao;
import org.ict4h.atomfeed.client.domain.Event;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import us.mn.state.health.lims.panel.dao.PanelDAO;
import us.mn.state.health.lims.panel.valueholder.Panel;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LabPanelTest {

    @Mock
    PanelDAO panelDAO;
    @Mock
    ExternalReferenceDao externalReferenceDao;
    static final String EVENT_CONTENT = " {\"category\": \"panel\",\"description\": \"Test Panel\", \"list_price\": \"0.0\", \"name\": \"ECHO\", \"type\": \"service\", \"standard_price\": \"0.0\", \"uom_id\": 1, \"uom_po_id\": 1, \"categ_id\": 33, \"id\": 193}";
    LabPanel labPanel;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        labPanel = new LabPanel(panelDAO,externalReferenceDao);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldInsertNewIfExternalReferenceNotFound(){
        when(externalReferenceDao.getData(anyString())).thenReturn(null);

        Event event = new Event("554433221",EVENT_CONTENT);
        Panel panel = new Panel();
        panel.setName("ECHO");
        panel.setDescription("Test Panel");


        labPanel.save(event);

        verify(panelDAO).insertData(panel);
    }
}