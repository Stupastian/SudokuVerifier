import static org.junit.Assert.assertEquals;

public class SudokuVerifierTestRowsAndNumbers {
	private String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private String shortString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
	private String wrongGridString = "417369825132158947958724316825437169791586432346912758289643571573291684164875293";

	public void testVerify_StringLength() {
		SudokuVerifier verifier = new SudokuVerifier();
		assertEquals("Correct String returns 0", 0, verifier.verify(correctString));
		assertEquals("Too long string returns -1", -1, verifier.verify(correctString + "6"));
		assertEquals("Too short string returns -1", -1, verifier.verify(shortString));
	}

	public void testVerify_subGrid0_9() {
		SudokuVerifier verifier = new SudokuVerifier();
		assertEquals("Each subgrid can only contain one of each number", -2, verifier.verify(shortString + "1"));
		assertEquals("Each subgrid can only contain one of each number", 0, verifier.verify(correctString));
		assertEquals("Each subgrid can only contain one of each number", -2, verifier.verify(wrongGridString));
	}

	public void testVerify_NumberFormat0_9() {
		SudokuVerifier verifier = new SudokuVerifier();
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "k"));
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "0"));
		assertEquals("Only numbers 1-9 should be allowed", -1, verifier.verify(shortString + "10"));
	}
}