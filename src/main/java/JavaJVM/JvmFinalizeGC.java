package JavaJVM;

public class JvmFinalizeGC {
		
		private static JvmFinalizeGC SAVE_HOOK = null;
		
		public void isAlive() {
			System.out.println("YES , i am alive");
		}
		@Override
		public void finalize() throws Throwable{
			super.finalize();
			System.out.println("finalize Method excute");
			this.SAVE_HOOK = this;
		}
		
		public static void main(String[] args) throws Throwable{
			SAVE_HOOK = new JvmFinalizeGC();
			SAVE_HOOK = null;
			System.gc();
			Thread.sleep(500);
			if(SAVE_HOOK !=null) {
				SAVE_HOOK.isAlive();
			}else {
				System.out.println("SAVE_HOOK is dead");
			}
			
			SAVE_HOOK = null;
			System.gc();
			Thread.sleep(500);
			if(SAVE_HOOK !=null) {
				SAVE_HOOK.isAlive();
			}else {
				System.out.println("SAVE_HOOK is dead");
			}
			
			
		}
}
