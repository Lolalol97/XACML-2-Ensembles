package org.palladiosimulator.pcm.dataprocessing.dynamicextension.ensemblesgeneration.tests;

import org.junit.*;
import org.palladiosimulator.pcm.dataprocessing.dynamicextension.ensemblesgeneration.generation.scala.ValueDeclaration;

public class ValueDeclarationTest {
    private ValueDeclaration normal;
    private ValueDeclaration optional;
    
    @Before
    public void setUp() {
        this.normal = new ValueDeclaration("name", "t", false);
        this.optional = new ValueDeclaration("name", "t", true);
    }
    
    @Test
    public void normalNameTest() {
        Assert.assertEquals("name", this.normal.getName());
    }
    
    @Test
    public void normalDeclarationTest() {
        Assert.assertEquals("val name: t", this.normal.getCodeDefinition().toString());
    }
    
    @Test
    public void optionalNameTest() {
        Assert.assertEquals("name", this.optional.getName());
    }
    
    @Test
    public void optionalDeclarationTest() {
        Assert.assertEquals("val name: t = null", this.optional.getCodeDefinition().toString());
        this.optional =  new ValueDeclaration("name", "Int", true);
        Assert.assertEquals("val name: Int = 0", this.optional.getCodeDefinition().toString());
    }
}
