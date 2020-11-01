import com.normAlgorithm.mikrise2.main
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


internal class IntegrationTest {
    @Test
    fun mainTest() {

        val baos = ByteArrayOutputStream()
        val ps = PrintStream(baos)
        val old = System.out
        System.setOut(ps)
        main(arrayOf("src\\integTest\\resources\\input.txt"))
        System.out.flush()
        System.setOut(old)
        val expectedVariable = "xxxddd"
        Assertions.assertEquals(expectedVariable, baos.toString())
    }

}