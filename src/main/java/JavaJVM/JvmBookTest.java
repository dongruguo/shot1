package JavaJVM;

 class JvmBook {
	private String bookName;

	public JvmBook(String bookName) {
		this.bookName = bookName;
		System.out.println(bookName + " is created");
		
	}
	public void isAlive() {
		System.out.println("1111");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(bookName + " is freed");
	}
}

 public class JvmBookTest {
    public static void main(String args[]) {
    	JvmBook l1 = new JvmBook("book1");
    	JvmBook l2 = new JvmBook("book2");
        l1 = l2 = null;
        System.gc();
        l1.isAlive();
    }
}