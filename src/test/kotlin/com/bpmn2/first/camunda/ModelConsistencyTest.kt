package com.bpmn2.first.camunda

import de.viadee.bpm.vPAV.ProcessApplicationValidator
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.junit.runner.RunWith
import org.springframework.context.ApplicationContext


@RunWith(SpringJUnit4ClassRunner::class)
class ModelConsistencyTest {

    @Autowired
    private val ctx: ApplicationContext? = null

    @Test
    fun validateModel() {
        assertTrue("Model inconsistency found. Please check target folder for validation output",
            ProcessApplicationValidator.findModelErrors(ctx).isEmpty())
    }
}
