package com.mk.zzdats_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class ZzdatsDemoApplicationTests {

	@Autowired
	private BernsService bernsService;

	@Autowired
    private BernudarzsService bernudarzsService;

	@Test
	void bernsToRinda() {
	    Bernudarzs bernudarzs = bernudarzsService.list().get(1);
	    Integer before = bernudarzs.getRinda().size();
	    Berns berns = new Berns();
	    berns.setfName("Vasilijs");
	    berns.setlName("Pupkins");
	    berns.setPersCode("101010-10101");
	    berns.setBrOrSist(false);
	    berns.setAiznemtaRinda(bernudarzs);
	    bernsService.save(berns);
        bernudarzs = bernudarzsService.list().get(1);
	    assertEquals(before + 1, bernudarzs.getRinda().size());
	}

	@Test
    void saveAndDeleteBerns() {
        //assert Berns with given persCode doesnt exist in given queue
	    Berns berns = bernudarzsService.findByPk("101010-10101", new Long(1));
        assertNull(berns);

        //add Berns
        berns = new Berns();
        berns.setfName("Vasilijs");
        berns.setlName("Pupkins");
        berns.setPersCode("101010-10101");
        berns.setBrOrSist(false);
        berns.setAiznemtaRinda(bernudarzsService.getById(new Long(1)));

        //assert Berns exist in given queue
        bernsService.save(berns);
        assertNotNull(bernudarzsService.findByPk("101010-10101", new Long(1)));

        //delete Berns by given persCode and queue and assert it doesnt exist
        bernsService.delete(bernudarzsService.findByPk("101010-10101", new Long(1)));
        assertNull(bernudarzsService.findByPk("101010-10101", new Long(1)));
    }

}
