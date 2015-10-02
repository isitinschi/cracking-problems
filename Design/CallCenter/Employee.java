public class Employee {
	
	private boolean free = true;
	private AvailableListener listener;
	
	public boolean isFree() {
		return free;
	}
	
	public void setAvailableListener(AvailableListener listener) {
		this.listener = listener;
	}
	
	public boolean dispetchCall(Call call) {
		if (free) {
			return answerCall(call);
		}		
		return false;
	}
	
	private boolean answerCall(final Call call) {
		free = false;
		final Employee cur = this;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Employee is answering the call from " + call.getPhoneNumber() + "...");
				System.out.println("Talking...");
				try {
					Thread.currentThread().sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("Call was aborted!");
				}
				System.out.println("Call is finished.");
				free = true;
				if (listener != null) {
					listener.becomeAvailable(cur);
				}
			}
			
		}).start();		
		return true;
	}
	
}