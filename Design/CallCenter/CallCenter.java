import java.util.Random;
import java.lang.Runnable;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class CallCenter implements AvailableListener {
	
	
	private Queue<Call> queue;
	private Map<Level, List<Employee>> map;
	
	private static CallCenter instance;
	
	public static CallCenter getInstance() {
		if (instance == null) {
			instance = new CallCenter();
		}
		return instance;
	}
	
	private CallCenter() {
		queue = new LinkedList<Call>();
		map = new HashMap<Level, List<Employee>>();
	}
	
	public void addEmployee(Employee employee, Level level) {
		List<Employee> list = map.get(level);
		if (list == null) {
			list = new ArrayList<Employee>();
			map.put(level, list);
		}
		employee.setAvailableListener(this);
		list.add(employee);
	}
	
	public void processCall(Call call) {
		for (Level level : Level.values()) {
			List<Employee> list = map.get(level);
			if (list != null) {
				for (Employee e : list) {
					if (e.dispetchCall(call)) {
						System.out.println("Found available employee!");
						return;
					}
				}
			}
			System.out.println("No available employees on level " + level);
		}
		
		System.out.println("Sorry, all our employees are occupied. Please, wait...");
		queue.add(call);
	}
	
	@Override
	public void becomeAvailable(Employee e) {
		if (!queue.isEmpty()) {
			System.out.println("Employee become available. Answering call from queue...");
			e.dispetchCall(queue.poll());
		}
	}
	
	public static void main(String[] args) {
		CallCenter callCenter = CallCenter.getInstance();
		callCenter.addEmployee(new Employee(), Level.RESPONDER);
		callCenter.addEmployee(new Employee(), Level.RESPONDER);
		callCenter.addEmployee(new Employee(), Level.RESPONDER);
		callCenter.addEmployee(new Employee(), Level.MANAGER);
		callCenter.addEmployee(new Employee(), Level.MANAGER);
		callCenter.addEmployee(new Employee(), Level.DIRECTOR);
		
		int nCalls = 10;
		Random r = new Random();
		while (nCalls > 0) {
			StringBuilder phoneNumber = new StringBuilder();
			phoneNumber.append(r.nextInt(900) + 100);
			phoneNumber.append("-");
			phoneNumber.append(r.nextInt(900) + 100);
			phoneNumber.append("-");
			phoneNumber.append(r.nextInt(9000) + 1000);
			
			Call call = new Call(phoneNumber.toString());
			callCenter.processCall(call);
			
			try{
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Call centre is down");
			}
			
			--nCalls;			
		}
	}
	
}