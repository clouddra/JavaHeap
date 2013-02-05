import java.util.*;

// A0072292H
// Chong Yun Long

class SchedulingDeliveries {

	private Heap hospital;

	public SchedulingDeliveries() {
		hospital = new Heap(10000);
	}

	void ArriveAtHospital(String womanName, double dilationStatus) {
		hospital.heapInsert(womanName, dilationStatus);
	}

	void UpdateStatus(String womanName, double increaseDilation) {
		hospital.update(womanName, increaseDilation);
	}

	void GiveBirth(String womanName) {
		hospital.heapExtract(womanName);
	}

	String Query() {
		if (hospital.isEmpty())
			return "The delivery suite is empty";

		return hospital.getMax().name;
	}

	void run() {
		// do not alter this method
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N-- > 0) {
			int cmd = sc.nextInt();
			switch (cmd) {
			case 0:
				ArriveAtHospital(sc.next(), sc.nextDouble());
				break;
			case 1:
				UpdateStatus(sc.next(), sc.nextDouble());
				break;
			case 2:
				GiveBirth(sc.next());
				break;
			case 3:
				System.out.println(Query());
				break;
			}
		}
	}

	public static void main(String[] args) {
		// do not alter this method
		SchedulingDeliveries ps2 = new SchedulingDeliveries();
		ps2.run();
	}
}
