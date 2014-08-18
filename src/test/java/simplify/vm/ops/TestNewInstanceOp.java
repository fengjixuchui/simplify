package simplify.vm.ops;

import gnu.trove.map.TIntObjectMap;

import java.util.logging.Logger;

import org.junit.Test;

import simplifier.Main;
import simplifier.vm.type.LocalInstance;
import simplifier.vm.type.UninitializedInstance;
import simplify.vm.VMTester;

public class TestNewInstanceOp {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(Main.class.getSimpleName());

    private static final String CLASS_NAME = "Lnew_instance_test;";

    @Test
    public void TestLocalClass() {
        TIntObjectMap<Object> initial = VMTester.buildRegisterState(0, 1);
        TIntObjectMap<Object> expected = VMTester.buildRegisterState(0, new LocalInstance(CLASS_NAME));

        VMTester.testState(CLASS_NAME, "TestLocalClass()V", initial, expected);
    }

    @Test
    public void TestNonLocalClass() {
        TIntObjectMap<Object> initial = VMTester.buildRegisterState(0, 1);
        TIntObjectMap<Object> expected = VMTester.buildRegisterState(0,
                        new UninitializedInstance("Ljava/lang/Integer;"));

        VMTester.testState(CLASS_NAME, "TestNonLocalClass()V", initial, expected);
    }

}
